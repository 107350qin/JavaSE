package calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Calculator extends JFrame {
//	// 装0-9的容器
//	private ArrayList<JButton> num = new ArrayList<>();
//	// 装除了数字外的其他字符的容器
//	private ArrayList<JButton> ch = new ArrayList<>();
	// 小记录仪和显示数字的部分
	static JTextField before;
	static JTextField show;
	// 用户输入的字符串
	static StringBuffer sb = new StringBuffer();
	static int i;

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.start();
	}

	private void start() {
		//i是类已经定义的静态变量，num是定义的存储了一堆按钮的ArrayList集合
		//sb是一个StringBuffer,每次点击会将字符串增加，然后将其显示在show中,
		//show是一个文本框
		//我的问题：这样循环添加监听器哪里不对？系统提示显示索引越界！
		//当我吧num.size换成较小的3时，只有一监听器起作用！
		//而我换成逐一添加就OK了呢
//		for (i = 0; i < num.size(); i++) {
//			num.get(i).addMouseListener(); 

		// num.get(0).addMouseListener(new MouseAdapter() {
		//
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// // TODO Auto-generated method stub
		// super.mouseClicked(e);
		// sb.append(num.get(0).getText());
		// show.setText(sb.toString());
		// }
		// });

		// num.get(1).addMouseListener(new MouseAdapter() {
		//
		// @Override
		// public void mouseClicked(MouseEvent e) {
		// // TODO Auto-generated method stub
		// super.mouseClicked(e);
		// sb.append(num.get(1).getText());
		// show.setText(sb.toString());
		// }
		// });
	}

	public Calculator() {
		setTitle("计算器");
		setSize(1130, 790);// 630
		Font font = new Font("微软雅黑", 0, 30);

		setIconImage(new ImageIcon("src/resource/images/1.png").getImage());
		JPanel hello = new JPanel();
		hello.setLayout(new BorderLayout());
		JPanel l = new JPanel();// 左边的大容器
		JPanel r = new JPanel();// 右边的大容器
		hello.add(l, BorderLayout.WEST);
		hello.add(r, BorderLayout.CENTER);
		l.setPreferredSize(new Dimension(630, 0));

		// 左边大容器里面的上面显示部分

		before = new JTextField("hello，我是小型记录仪");// 小记录
		show = new JTextField("hi，我是显示部分");// 显示部分
		JPanel pts = new JPanel();// 计算器主体部分

		before.setPreferredSize(new Dimension(630, 80));
		font = new Font("微软雅黑", 0, 24);
		before.setFont(font);
		before.setBorder(null);
		before.setHorizontalAlignment(JTextField.RIGHT);
		before.setBackground(new Color(238, 238, 238));

		show.setPreferredSize(new Dimension(630, 120));
		font = new Font("微软雅黑", 1, 40);
		show.setFont(font);
		show.setBorder(null);
		show.setHorizontalAlignment(JTextField.RIGHT);
		show.setBackground(new Color(238, 238, 238));

		pts.setPreferredSize(new Dimension(630, 520));
		// pts.setBackground(Color.blue);
		pts.setLayout(new GridLayout(6, 4));
		font = new Font("微软雅黑", 0, 30);// new ImageIcon("./src/resource/images/01.png")
		NumJButton pt1 = new NumJButton("%");
		NumJButton pt2 = new NumJButton("√");
		NumJButton pt3 = new NumJButton("x²");
		NumJButton pt4 = new NumJButton("1/x");
		NumJButton pt5 = new NumJButton("CE");
		NumJButton pt6 = new NumJButton("C");
		NumJButton pt7 = new NumJButton("DEL");
		NumJButton pt8 = new NumJButton("÷");
		NumJButton pt9 = new NumJButton("7");
	
		NumJButton pt10 = new NumJButton("8");
		NumJButton pt11 = new NumJButton("9");
		NumJButton pt12 = new NumJButton("×");
		NumJButton pt13 = new NumJButton("4");
		NumJButton pt14 = new NumJButton("5");
		NumJButton pt15 = new NumJButton("6");
		NumJButton pt16 = new NumJButton("‐");
		NumJButton pt17 = new NumJButton("1");
		NumJButton pt18 = new NumJButton("2");
		NumJButton pt19 = new NumJButton("3");
		NumJButton pt20 = new NumJButton("+");
		NumJButton pt21 = new NumJButton("±");
		NumJButton pt22 = new NumJButton("0");
		NumJButton pt23 = new NumJButton(".");
		NumJButton pt24 = new NumJButton("=");
		pt1.setFont(font);
		pt2.setFont(font);
		pt3.setFont(font);
		pt4.setFont(font);
		pt5.setFont(font);
		pt6.setFont(font);
		pt7.setFont(font);
		pt8.setFont(font);
		pt9.setFont(font);
		pt10.setFont(font);
		pt11.setFont(font);
		pt12.setFont(font);
		pt13.setFont(font);
		pt14.setFont(font);
		pt15.setFont(font);
		pt16.setFont(font);
		pt17.setFont(font);
		pt18.setFont(font);
		pt19.setFont(font);
		pt20.setFont(font);
		pt21.setFont(font);
		pt22.setFont(font);
		pt23.setFont(font);
		pt24.setFont(font);
		pts.add(pt1);
		pts.add(pt2);
		pts.add(pt3);
		pts.add(pt4);
		pts.add(pt5);
		pts.add(pt6);
		pts.add(pt7);
		pts.add(pt8);
		pts.add(pt9);
		pts.add(pt10);
		pts.add(pt11);
		pts.add(pt12);
		pts.add(pt13);
		pts.add(pt14);
		pts.add(pt15);
		pts.add(pt16);
		pts.add(pt17);
		pts.add(pt18);
		pts.add(pt19);
		pts.add(pt20);
		pts.add(pt21);
		pts.add(pt22);
		pts.add(pt23);
		pts.add(pt24);

		l.add(before);
		l.add(show);
		l.add(pts);

		// 这两句最后才加上的哦
		setVisible(true);
		add(hello);
//		num.add(pt9);
//		num.add(pt10);
//		num.add(pt11);
//		num.add(pt13);
//		num.add(pt14);
//		num.add(pt15);
//		num.add(pt17);
//		num.add(pt18);
//		num.add(pt19);
//		num.add(pt22);
//		num.add(pt23);
//		ch.add(pt1);
//		ch.add(pt2);
//		ch.add(pt3);
//		ch.add(pt4);
//		ch.add(pt5);
//		ch.add(pt6);
//		ch.add(pt7);
//		ch.add(pt8);
//		ch.add(pt12);
//		ch.add(pt16);
//		ch.add(pt20);
//		ch.add(pt21);
//		ch.add(pt24);
	}
}
