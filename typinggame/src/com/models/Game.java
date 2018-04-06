package com.models;

import java.util.Scanner;

/**
 * 游戏主体 游戏所需的数据在此模块中被初始化 创建一个静态类型的玩家和一个静态类型的等级对象。即共享的对象，节约内存。 当过关之后将其属性改变继续游戏
 * 
 * @author Administrator
 *
 */
public class Game {
	private static Player player;
	private static Level level;

	public Game() {
	}

	public Game(Player player, Level level) {
		Game.player = player;
		Game.level = level;
	}

	public void initGame() {
		// 玩家等级，游戏关数，开始时间
		player = new Player(1, 0, System.currentTimeMillis());
		// 关卡数，过关用时，输入次数，字符串长度
		level = new Level(1, 90, 3, 3);
		System.out.println("-----------------------游戏开始-------------------------");
	}

	public int startGame() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			player.setRank(1);
			player.setStartTime(System.currentTimeMillis());
			print1();
			for (int j = 0; j < 3; j++) {
				String outputString = newString(level.getLength());
				System.out.println("请输入字符串:" + outputString);
				long now = System.currentTimeMillis();
				if (((now - player.getStartTime()) / 1000) > level.getTime()) {
					System.out.println("超时了！游戏结束");
					return -1;
				}
				long a = (now - player.getStartTime()) / 1000;
				int b = level.getTime();
				System.out.println("已经用时：" + a);
				System.out.println("要求用时：" + b);
				String inputString = scanner.nextLine();
				if (outputString.equals(inputString)) {
					player.setRank(j + 2);
					player.setGrade(player.getGrade() + 10);
					print2();
				} else {
					System.out.println("输入错误，游戏结束");
					return -1;
				}
			}
			level.setLevel(i + 2, 90 - (i + 1) * 10, 3, level.getLength() + 1);
			if (i != 5) {
				System.out.println("您已通过关卡,再接再厉哦");
			}
		}
		System.out.println("-----------------------恭喜您通关了------------------------");
		return 1;
	}

	private void print1() {
		// TODO Auto-generated method stub
		System.out.println("游戏关卡        时间要求       共需输入次数        字符串长度");
		System.out.print("  " + level.getRank() + "       ");
		System.out.print(level.getTime() + "s        ");
		System.out.print(level.getTimes() + "          ");
		System.out.println(level.getLength() + "         ");
	}

	private void print2() {
		System.out.println("玩家等级 :" + player.getRank() + "       ");
		System.out.println("玩家分数:" + player.getGrade() + "      ");
		System.out.println("----------------------------------------------------");
	}

	private String newString(int length) {
		String string="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		String string = "11111111111111111111111111111111111111111111111111111111111111";
		StringBuffer theString = new StringBuffer();
		int index;
		for (int i = 0; i < length; i++) {
			index = (int) Math.floor(Math.random() * 62);
			theString.append(string.charAt(index));
		}
		return theString.toString();
	}
}
