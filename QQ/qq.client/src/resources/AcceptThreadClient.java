package resources;

import java.net.Socket;
import java.util.Date;

import client.HomeJFrame;
import client.OneToOneJFrame;

public class AcceptThreadClient extends Thread {
	private Socket socket;
	private HomeJFrame homeJFrame;
	private boolean b=true;
	public AcceptThreadClient(Socket socket, HomeJFrame homeJFrame) {
		this.socket = socket;
		this.homeJFrame = homeJFrame;
		
	}

	// 客户端接受线程
	public void run() {

		Data data = new Data(homeJFrame.getTitle(), null, null, Data.REFRESH, null);
		try {
			// 创建了一个好友列表，则发送一次刷新消息给服务器
			Tools.send(data, socket);
			// 而后会就收到一个刷新数据包
			while (true) {
				Data data1 = Tools.recieve(socket);

				if (data1.getType() == Data.REFRESH) {
					System.out.println(data1.getMessage());
					homeJFrame.setList(data1.getFriends());
				}
				
				if(data1.getType() == Data.MESSAGE && b) {
					b=false;
					new OneToOneJFrame(data1,socket).setVisible(true);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
