package client;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import resources.AcceptThreadClient;
import resources.Data;

public class HomeJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5843850570814047923L;
	private JPanel contentPane;
	private JList<String> list;
	private Map<Integer, String> map=new HashMap<>();
	
	public void setList(String[] strings) {
		list.setListData(strings);

	}

	/**
	 * Create the frame.
	 */
	public HomeJFrame(Socket socket, String[] friends, String title) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 844);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		list = new JList<String>();
		list.setListData(friends);
		setTitle(title);
		scrollPane.setViewportView(list);

		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (e.getClickCount() == 2) {
					int x = list.locationToIndex(e.getPoint());
					System.out.println("已经双击");
					String string=friends[x];
					new OneToOneJFrame(new Data(title,string,null,Data.MESSAGE,null),socket).setVisible(true);
				}
			}
		});

		new AcceptThreadClient(socket, this).start();
	}
}
