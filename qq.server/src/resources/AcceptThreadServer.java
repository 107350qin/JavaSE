package resources;

import java.io.IOException;
import java.net.Socket;
import java.util.Map;

public class AcceptThreadServer extends Thread {
	private Map<String, Socket> map;
	private Socket socket;

	public AcceptThreadServer(Socket socket, Map<String, Socket> map) {
		super();
		this.map = map;
		this.socket = socket;
	}

	// 服务器接受线程
	public void run() {
		try {
			// 该线程首先做的事：给所有的人发送好友列表[不需要判断类型了，因为好友上线就必须刷新]
			String[] string = Tools.setToStrings(map.keySet());
			for (int i = 0; i < string.length; i++) {
				// 拿到每一个socket
				Socket socket0 = map.get(string[i]);
				// 发送所有的好友列表
				Data data2 = new Data(null, string[i], "刷新", Data.REFRESH, string);
				Tools.send(data2, socket0);
			}
			
			//其次要做的是：连续不断地接受其他人发送的消息并且判断类型，再返回数据包
			while(true) {
				Data data=Tools.recieve(socket);
				if(data.getType()==Data.MESSAGE) {
					//如果发送的信息是普通类型，就找到接受着对应的socket，将数据包发送过去
					Tools.send(data,map.get(data.getTo()));
				}
				if(data.getType()==Data.GROUP) {
					for(String string2:map.keySet()) {
						if(!string2.equals(data.getFrom())) {//如果是发起者发送的就不再发送给他
							Data data2=new Data(data.getFrom(), string2, data.getMessage(), Data.GROUP, null);
							Tools.send(data2,map.get(string2));
						}
					}
				}
				if(data.getType()==Data.CLOSE) {
					map.remove(data.getFrom());//移除
					string = Tools.setToStrings(map.keySet());//刷新
					for (int i = 0; i < string.length; i++) {
						Socket socket0 = map.get(string[i]);
						Data data2 = new Data(null, string[i], "刷新", Data.REFRESH, string);
						Tools.send(data2, socket0);
					}
					//发送
					Tools.send(new Data("", "", "", Data.CLOSE, null), socket);
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
