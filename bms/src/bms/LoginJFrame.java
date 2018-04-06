package bms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import func.Verify;

public class LoginJFrame {
	private JFrame jFrame;
	private JTextField passwd;
	private JTextField account;
	private static int x;
	private static int y;

	private Verify ver = null;

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

		center.setLayout(null);
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

		JButton jButton = new JButton("登陆");
		jButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!account.getText().equals("") && !passwd.getText().equals("")) {
					ver = new Verify(account.getText(), passwd.getText());
					if (ver.verify()) {
						System.out.println("登陆成功");
						HomeJFrame frame = new HomeJFrame(account.getText());
						frame.setVisible(true);
						jFrame.dispose();
					} else {
						System.out.println("登陆失败");
					}
				}
			}
		});
		account.setBounds(5, 15, 198, 30);
		passwd.setBounds(5, 43, 198, 30);

		jButton.setBounds(5, 113, 198, 32);
		jButton.setFont(new Font("Microsoft JhengHei UI", 1, 14));
		jButton.setBackground(new Color(9, 163, 220));
		jButton.setForeground(Color.WHITE);
		jButton.setBorder(null);
		center.add(account);
		center.add(passwd);
		center.add(jButton);

		JButton button = new JButton("注册");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 14));
		button.setBorder(null);
		button.setBackground(new Color(9, 163, 220));
		button.setBounds(5, 78, 198, 32);
		center.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new RegisterUser().setVisible(true);
			}
		});

		jFrame.getContentPane().add(jPanelFirst);
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

	}
}
