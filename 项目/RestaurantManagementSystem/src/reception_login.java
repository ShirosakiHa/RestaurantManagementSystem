import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class reception_login  extends JFrame{
	private ImageIcon loginPicture;
	private JLabel loginPictureLabel, accountJLabel, passwordJLabel, sloganJLabel;
	private JTextField accountInput;
	private JPasswordField passwordInput;
	private JButton loginButton, visitorLoginButton;
	private int windowsWedth = 900;
	private int windowsHeight = 560;
	
	public reception_login() {
		setLayout(null);		
		inputMethod();
		buttonMethod();
		backgroundPictureMethod();
		setVisible(true);
		setTitle("欢迎上班");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
	}

	void inputMethod() {
		int x =52, y=480;		
		sloganJLabel = new JLabel("新的一天也要元气满满哟！");
		sloganJLabel.setFont(new Font("楷体",Font.PLAIN,40));
		sloganJLabel.setForeground(new Color(100,100,100));
		getContentPane().add(sloganJLabel);
		sloganJLabel.setBounds(205,50,800,50);
		
		accountJLabel = new JLabel("管理员账号：");
		accountJLabel.setFont(new Font("微软雅黑",Font.PLAIN,18));
		accountJLabel.setForeground(new Color(50,50,50));
		getContentPane().add(accountJLabel);
		accountJLabel.setBounds(x,y,110,20);
		
		passwordJLabel = new JLabel("管理员密码：");
		passwordJLabel.setFont(new Font("微软雅黑",Font.PLAIN,18));
		passwordJLabel.setForeground(new Color(50,50,50));
		getContentPane().add(passwordJLabel);
		passwordJLabel.setBounds(x+260,y,110,20);
		
		accountInput = new JTextField();
		getContentPane().add(accountInput);
		accountInput.setBounds(x+110,y,130,22);
		
		passwordInput = new JPasswordField();
		getContentPane().add(passwordInput);
		passwordInput.setBounds(x+370,y,130,22);				
	}
	
	void buttonMethod() {
		int x =590, y=480;
	    loginButton=new JButton("管理员登录");
		loginButton.setBackground(new Color(255,255,255));
		loginButton.setFont(new Font("微软雅黑",Font.PLAIN,14));
		loginButton.setForeground(new Color(0,0,0));
		getContentPane().add(loginButton);
		loginButton.setBounds(x,y-2,108,25);
		loginButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				dispose();
				new reception_administrator();
			}
		});
		
		visitorLoginButton=new JButton("服务员登录");
		visitorLoginButton.setBackground(new Color(255,255,255));
		visitorLoginButton.setFont(new Font("微软雅黑",Font.PLAIN,14));
		visitorLoginButton.setForeground(new Color(0,0,0));
		getContentPane().add(visitorLoginButton);
		visitorLoginButton.setBounds(x+130,y-2,108,25);
		visitorLoginButton.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				dispose();
				new reception_table();
			}
		});
	}
	
	void backgroundPictureMethod() {
		loginPicture = new ImageIcon("010.jpg");
		loginPicture.setImage(loginPicture.getImage().getScaledInstance(windowsWedth,windowsHeight,Image.SCALE_DEFAULT));
		loginPictureLabel = new JLabel(loginPicture);
		getContentPane().add(loginPictureLabel);
		loginPictureLabel.setBounds(0,0,windowsWedth,windowsHeight);
	}
	
	public static void main(String[] args) {
		new reception_login();
	}
	
}


