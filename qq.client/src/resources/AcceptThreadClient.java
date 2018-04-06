package resources;

import java.net.Socket;
import java.util.Date;

import client.HomeJFrame;
import client.Talk;

public class AcceptThreadClient extends Thread {
	private Socket socket;
	private HomeJFrame homeJFrame;

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

				// 能 接收到消息肯定是在线的
				// 搞清楚接收方和发送方
				// 接受的类型是message，并且接收方是我才执行显示对话框的操作
				// 如果对话框已经在就拿出来，没有就创建一个。
				if (data1.getType() == Data.MESSAGE && data1.getTo().equals(homeJFrame.getTitle())) {
					homeJFrame.showTalk(data1.getFrom(), data1.getTo()).addMessage(data1.getTo(), data1.getMessage());
				}
				if (data1.getType() == Data.GROUP && data1.getTo().equals(homeJFrame.getTitle())) {
					homeJFrame.showTalk( "群聊",data1.getFrom()).addMessage(data1.getFrom(), data1.getMessage());
				}
				if (data1.getType() == Data.CLOSE) {
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
