package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import resources.AcceptThreadServer;
import resources.Data;
import resources.Tools;

public class Server {
	public  Map<String, Socket> map = new HashMap<>();

	public static void main(String[] args) {
		new Server();
	}

	@SuppressWarnings("resource")
	public Server() {
		ServerSocket serverSocket=null;
		try {
			serverSocket=new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//启动接受处理消息的线程,该线程不能放在while后面，因为是死循环
		while(true) {
			try {
				System.out.println("服务器等待连接...");
				Socket socket=serverSocket.accept();
				Data data0=Tools.recieve(socket);
				System.out.println(data0.getFrom()+"连接成功");
				if(data0.getType()==Data.LOGIN) { 
					map.put(data0.getFrom(), socket);
					
					//添加到集合之后就可以向每个人发送刷新的数据包了
					Data data1=new Data("", "", "登陆成功", Data.LOGIN,Tools.setToStrings(map.keySet()));
					Tools.send(data1, socket);
					//每次添加一个人就启动一个线程
					new AcceptThreadServer(socket,map).start();
				}
//				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
