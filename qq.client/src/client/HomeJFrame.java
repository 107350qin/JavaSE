package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import resources.AcceptThreadClient;
import resources.Data;
import resources.Tools;

public class HomeJFrame extends JFrame {
	private static final long serialVersionUID = 5843850570814047923L;
	private JPanel contentPane;

	// 存储消息对话框
	private Map<String, Talk> talkMap = new HashMap<>();
	JList<String> list;
	JScrollPane scrollPane;

	// 自己从登陆的时候就获得的socket，每一个人登陆成功之后都有一个好友列表，都有一个socket
	private Socket socket;
	// 好友列表
	private String[] friends;
	// 每一个好友列表都有一个title
	private String title;

	// 刷新列表
	public void setList(String[] friends) {
		 list.setListData(friends);
	}

	/**
	 * Create the frame.
	 */
	public HomeJFrame(Socket socket, String[] friends, String title) {
		this.socket = socket;
		this.friends = friends;
		this.title = title;
		setTitle(title);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				Data data=new Data(title,"服务器","关闭",Data.CLOSE,null);
				Tools.send(data, socket);
				System.exit(0);
			}
		});
		setBounds(100, 100, 373, 844);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		list = new JList<String>();
		list.setListData(friends);
		scrollPane.setViewportView(list);

		// 启动这个，刷新列表的功能在此线程中实现
		new AcceptThreadClient(socket, this).start();

		// 双击时显示对话框
		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (e.getClickCount() == 2) {
					int x = list.locationToIndex(e.getPoint());
					String to = friends[x];// 发送给谁的名字
					System.out.println(to);
					if (!to.equals(title)) {
						if (!talkMap.containsKey(to)) {
							Talk talk = new Talk(title, to, socket, 1);
							// 此处已经有了一个窗口就要加到集合里面去
							talkMap.put(to, talk);
							talk.setVisible(true);
						} else {
							talkMap.get(to).setVisible(true);
						}
					}

				}
			}
		});

		// 群发
		JButton jButton = new JButton("群聊");
		jButton.setPreferredSize(new Dimension(0, 50));
		contentPane.add(jButton, BorderLayout.SOUTH);
		jButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Talk(title, "群聊", socket, 2).setVisible(true);

			}
		});
	}

	// 接受时显示对话框，from是对方，to是自己
	public Talk showTalk(String from, String to) {
		// 如果已经有此人的对话框了
		if (talkMap.containsKey(from)) {
			return talkMap.get(from);
		} else {
			Talk talk = new Talk(to, from, socket, 1);
			talkMap.put(from, talk);// 把对方的对话框加入集合
			talk.setVisible(true);
			return talk;
		}
	}
}
