package bms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import func.Get;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AddSort extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public AddSort() {
		setTitle("添加分类");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 407, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("输入您要添加的分类");
		textField.setBounds(0, 0, 166, 55);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 0, 204, 55);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(0, 56, 385, 54);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num=0;
				ResultSet theRs=null;
				theRs=Get.get("select * from sort;");
					try {
						theRs.last();
						num = theRs.getRow();
						System.out.println(num);
						num++;
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					
					String sql="insert sort values("+num
							+",'"+textField_1.getText()+"');";
					System.out.println(sql);
					if(Get.excute(sql)!=0) {
						System.out.println("添加成功");
					}else {
						System.out.println("添加失败");
					}
			}
		});
	}

}
