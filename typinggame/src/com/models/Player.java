package com.models;

public class Player {
	private int rank;// 玩家自身的等级
	private int grade;// 玩家分数
	private long startTime;// 玩家开始游戏的时间//当前时间减掉改时间就是玩家所消耗的时间

	// 玩家等级，游戏关数，开始时间
	public void setPlayer(int rank, int grade, long startTime) {
		this.rank = rank;
		this.grade = grade;
		this.startTime = startTime;
	}

	public Player(int rank, int grade, long startTime) {
		super();
		this.rank = rank;
		this.grade = grade;
		this.startTime = startTime;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

}
