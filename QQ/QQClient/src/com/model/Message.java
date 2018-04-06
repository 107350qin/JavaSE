package com.model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Message implements Serializable{

	/**
	 * 消息的发送者
	 */
	private String from;
	/**
	 * 消息的接受者
	 */
	private String to;
	/**
	 * 消息的内容
	 */
	private String message;
	
	/**
	 * 消息的类型
	 */
	private int type;
	
	/**
	 * 好友属性
	 */
	private List<String> friends;
	/**
	 * 登录消息类型
	 */
	public static final int LOGIN = 0;
	/**
	 * 普通消息类型
	 */
	public static final int MESSAGE = 1;
	/**
	 * 刷新好友列表类型
	 */
	public static final int FRIENDS = 2;

	/**
	 * 群发消息类型
	 */
	public static final int GROUP = 3;

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

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	
	
	
	
}
