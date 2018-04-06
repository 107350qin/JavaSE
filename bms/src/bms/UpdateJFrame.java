package bms;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import func.Get;

public class UpdateJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7828122068525142439L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
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

	public UpdateJFrame() {
		setTitle("修改");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 475, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("请输入修改的书籍编号");
		textField.setBounds(38, 15, 188, 44);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(274, 15, 144, 44);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		textField_2.setEditable(false);
		textField_2.setText("                          修改项");
		textField_2.setBounds(38, 85, 380, 38);
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

		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_1.getText().equals("")) {
					String sql = "update book set " + "book_name='" + textField_10.getText() + "',book_author='"
							+ textField_11.getText() + "',book_publisher='" + textField_12.getText()
							+ "',book_publish_time='" + textField_13.getText() + "',book_price='"
							+ textField_14.getText() + "',book_sort='" + textField_15.getText() + "',book_comm='"
							+ textField_16.getText() + "' where book_id=" + textField_1.getText() + ";";
					System.out.println(sql);
					if (Get.excute(sql) != 0) {
						System.out.println("修改成功");
					} else {
						System.out.println("修改失败");
					}
				}
			}
		});
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		btnNewButton.setBounds(38, 538, 380, 61);
		contentPane.add(btnNewButton);
	}
}
