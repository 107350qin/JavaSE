package com.client.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Message;
import com.util.FileUtil;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Talk extends JFrame {

	private JPanel contentPane;
	
	private Socket socket;
	
	private String from;//自己是谁
	
	private String to;//发给谁
	
	private JTextArea show;//显示聊天信息


	/**
	 * Create the frame.
	 */
	public Talk(Socket socket,String from,String to,int type) {
		this.socket = socket;
		this.from = from;
		this.to = to;
		setTitle(to);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 244, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		show = new JTextArea();
		show.setEditable(false);
		show.setPreferredSize(new Dimension(0, 170));
		JScrollPane scrollPane = new JScrollPane(show);
		contentPane.add(scrollPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JTextArea input = new JTextArea();
		panel.add(input, BorderLayout.CENTER);
		JButton button = new JButton("发送");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Message message = new Message();
				message.setType(type);
				message.setFrom(from);
				message.setTo(to);
				String content = input.getText();
				message.setMessage(content);
				//清空当前输入框
				input.setText("");
				if(!from.equals(to) && type != Message.GROUP)
					show.append("你说:"+content+"\n");
				//将消息发送出去
				try {
					FileUtil.sendObject(message, socket.getOutputStream());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		panel.add(button, BorderLayout.EAST);
	}
	/**
	 * 显示聊天信息
	 * @param content
	 */
	public void showMessage(Message msg) {
		show.append(msg.getFrom()+"说:"+msg.getMessage()+"\n");
	}

}
