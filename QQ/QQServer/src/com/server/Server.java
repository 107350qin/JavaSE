package com.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.model.Message;
import com.util.FileUtil;

public class Server {

	public static void main(String[] args) {
		new Server();
	}
	/**
	 * 装了所有在线的客户端的socket
	 */
	private Map<String, Socket> map = new HashMap<>();
	
	public Server() {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("服务器启动");
			while(true) {
				System.out.println("等待客户端的连接");
				Socket socket = serverSocket.accept();
				Message message = (Message) FileUtil.readObject(socket.getInputStream());
				if(message.getType() == Message.LOGIN) {
					String from = message.getFrom();
					map.put(from, socket);
					System.out.println(from+"连接成功");
					message = new Message();
					message.setType(Message.LOGIN);
					message.setMessage("true");
					FileUtil.sendObject(message, socket.getOutputStream());
					//启动为该socket服务器的线程
					new AcceptMessageThread(socket, map).start();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
		System.out.println();
	}
}
