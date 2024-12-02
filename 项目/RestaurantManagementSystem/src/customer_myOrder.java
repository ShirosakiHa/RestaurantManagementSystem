import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class customer_myOrder extends JFrame{
	private JButton remind, refund;
	private JLabel dishNameJLabel, dishPriceJLabel, dishSumPriceJLabel;
	private String dishName[]= {"麻婆豆腐","水煮肉片","水煮鱼","鱼香肉丝"};
	private String taste, component, randomNumber;
	
	public customer_myOrder() {
		setLayout(null);
		Method();
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setVisible(true);
		setTitle("我的订单");
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		int windowsWedth = 600;
	 	int windowsHeight = 400;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
	}
	
	void Method() {
		int price;
		int sum = 0;
		for(int i=0;i<4;i++) {
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
	    	dishNameJLabel.setFont(new Font("宋体",Font.PLAIN,17));
	    	getContentPane().add(dishNameJLabel);
	    	dishNameJLabel.setBounds(30,45*i+20,200,25);
	    		
	    	price = (int) (Math.round(30+(r.nextInt(100))*0.4)*(0.7+price*0.003));
	    	randomNumber = String.valueOf(price);
	    	dishPriceJLabel = new JLabel("￥ " + randomNumber);
	    	dishPriceJLabel.setFont(new Font("宋体",Font.PLAIN,17));
	    	getContentPane().add(dishPriceJLabel);
	    	dishPriceJLabel.setBounds(250,45*i+20,100,25);	    		
	    		
	    	remind = new JButton("催单");
	    	remind.setBackground(new Color(120,170,240));
	    	remind.setFont(new Font("宋体",Font.PLAIN,14));
	    	remind.setForeground(new Color(0,0,0));
	    	getContentPane().add(remind);
	    	remind.setBounds(390,45*i+20, 70,25);
	    		
	    	refund = new JButton("退餐");
	    	refund.setBackground(new Color(240,130,20));
	    	refund.setFont(new Font("宋体",Font.PLAIN,14));
	    	refund.setForeground(new Color(0,0,0));
	    	getContentPane().add(refund);
	    	refund.setBounds(490,45*i+20,70,25);
	    	sum += price;
	    }
		randomNumber = String.valueOf(sum);
		dishSumPriceJLabel = new JLabel("总计                   "+"￥ " + randomNumber);
		dishSumPriceJLabel.setFont(new Font("宋体",Font.BOLD,18));
    	getContentPane().add(dishSumPriceJLabel);
    	dishSumPriceJLabel.setBounds(30,325,500,25);		
	}
	
	public static void main(String[] args) {
                new customer_myOrder();
    }
	
}