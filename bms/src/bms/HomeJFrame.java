package bms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import func.Get;

public class HomeJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1101541105487554822L;
	private JPanel contentPane;

	public HomeJFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(550, 0));
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);

		JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);

		// 容器里面直接装一个JList和一个滚动条就行不需要JTextarea

		refresh(list);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton_1 = new JButton("刷新");
		btnNewButton_1.setBackground(new Color(204, 255, 255));
		btnNewButton_1.setPreferredSize(new Dimension(100, 50));
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh(list);
			}
		});

		JButton btnNewButton = new JButton("修改");
		btnNewButton.setBackground(new Color(204, 255, 255));
		btnNewButton.setPreferredSize(new Dimension(100, 50));
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateJFrame frame = new UpdateJFrame();
				frame.setVisible(true);
			}
		});

		JButton btnNewButton_3 = new JButton("插入");
		btnNewButton_3.setBackground(new Color(204, 255, 255));
		btnNewButton_3.setPreferredSize(new Dimension(100, 50));
		panel_1.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InsertJFrame frame = new InsertJFrame();
				frame.setVisible(true);
			}
		});

		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setBackground(new Color(204, 255, 255));
		btnNewButton_2.setPreferredSize(new Dimension(100, 50));
		panel_1.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteJFrame frame = new DeleteJFrame();
				frame.setVisible(true);
			}
		});

		JButton btnNewButton_4 = new JButton("添加分类");
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddSort().setVisible(true);
			}
		});

		JButton btnNewButton_5 = new JButton("修改分类");
		panel_1.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ModifySort().setVisible(true);
			}
		});

		JButton btnNewButton_6 = new JButton("查询分类");
		panel_1.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshSort(list);
			}
		});

		JButton button = new JButton("删除分类");
		panel_1.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteSort().setVisible(true);
			}
		});

	}

	protected void refreshSort(JList<String> list) {
		ResultSet rs = Get.get("select * from sort;");
		String[] sorts = new String[30];
		int a = 0;
		if (rs != null) {
			try {
				while (rs.next()) {
					sorts[a++] = rs.getInt("sort_id") + "   " + rs.getString("sort_name");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		list.setListData(sorts);
	}

	private void refresh(JList<String> list) {
		ResultSet rs = Get.get("select * from book;");
		String[] books = new String[30];
		int a = 0;
		if (rs != null) {
			try {
				while (rs.next()) {
					books[a++] = rs.getInt("book_id") + "    " + rs.getString("book_name") + "    "
							+ rs.getString("book_author") + "    " + rs.getString("book_publisher") + "    "
							+ rs.getString("book_publish_time") + "    " + rs.getDouble("book_price") + "    "
							+ rs.getInt("book_sort") + "    "
							+ (rs.getString("book_comm") == null ? "" : rs.getString("book_comm"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		list.setListData(books);
	}

}
