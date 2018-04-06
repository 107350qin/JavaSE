package resources;

import java.net.Socket;

import javax.swing.JTextArea;

public class RecieveInfo extends Thread {
	private Socket socket;
	private JTextArea jTextArea;
	public RecieveInfo(Socket socket,JTextArea jTextArea) {
		this.socket=socket;
		this.jTextArea=jTextArea;
	}
public void run() {
	while(true) {
		Data data=Tools.recieve(socket);
		if(data.getType()==Data.MESSAGE) {
			jTextArea.append(data.getMessage());
		}
	}
}
}
