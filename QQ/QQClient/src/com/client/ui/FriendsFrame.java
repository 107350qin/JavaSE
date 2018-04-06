package com.client.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Message;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class FriendsFrame extends JFrame {

	private JPanel contentPane;
	
	private String self;
	
	private Socket socket;
	
	private JList list;
	
	private Map<String, Talk> talks = new HashMap<>();
	
	private Talk groupTalk;

	/**
	 * Create the frame.
	 */
	public FriendsFrame(Socket socket,String self) {
		this.socket = socket;
		this.self = self;
		setTitle(self);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 180, 355);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//显示好友的列表
		//启动接收消息的线程
		new AcceptMessageThread(socket, this).start();
	}
	
	/**
	 * 创建聊天窗口
	 */
	public Talk showTalk(String from,String to) {
		if(talks.containsKey(to)) {
			return talks.get(to);
		}else {
			Talk talk = new Talk(socket, from, to,Message.MESSAGE);
			talks.put(to, talk);
			return talk;
		}
	}
	
	
	/**
	 * 刷新好友列表
	 * @param list
	 * @param msg
	 */
	public void refreshFriends(Message msg) {
		contentPane.removeAll();
		//显示好友的列表
		list = new JList<>(msg.getFriends().toArray());
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//双击
				if(e.getClickCount() == 2) {
					System.out.println("双击执行");
					//根据鼠标在list中的坐标确定点击的是哪一个人
					int index = list.locationToIndex(e.getPoint());
					//通过下标找到对应的人
					String to = msg.getFriends().get(index);
					Talk talk = showTalk(self, to);
					talk.setVisible(true);
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(list);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		JButton group = new JButton("群发");
		//群发功能
		group.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(groupTalk == null) {
					groupTalk = new Talk(socket, self, "群发",Message.GROUP);
				}
				groupTalk.setVisible(true);
			}
		});
		contentPane.add(group,BorderLayout.SOUTH);
		contentPane.updateUI();
	}
	
	public Talk getGroupTalk() {
		if(groupTalk == null) {
			groupTalk = new Talk(socket, self, "群发",Message.GROUP);
		}
		return groupTalk;
	}

}
