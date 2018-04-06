package resources;

import java.io.Serializable;

public class Data implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4475742614765855357L;
	private String from;
	private String to;
	private String message;
	private int type;
	private String[] friends;
	public Data() {}
	public Data(String from, String to, String message, int type, String[] friends) {
		super();
		this.from = from;
		this.to = to;
		this.message = message;
		this.type = type;
		this.friends = friends;
	}
	
	public static final int LOGIN=0; 
	public static final int MESSAGE=1; 
	public static final int REFRESH=2; 
	public static final int GROUP=3; 
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String[] getFriends() {
		return friends;
	}
	public void setFriends(String[] friends) {
		this.friends = friends;
	}
	
}
