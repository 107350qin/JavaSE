package com.client.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Message;
import com.util.FileUtil;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 224, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("用户名");
		label.setBounds(10, 45, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(51, 42, 133, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					try {
						Socket socket = new Socket("192.168.1.63", 8888);
						Message message = new Message();
						message.setType(Message.LOGIN);
						message.setFrom(textField.getText());
						//写出对象
						FileUtil.sendObject(message, socket.getOutputStream());
						//服务器返回登录的结果
						message = (Message) FileUtil.readObject(socket.getInputStream());
						if(message.getType() == Message.LOGIN && "true".equals(message.getMessage())) {
							LoginFrame.this.dispose();//销毁登录窗口
							//显示好友列表
							new FriendsFrame(socket,textField.getText()).setVisible(true);
						}
					} catch (UnknownHostException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
		});
		button.setBounds(57, 128, 93, 23);
		contentPane.add(button);
	}
}
