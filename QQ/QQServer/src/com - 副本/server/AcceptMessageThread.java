package com.server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.model.Message;
import com.util.FileUtil;

public class AcceptMessageThread extends Thread{

	private Socket socket;
	
	private Map<String, Socket> map;

	public AcceptMessageThread(Socket socket,Map<String, Socket> map) {
		super();
		this.socket = socket;
		this.map = map;
	}
	
	@Override
	public void run() {
		super.run();
		//刷新下其他人的好友数据
		Message msg = new Message();
		msg.setType(Message.FRIENDS);
		//好友数据
		Set<String> sets = map.keySet();
		List<String> list = new ArrayList<>();
		for (String string : sets) {
			list.add(string);
		}
		msg.setFriends(list);
		//刷新所有人的好友数据
		for (Entry<String, Socket> string : map.entrySet()) {
			Socket s = string.getValue();
			try {
				FileUtil.sendObject(msg, s.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//不停的接收消息  如果没有消息就阻塞当前线程  直到有消息以后就继续处理消息
		while(true) {
			try {
				msg = (Message) FileUtil.readObject(socket.getInputStream());
				if(msg.getType() == Message.MESSAGE) {
					//单发
					Socket toSocket = map.get(msg.getTo());
					FileUtil.sendObject(msg, toSocket.getOutputStream());
				}else if(msg.getType() == Message.GROUP) {
					//群发
					Set<Entry<String, Socket>> socs = map.entrySet();
					for (Entry<String, Socket> entry : socs) {
						Socket s = entry.getValue();
						FileUtil.sendObject(msg, s.getOutputStream());
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
