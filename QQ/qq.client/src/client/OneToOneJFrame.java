package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import resources.Data;
import resources.RecieveInfo;
import resources.Tools;

public class OneToOneJFrame extends JFrame {

	private JPanel contentPane;
	private Data data;
	private Socket socket;
	/**
	 * Create the frame.
	 */
	public OneToOneJFrame(Data data,Socket socket) {
		this.data=data;
		this.socket=socket;
		
		setTitle(data.getTo());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JTextArea show = new JTextArea();
		show.setEditable(false);
		show.setWrapStyleWord(true);
		show.setLineWrap(true);
		scrollPane.setViewportView(show);
		
		show.append(data.getMessage()+"\n");
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JTextArea content = new JTextArea();
		content.setBounds(0, 0, 404, 100);
		panel_1.add(content);
		
		JButton btn = new JButton("send");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//点击之后发送数据，将消息显示到聊天框，输入框设为空
				Tools.send(new Data(data.getTo(), data.getFrom(), content.getText(), Data.MESSAGE, null), socket);
				show.append("你说:"+content.getText()+"\n");
				content.setText("");
			} 
		});
		btn.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 25));
		btn.setBounds(401, 0, 93, 100);
		panel_1.add(btn);
		
		//这里要持续监视收到的消息
		new RecieveInfo(socket,show).start();
		}
	}

