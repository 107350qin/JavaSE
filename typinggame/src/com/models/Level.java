package com.models;

public class Level {
	private int level;// 当前是第几个关卡
	private int time;// 通过关卡所需要的时间限制
	private int times;// 该关卡所需要输入字符串的次数
	private int length;// 该关卡输入字符串的长度

	public Level(int level, int time, int times, int length) {
		super();
		this.level = level;
		this.time = time;
		this.times = times;
		this.length = length;
	}

	public void setLevel(int level, int time, int times, int length) {
		this.level = level;
		this.time = time;
		this.times = times;
		this.length = length;
	}

	public int getRank() {
		return level;
	}

	public int getTime() {
		return time;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getTimes() {
		return times;
	}

	public int getLength() {
		return length;
	}

}
