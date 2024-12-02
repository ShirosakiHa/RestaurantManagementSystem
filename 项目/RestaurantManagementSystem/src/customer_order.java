import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class customer_order extends JFrame{
	private JPanel dishJPanel;
	private JScrollPane dishJScrollPane;
	private ImageIcon dishPicture, logoPicture;
	private JCheckBox choice;
	private JButton myOrder, placeOrder, settleAccount;
	private JLabel logo, taglineJLabel, dishPictureJLabel, dishNameJLabel, dishPriceJLabel;
	private String dishName[]= {"东坡肘子","夫妻肺片","宫保鸡丁","辣子鸡丁","麻婆豆腐","水煮肉片","水煮鱼","鱼香肉丝",
			"拔丝山药","葱烧海参","黄焖鸡块","木须肉","三丝鱼翅","糖醋里脊","糖醋鲤鱼","一品豆腐",
			"八宝红鲟饭","白雪鸡","佛跳墙","福州鱼丸","荔枝肉","闽南咸饭","兴化米粉","漳州卤面",
			"黄桥烧饼","叫花鸡","南京盐水鸭","松鼠桂鱼","苏式焖肉","糖醋排骨","无锡排骨","扬州炒饭",
			"剁椒鱼头","姜辣蛇","腊味合蒸","辣椒炒肉","永州血鸭","姊妹团子","组庵豆腐","组庵鱼翅",
			"阿一鲍鱼","潮州卤味","挂炉烧鹅","广州文昌鸡","红烧乳鸽","梅菜扣肉","蜜汁叉烧","明炉烤乳猪",
			"杭椒牛柳","杭州卤鸭","红烧狮子头","龙井虾仁","梅菜肉饼","西湖醋鱼","蟹炒年糕","油焖笋",
			"拔丝芋头","红烧臭鳜鱼","黄山炖鸽","徽州毛豆腐","火腿炖甲鱼","麻辣小龙虾","霉豆渣","腌鲜鳜鱼"};
	private String file, dishPrice, path="八大菜系/", filetype=".jpg";
	private int dishNumber=64;
	
	public customer_order() {
		setLayout(null);
		logoMethod();
		taglineMethod();
		dishJPanelMethod();
		dishJScrollPaneMethod();
		buttonMethod();
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setVisible(true);
		setTitle("delicious");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int windowsWedth = 935;
	 	int windowsHeight = 590;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
	}
	
	void logoMethod() {
		logoPicture = new ImageIcon("002.jpg");
		logoPicture.setImage(logoPicture.getImage().getScaledInstance(250,70,Image.SCALE_DEFAULT));
		logo = new JLabel(logoPicture);
		getContentPane().add(logo);
		logo.setBounds(3,2,250,70);
	}
	
	void taglineMethod() {
		taglineJLabel = new JLabel("舌尖上的美味，给你不一样的美食享受！");
		taglineJLabel.setFont(new Font("华文行楷",Font.PLAIN,25));
		getContentPane().add(taglineJLabel);
		taglineJLabel.setBounds(348,28,500,25);
	}
	
	void dishJPanelMethod() {
		dishJPanel = new JPanel();
		dishJPanel.setLayout(null);
		int index;
		for(int i=0;i<Math.ceil(dishNumber/4);i++) {
			for(int j=0;j<4;j++) {
				index = i*4+j;
				file = path+dishName[index]+filetype;
	    		dishPicture = new ImageIcon(file);
	    		dishPicture.setImage(dishPicture.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT));
	    		dishPictureJLabel = new JLabel(dishPicture);			
	    		
	    		dishJPanel.add(dishPictureJLabel);
	    		dishPictureJLabel.setBounds(220*j+17,263*i+20,200,200);
	    		dishPictureJLabel.setBorder(new LineBorder(new Color(100, 100, 0)));
	    		
	    		dishNameJLabel = new JLabel(dishName[index]);
	    		dishJPanel.add(dishNameJLabel);
	    		dishNameJLabel.setFont(new Font("微软雅黑",Font.PLAIN,19));
	    		dishNameJLabel.setBounds(220*j+37,263*i+230,100,25);
	    		
	    		Random r=new Random();
	    		int price = (int) Math.round(30+(r.nextInt(100))*0.4);
	    		dishPrice = String.valueOf(price);
	    		dishPriceJLabel = new JLabel("￥ "+dishPrice);
	    		dishJPanel.add(dishPriceJLabel);
	    		dishPriceJLabel.setFont(new Font("微软雅黑",Font.PLAIN,17));
	    		dishPriceJLabel.setBounds(220*j+129,263*i+236,148,15);
	    		
	    		choice = new JCheckBox();
	    		dishJPanel.add(choice);
	    		choice.setBounds(220*j+180,263*i+228,30,30);
	    		}
		}
		dishJPanel.setPreferredSize(new Dimension(880, 4220));
	}
	
	void dishJScrollPaneMethod() {
		dishJScrollPane = new JScrollPane(dishJPanel);
		getContentPane().add(dishJScrollPane);
		dishJScrollPane.setBounds(0,72,910,415);
	}
	
	void buttonMethod() {
		myOrder = new JButton("我的订单");
		myOrder.setBackground(new Color(120,170,240));
		myOrder.setFont(new Font("微软雅黑",Font.PLAIN,18));
		myOrder.setForeground(new Color(0,0,0));
		getContentPane().add(myOrder);
		myOrder.setBounds(130,502,180,38);
		myOrder.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				new customer_myOrder();
			}
		});	
		
		placeOrder = new JButton("下 单");
		placeOrder.setBackground(new Color(0,240,80));
		placeOrder.setFont(new Font("微软雅黑",Font.PLAIN,18));
		placeOrder.setForeground(new Color(0,0,0));
		getContentPane().add(placeOrder);
		placeOrder.setBounds(535,502,120,38);
		
		settleAccount = new JButton("结 账");
		settleAccount.setBackground(new Color(240,130,20));
		settleAccount.setFont(new Font("微软雅黑",Font.PLAIN,18));
		settleAccount.setForeground(new Color(0,0,0));
		getContentPane().add(settleAccount);
		settleAccount.setBounds(740,502,120,38);
		settleAccount.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				dispose();
				new customer_settleAccounts();
			}
		});	
	}
	
	public static void main(String[] args) {
                new customer_order();
    }
	
}