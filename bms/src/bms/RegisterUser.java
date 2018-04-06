package bms;

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

public class RegisterUser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8830347484909866190L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton;

	public RegisterUser() {
		setTitle("注册账号");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 279);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("账号");
		textField.setBounds(0, 0, 84, 41);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setText("密码");
		textField_1.setColumns(10);
		textField_1.setBounds(0, 41, 84, 41);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("再次输入");
		textField_2.setColumns(10);
		textField_2.setBounds(0, 83, 84, 41);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(85, 0, 343, 41);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(85, 41, 343, 41);
		contentPane.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(85, 83, 343, 41);
		contentPane.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setText("身份证号");
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(0, 124, 84, 41);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(85, 124, 343, 41);
		contentPane.add(textField_7);

		btnNewButton = new JButton("注册");
		btnNewButton.setBounds(0, 166, 428, 57);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (textField_4.getText().equals(textField_5.getText())) {

					int num = 0;
					ResultSet theRs = null;
					theRs = Get.get("select * from user;");
					try {
						theRs.last();
						num = theRs.getRow();
						System.out.println(num);
						num++;
					} catch (SQLException e2) {
						e2.printStackTrace();
					}

					String sql = "insert user values(" + num + ",'" + textField_3.getText() + "'" + ",'"
							+ textField_4.getText() + "'" + ",'" + textField_7.getText() + "');";
					int k = Get.excute(sql);
					if (k != 0) {
						System.out.println("注册成功");
					} else {
						System.out.println("注册失败");
					}
				} else {
					System.out.println("两次输入的密码不匹配！");
				}
			}
		});
	}

}
