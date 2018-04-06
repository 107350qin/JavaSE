package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import resources.Data;
import resources.Tools;

public class LoginJFrame {
	private JFrame jFrame;
	private JTextField passwd;
	private JTextField account;
	private static int x;
	private static int y;

	public static void main(String[] args) {
		new LoginJFrame();
	}

	public LoginJFrame() {
		jFrame = new JFrame();
		jFrame.setResizable(false);
		jFrame.setSize(430, 348);
		jFrame.setUndecorated(true);
		jFrame.setIconImage(new ImageIcon("./src/images/QQ.png").getImage());

		JPanel jPanelFirst = new JPanel();
		JPanel jp2 = new JPanel();

		JLabel topBg = new JLabel();
		topBg.setIcon(new ImageIcon("./src/images/topBg.png"));
		BorderLayout blFirst = new BorderLayout();
		jPanelFirst.setLayout(blFirst);
		jPanelFirst.add(topBg, BorderLayout.NORTH);
		jPanelFirst.add(jp2, BorderLayout.CENTER);

		JPanel left = new JPanel();
		JPanel center = new JPanel();
		JPanel right = new JPanel();
		right.setPreferredSize(new Dimension(95, 0));
		left.setPreferredSize(new Dimension(130, 0));
		BorderLayout floor = new BorderLayout();
		jp2.setLayout(floor);
		jp2.add(left, BorderLayout.WEST);
		jp2.add(right, BorderLayout.EAST);
		jp2.add(center, BorderLayout.CENTER);

		left.setLayout(null);
		JLabel headLabel = new JLabel();
		headLabel.setIcon(new ImageIcon("./src/images/headLogo.png"));
		headLabel.setBounds(40, 10, 84, 85);
		left.add(headLabel);
		JLabel add = new JLabel();
		add.setIcon(new ImageIcon("./src/images/add1.png"));
		add.setBounds(5, 140, 25, 22);
		left.add(add);

		center.setLayout(null);
		Color color = new Color(127, 127, 127);
		Font font = new Font("Microsoft JhengHei UI", 0, 12);
	
		account = new JTextField(); 
		account.setBorder(BorderFactory.createLineBorder(new Color(209, 209, 209), 1));
		account.setForeground(Color.BLACK);
		account.setFont(font);
		account.setPreferredSize(new Dimension(198, 30));

		passwd = new JTextField();
		passwd.setBorder(BorderFactory.createLineBorder(new Color(209, 209, 209), 1));
		passwd.setForeground(Color.BLACK);
		passwd.setFont(font);
		passwd.setPreferredSize(new Dimension(198, 30));

		
		JCheckBox jCheckBox1 = new JCheckBox("璁颁綇瀵嗙爜");
		jCheckBox1.setForeground(color);
		jCheckBox1.setFont(font);
		JCheckBox jCheckBox2 = new JCheckBox("鑷姩鐧诲綍");
		jCheckBox2.setForeground(color);
		jCheckBox2.setFont(font);

		JButton jButton = new JButton("鐧婚檰");
		account.setBounds(5, 15, 198, 30);
		passwd.setBounds(5, 43, 198, 30);
		jCheckBox1.setBounds(0, 73, 90, 30);
		jCheckBox2.setBounds(130, 73, 90, 30);
		jButton.setBounds(5, 113, 198, 32);
		jButton.setFont(new Font("Microsoft JhengHei UI", 1, 14));
		jButton.setBackground(new Color(9, 163, 220));
		jButton.setForeground(Color.WHITE);
		jButton.setBorder(null);
		center.add(account);
		center.add(passwd);
		center.add(jCheckBox1);
		center.add(jCheckBox2);
		center.add(jButton);

		right.setLayout(null);
		JLabel jLabel1 = new JLabel("娉ㄥ唽璐﹀彿");
		JLabel jLabel2 = new JLabel("鎵惧洖瀵嗙爜");
		jLabel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jLabel2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jLabel1.setFont(new Font("Microsoft JhengHei UI", 0, 12));
		jLabel2.setFont(new Font("Microsoft JhengHei UI", 0, 12));
		jLabel1.setForeground(new Color(100, 185, 255));
		jLabel2.setForeground(new Color(113, 185, 255));
		jLabel1.setBounds(10, 12, 50, 30);
		jLabel2.setBounds(10, 42, 50, 30);
		right.add(jLabel1);
		right.add(jLabel2);

		JLabel qr = new JLabel();
		qr.setIcon(new ImageIcon("./src/images/qr1.png"));
		qr.setBounds(65, 138, 27, 27);
		right.add(qr);

		jFrame.add(jPanelFirst);
		jFrame.setVisible(true);

		/**
		 * --------------------------------------------------------------------------------------------------------------------
		 * --------------------------------------------------------------------------------------------------------------------
		 */

		jFrame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowOpened(e);
				jFrame.setLocation(e.getWindow().getWidth() + 140, e.getWindow().getHeight() - 40);
			}
		});

		jFrame.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				if (e.getX() > 400 && e.getX() < 430 && e.getY() > 0 && e.getY() < 30) {
					System.exit(0);
				}
				if (e.getX() > 370 && e.getX() < 400 && e.getY() > 0 && e.getY() < 30) {
					jFrame.setExtendedState(JFrame.ICONIFIED);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mousePressed(e);
				x = e.getX();
				y = e.getY();
			}
		});

		jFrame.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseMoved(e);
				if (e.getX() > 400 && e.getX() < 430 && e.getY() > 0 && e.getY() < 30) {
					jFrame.repaint();
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseDragged(e);
				jFrame.setLocation((int) (e.getX() + jFrame.getLocation().getX() - x),
						(int) (e.getY() + jFrame.getLocation().getY() - y));
			}
		});

		add.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				add.setIcon(new ImageIcon("./src/gui/images/add1.png"));

			}
		});
		add.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseMoved(e);
				add.setIcon(new ImageIcon("./src/gui/images/add2.png"));
			}
		});

		
		

		jButton.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseMoved(e);
				jButton.setBackground(new Color(60, 195, 245));
			}
		});

		jButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				jButton.setBackground(new Color(9, 163, 220));
			}
		});
		
		//鐧婚檰涔嬪悗鏄剧ず濂藉弸鍒楄〃
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Data data=new Data(account.getText(), "server", passwd.getText(), Data.LOGIN, null);
				try {
					Socket socket=new Socket("127.0.0.1", 8888);
					//姝ゅ鍒囪帿鐢昏泧娣昏冻鏀句竴涓狾bjectOutputStream,鍥犱负send閲屽凡缁忔湁浜嗭紝涓嶈兘鍚屾椂鍗犵敤
					Tools.send(data, socket);
					Data data1=Tools.recieve(socket);
					if(data1.getType()==Data.LOGIN) {
						new HomeJFrame(socket,data1.getFriends(),account.getText()).setVisible(true);
						jFrame.dispose();
					}

					
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});

		//
		jLabel1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				try {
					Runtime.getRuntime().exec("cmd.exe /c start " + "https://ssl.zc.qq.com/v3/index-chs.html");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		jLabel2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				try {
					Runtime.getRuntime().exec("cmd.exe /c start "
							+ "https://aq.qq.com/v2/uv_aq/html/reset_pwd/pc_reset_pwd_input_account.html?v=3.0&");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		qr.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseExited(e);
				qr.setIcon(new ImageIcon("./src/gui/images/qr1.png"));

			}
		});
		qr.addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseMoved(e);
				qr.setIcon(new ImageIcon("./src/gui/images/qr2.png"));
			}
		});
	}
}
