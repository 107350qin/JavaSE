package resources;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Set;

public class Tools {
	public static void send(Data data, Socket socket) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Data recieve(Socket socket) {
		ObjectInputStream ois = null;
		Data data = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			try {
				data = (Data) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	public static String[] setToStrings(Set<String> keySet) {
		String[] strings=new String[keySet.size()];
		int i=0;
		for(String string:keySet) {
			strings[i++]=string;
		}
		return strings;
	}
}
