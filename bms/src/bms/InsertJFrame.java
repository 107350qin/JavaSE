package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import func.Get;

public class InsertJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7528264686759255144L;
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	public InsertJFrame() {
		setTitle("添加");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 475, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		textField_2.setEditable(false);
		textField_2.setText("                        书籍信息");
		textField_2.setBounds(38, 39, 380, 84);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("   书名");
		textField_3.setBounds(38, 148, 96, 27);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText("   作者");
		textField_4.setBounds(38, 196, 96, 27);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setText("  出版社");
		textField_5.setBounds(38, 254, 96, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setText(" 出版时间");
		textField_6.setBounds(38, 304, 96, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setText("   价格");
		textField_7.setBounds(38, 363, 96, 27);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setText("   分类");
		textField_8.setBounds(38, 420, 96, 27);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setText("   说明");
		textField_9.setBounds(38, 477, 96, 27);
		contentPane.add(textField_9);
		textField_9.setColumns(10);

		textField_10 = new JTextField();
		textField_10.setBounds(173, 148, 245, 27);
		contentPane.add(textField_10);
		textField_10.setColumns(10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(173, 196, 245, 27);
		contentPane.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(173, 254, 245, 27);
		contentPane.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(173, 304, 245, 27);
		contentPane.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(173, 363, 245, 27);
		contentPane.add(textField_14);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(173, 420, 245, 27);
		contentPane.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(173, 477, 245, 27);
		contentPane.add(textField_16);

		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = 0;
				ResultSet theRs = null;
				theRs = Get.get("select * from book;");
				try {
					theRs.last();
					num = theRs.getRow();
					System.out.println(num);
					num++;
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				String sql = "insert book values(" + num + ",'" + textField_10.getText() + "','"
						+ textField_11.getText() + "','" + textField_12.getText() + "','" + textField_13.getText()
						+ "'," + textField_14.getText() + "," + textField_15.getText() + ",'" + textField_16.getText()
						+ "');";
				System.out.println(sql);
				if (Get.excute(sql) != 0) {
					System.out.println("添加成功");
				} else {
					System.out.println("添加失败");
				}

			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		btnNewButton.setBounds(38, 538, 380, 61);
		contentPane.add(btnNewButton);
	}
}
