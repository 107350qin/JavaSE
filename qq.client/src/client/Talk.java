package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import resources.Data;
import resources.Tools;

public class Talk extends JFrame {

	private JPanel contentPane;
	private JTextArea show;
	
	//对话框所用的流
	private Socket socket;
	//from是发送者
	private String from;
	//to是发送对象
	private String to;
	//数据是message还是group
	private int oneOrMore;
	/**
	 * Create the frame.
	 */
	public Talk(String from, String to, Socket socket,int oneOrMore) {
		this.from = from;
		this.to = to;
		this.socket = socket;
		this.oneOrMore=oneOrMore;
		setTitle(to);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 510, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0, 290));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		show = new JTextArea();
		show.setEditable(false);
		show.setWrapStyleWord(true);
		show.setLineWrap(true);
		scrollPane.setViewportView(show);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JTextArea content = new JTextArea();
		content.setBounds(0, 0, 404, 100);
		panel_1.add(content);

		JButton btn = new JButton("send");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 点击之后发送数据，将消息显示到聊天框，输入框设为空
				if(oneOrMore==1) {
					Tools.send(new Data(from, to, content.getText(), Data.MESSAGE, null), socket);
				}
				if(oneOrMore==2) {
					Tools.send(new Data(from, to, content.getText(), Data.GROUP, null), socket);
				}
				show.append("你说:" + content.getText() + "\n");
				content.setText("");
			}
		});
		btn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));
		btn.setBounds(401, 0, 93, 100);
		panel_1.add(btn);
	}

	public void addMessage(String name,String message) {
		show.append(name+"说:"+message + "\n");
	}
}
