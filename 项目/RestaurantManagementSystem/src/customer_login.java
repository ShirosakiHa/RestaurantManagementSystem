import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
public class customer_login  extends JFrame{
	private ImageIcon loginPicture;
	private JLabel loginPictureLabel, accountJLabel, passwordJLabel;
	private JTextField accountInput;
	private JPasswordField passwordInput;
	private JButton loginButton, registerButton, visitorLoginButton;
	private int windowsWedth = 900, windowsHeight = 560;

	public customer_login() {
		setLayout(null);		
		inputMethod();
		buttonMethod();
		backgroundPictureMethod();
		setVisible(true);
		setTitle("登录");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
	}

	void inputMethod() {
		accountJLabel = new JLabel("会员账号：");
		passwordJLabel = new JLabel("会员密码：");
		accountJLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
		passwordJLabel.setFont(new Font("微软雅黑",Font.BOLD,18));
		accountJLabel.setForeground(new Color(250,250,250));
		passwordJLabel.setForeground(new Color(250,250,250));
		accountInput = new JTextField();	
		passwordInput = new JPasswordField();
		
		int x =52, y=230;
		getContentPane().add(accountJLabel);
		accountJLabel.setBounds(x,y,100,20);
		getContentPane().add(accountInput);
		accountInput.setBounds(x+100,y,130,22);		
		getContentPane().add(passwordJLabel);
		passwordJLabel.setBounds(x,y+80,100,20);
		getContentPane().add(passwordInput);
		passwordInput.setBounds(x+100,y+80,130,22);
	}
	
	void buttonMethod() {
	    loginButton=new JButton("登录");
		loginButton.setBackground(new Color(120,170,240));
		loginButton.setFont(new Font("微软雅黑",Font.BOLD,14));
		loginButton.setForeground(new Color(250,250,250));
		
		registerButton=new JButton("注册");
		registerButton.setBackground(new Color(120,170,240));
		registerButton.setFont(new Font("微软雅黑",Font.BOLD,14));
		registerButton.setForeground(new Color(250,250,250));
		
		visitorLoginButton=new JButton("游客登录");
		visitorLoginButton.setBackground(new Color(120,170,240));
		visitorLoginButton.setFont(new Font("微软雅黑",Font.BOLD,14));
		visitorLoginButton.setForeground(new Color(250,250,250));
		visitorLoginButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				dispose();
				new customer_order();
			}
		});
		
		int x =38, y=400;
		getContentPane().add(loginButton);
		loginButton.setBounds(x,y,65,30);
		getContentPane().add(registerButton);
		registerButton.setBounds(x+85,y,65,30);
		getContentPane().add(visitorLoginButton);
		visitorLoginButton.setBounds(x+185,y,95,30);
	}
	
	void backgroundPictureMethod() {
		loginPicture = new ImageIcon("001.jpg");
		loginPicture.setImage(loginPicture.getImage().getScaledInstance(windowsWedth,windowsHeight,Image.SCALE_DEFAULT));
		loginPictureLabel = new JLabel(loginPicture);
		getContentPane().add(loginPictureLabel);
		loginPictureLabel.setBounds(0,0,windowsWedth,windowsHeight);
	}
	
	public static void main(String[] args) {
		new customer_login();
	}
	
}


