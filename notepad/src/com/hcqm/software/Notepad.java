package com.hcqm.software;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

public class Notepad extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private File file = new File("新建文件.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notepad frame = new Notepad();
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
	public Notepad() {
		JTextArea text = new JTextArea();

		// 打开快捷键
		text.registerKeyboardAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(null);
				File theFile = fc.getSelectedFile();
				file = theFile;
				// 把文件内容读取到text中
				StringBuilder sb = new StringBuilder();
				getMessage(file, sb);
				text.setText(sb.toString());
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

		//保存快捷键
		//如果沒有打开过文件则另存为，否则保存就行
		text.registerKeyboardAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(file.getName().equals("新建文件.txt")) {
					JFileChooser fc = new JFileChooser();
					fc.showSaveDialog(null);
					String saveAsPath = fc.getSelectedFile().getAbsolutePath();
					save(saveAsPath, text.getText());
				}else {
					save(file.getPath(), text.getText());
				}
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK), JComponent.WHEN_IN_FOCUSED_WINDOW);

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"src\\resources\\images\\1.png"));
		setBackground(new Color(0, 255, 255));
		setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 14));
		setForeground(Color.RED);
		setTitle("Notepad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 924, 637);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0, 0, 0));
		menuBar.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		setJMenuBar(menuBar);

		JMenu mnf = new JMenu("文件(F)");
		mnf.setForeground(new Color(0, 0, 0));
		mnf.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		menuBar.add(mnf);

		JMenuItem open = new JMenuItem("打开(O)...          Ctrl+O");
		open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(null);
				File theFile = fc.getSelectedFile();
				file = theFile;
				// 把文件内容读取到text中
				StringBuilder sb = new StringBuilder();
				getMessage(file, sb);
				text.setText(sb.toString());
			}
		});

		open.setForeground(new Color(0, 0, 0));
		open.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		mnf.add(open);

		JMenuItem save = new JMenuItem("保存(S)             Ctrl+S");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save(file.getPath(), text.getText());
			}
		});
		save.setForeground(new Color(0, 0, 0));
		save.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		mnf.add(save);

		JMenuItem saveAs = new JMenuItem("另存为(A)...");
		saveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.showSaveDialog(null);
				String saveAsPath = fc.getSelectedFile().getAbsolutePath();
				save(saveAsPath, text.getText());
			}
		});
		saveAs.setForeground(new Color(0, 0, 0));
		saveAs.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		mnf.add(saveAs);

		JMenu mne = new JMenu("编辑(E)");
		mne.setForeground(new Color(0, 0, 0));
		mne.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		menuBar.add(mne);

		JMenu mno = new JMenu("格式(O)");
		mno.setForeground(new Color(0, 0, 0));
		mno.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		menuBar.add(mno);

		JMenu mnv = new JMenu("查看(V)");
		mnv.setForeground(new Color(0, 0, 0));
		mnv.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		menuBar.add(mnv);

		JMenu mnh = new JMenu("帮助(H)");
		mnh.setForeground(new Color(0, 0, 0));
		mnh.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		menuBar.add(mnh);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 51));
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// 注意：滚动条应该添加在包裹JTextArea的容器上，而不是添加到JTextArea本身上面
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(text);
		text.setWrapStyleWord(true);
		text.setLineWrap(true);

		text.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 22));
	}

	protected void save(String filePath2, String text) {
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(new BufferedOutputStream(new FileOutputStream(filePath2)), "utf-8");
			osw.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				osw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	protected void getMessage(File file, StringBuilder sb) {
		InputStreamReader bis = null;
		try {
			bis = new InputStreamReader(new BufferedInputStream(new FileInputStream(file)), "utf-8");
			char[] c = new char[100];
			int len = 0;
			while ((len = bis.read(c)) != -1) {
				sb.append(c, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
