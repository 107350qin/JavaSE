package com.client.ui;

import java.io.IOException;
import java.net.Socket;

import com.model.Message;
import com.util.FileUtil;

public class AcceptMessageThread extends Thread{

	private Socket socket;
	
	private FriendsFrame friendsFrame;
	
	public AcceptMessageThread(Socket socket,FriendsFrame friendsFrame) {
		super();
		this.socket = socket;
		this.friendsFrame = friendsFrame;
	}
	
	@Override
	public void run() {
		super.run();
		//不停的接收消息  如果没有消息就阻塞当前线程  直到有消息以后就继续处理消息
		while(true) {
			try {
				Message msg = (Message) FileUtil.readObject(socket.getInputStream());
				if(msg.getType() == Message.MESSAGE) {
					//单发
					Talk talk = friendsFrame.showTalk(msg.getTo(), msg.getFrom());
					talk.showMessage(msg);
					talk.setVisible(true);
				}else if(msg.getType() == Message.GROUP) {
					//群发
					Talk groupTalk = friendsFrame.getGroupTalk();
					groupTalk.showMessage(msg);
					groupTalk.setVisible(true);
				}else if(msg.getType() == Message.FRIENDS) {
					//刷新自己的好友列表
					System.out.println("接收刷新消息");
					friendsFrame.refreshFriends(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
