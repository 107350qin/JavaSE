package bms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import func.Get;

public class ModifySort extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7207658375955222827L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button;

	public ModifySort() {
		setTitle("修改分类");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 449, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("您要修改的分类编号");
		textField.setBounds(0, 0, 172, 56);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(214, 0, 213, 56);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setText("       改为");
		textField_2.setBounds(0, 57, 172, 56);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(214, 57, 213, 56);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_1.getText().equals("")) {
					String sql = "update sort set " + "sort_name='" + textField_3.getText() + "' where sort_id="
							+ textField_1.getText() + ";";
					System.out.println(sql);
					if (Get.excute(sql) != 0) {
						System.out.println("修改成功");
					} else {
						System.out.println("修改失败");
					}
				}
			}
		});
		button.setBounds(0, 114, 427, 49);
		contentPane.add(button);
	}

}
