package bms;

import java.awt.EventQueue;
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

public class DeleteSort extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -725004582651849342L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteSort frame = new DeleteSort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeleteSort() {
		setTitle("删除分类");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 137);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("输入要删除的分类编号");
		textField.setBounds(0, 0, 208, 48);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(209, 0, 219, 48);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(textField_1.getText());
				if (indexIsContained(index)) {
					String sql = "delete from sort where sort_id=" + index + ";";
					int x = Get.excute(sql);
					if (x != 0) {
						System.out.println("删除成功");
					} else {
						System.out.println("删除失败");
					}
				} else {
					System.out.println("一些书籍属于该类，您需要先修改那些书籍的分类或删除他们才能执行此操作！");
				}
			}
		});
		button.setBounds(-12, 45, 440, 48);
		contentPane.add(button);
	}

	protected boolean indexIsContained(int index) {
		ResultSet rs = Get.get("select book_sort from book;");
		try {
			while (rs.next()) {
				if (rs.getInt("book_sort") == index) {
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
