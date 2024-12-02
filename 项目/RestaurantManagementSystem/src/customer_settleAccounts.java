import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class customer_settleAccounts extends JFrame{
	private JButton balance, feedback;
	private JLabel dishNameJLabel, dishPriceJLabel, dishSumPriceJLabel,
			AlipayQR_CodeJLabel, WeChatQR_CodeJLabel, checkBalanceJLabel, 
			backGroundJLabel, AlipayJLabel, WeChatJLabel;
	private String dishName[]= {"麻婆豆腐","水煮肉片","水煮鱼","鱼香肉丝"};
	private String taste, component, randomNumber;
	private ImageIcon AlipayQR_CodePicture, WeChatQR_CodePicture, backGroundPicture;

	public customer_settleAccounts() {
		int windowsWedth = 660;
	 	int windowsHeight = 600;
		setLayout(null);
		billMethod();
		buttonMethod();
		QR_CodeMethod();
		backgroundPictureMethod(windowsWedth, windowsHeight);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setVisible(true);
		setTitle("结账");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
	}
	
	void billMethod() {
		int price;
		int sum = 0;
		int i;
		int abscissa = 60;
		for(i=0;i<4;i++) {
	    	Random r=new Random();
			price = r.nextInt(98);
			if(price < 33) {
				taste = "加辣";
			}else if(price > 32 && price < 66){
				taste = "微辣";
			}else {
				taste = "不要辣";
			}
				
			price = r.nextInt(98);
			if(price < 33) {
				component = "大份";
			}else if(price > 32 && price < 66){
				component = "中份";
			}else {
				component = "小份";
			}
									
			dishNameJLabel = new JLabel(dishName[i] + "(" + component + taste + ")");
	    	dishNameJLabel.setFont(new Font("宋体",Font.BOLD,16));
	    	getContentPane().add(dishNameJLabel);
	    	dishNameJLabel.setBounds(abscissa,33*i+30,200,25);
	    		
	    	price = (int) (Math.round(30+(r.nextInt(100))*0.4)*(0.7+price*0.003));
	    	randomNumber = String.valueOf(price);
	    	dishPriceJLabel = new JLabel("￥   " + randomNumber);
	    	dishPriceJLabel.setFont(new Font("宋体",Font.BOLD,16));
	    	getContentPane().add(dishPriceJLabel);
	    	dishPriceJLabel.setBounds(abscissa+450,33*i+30,100,25);	    		   			    	
	    	sum += price;
	    }
		randomNumber = String.valueOf(sum);
		dishSumPriceJLabel = new JLabel("总计                                           "+"￥  " + randomNumber);
		dishSumPriceJLabel.setFont(new Font("宋体",Font.BOLD,18));
    	getContentPane().add(dishSumPriceJLabel);
    	dishSumPriceJLabel.setBounds(abscissa,33*i+45,600,25);		
	}
	
	void buttonMethod() {
		int distance = 380;
		balance = new JButton("余额扣除（会员）");
    	balance.setBackground(new Color(120,170,240));
    	balance.setFont(new Font("宋体",Font.PLAIN,14));
    	balance.setForeground(new Color(0,0,0));
    	getContentPane().add(balance);
    	balance.setBounds(250,248,160,35);
    	balance.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				dispose();
				new customer_completeMeal();
			}
		});	
    		
    	feedback = new JButton("反馈问题");
    	feedback.setBackground(new Color(240,10,0));
    	feedback.setFont(new Font("宋体",Font.PLAIN,14));
    	feedback.setForeground(new Color(0,0,0));
    	getContentPane().add(feedback);
    	feedback.setBounds(330-distance/2-95,520,95,25);
    	
    	feedback = new JButton("前台结账");
    	feedback.setBackground(new Color(0,200,20));
    	feedback.setFont(new Font("宋体",Font.PLAIN,14));
    	feedback.setForeground(new Color(0,0,0));
    	getContentPane().add(feedback);
    	feedback.setBounds(330+distance/2,520,95,25);
    	feedback.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				dispose();
				new customer_login();
			}
		});
    	
    	checkBalanceJLabel = new JLabel("查看我的账户余额");
    	checkBalanceJLabel.setFont(new Font("宋体",Font.PLAIN,13));
    	checkBalanceJLabel.setForeground(new Color(0,130,20));
    	getContentPane().add(checkBalanceJLabel);
    	checkBalanceJLabel.setBounds(417,254,200,25);
    	checkBalanceJLabel.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent event){	
            	checkBalanceJLabel.setForeground(new Color(240,100,20));
            	setCursor(Cursor.HAND_CURSOR);
            }
            public void mouseExited(MouseEvent event){	
            	checkBalanceJLabel.setForeground(new Color(0,130,20));
            	setCursor(Cursor.DEFAULT_CURSOR );
            }
        });	 	
	}
	
	void QR_CodeMethod(){
		int distance = 50;
		AlipayQR_CodePicture = new ImageIcon("003.jpg");
		AlipayQR_CodePicture.setImage(AlipayQR_CodePicture.getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT));
		AlipayQR_CodeJLabel = new JLabel(AlipayQR_CodePicture);
		getContentPane().add(AlipayQR_CodeJLabel);
		AlipayQR_CodeJLabel.setBounds(330-distance/2-130,335,130,130);
		
		WeChatQR_CodePicture = new ImageIcon("004.jpg");
		WeChatQR_CodePicture.setImage(WeChatQR_CodePicture.getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT));
		WeChatQR_CodeJLabel = new JLabel(WeChatQR_CodePicture);
		getContentPane().add(WeChatQR_CodeJLabel);
		WeChatQR_CodeJLabel.setBounds(330+distance/2,335,130,130);
		
		AlipayJLabel = new JLabel("支 付 宝");
    	AlipayJLabel.setFont(new Font("微软雅黑",Font.PLAIN,16));
    	getContentPane().add(AlipayJLabel);
    	AlipayJLabel.setBounds(213,475,80,25);
    	
    	WeChatJLabel = new JLabel("微   信");
    	WeChatJLabel.setFont(new Font("微软雅黑",Font.PLAIN,16));
    	getContentPane().add(WeChatJLabel);
    	WeChatJLabel.setBounds(398,475,50,25);
	}
	
	void backgroundPictureMethod(int windowsWedth, int windowsHeight) {
		backGroundPicture = new ImageIcon("005.jpg");
		backGroundPicture.setImage(backGroundPicture.getImage().getScaledInstance(windowsWedth,windowsHeight,Image.SCALE_DEFAULT));
		backGroundJLabel = new JLabel(backGroundPicture);
		getContentPane().add(backGroundJLabel);
		backGroundJLabel.setBounds(0,0,windowsWedth,windowsHeight);
	}
	
	public static void main(String[] args) {
                new customer_settleAccounts();
    }
	
}