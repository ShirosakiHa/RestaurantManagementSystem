import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class reception_administrator  extends JFrame implements MouseListener{
	private ImageIcon backGroundPicture, logoffPicture, memberPicture;
	private JLabel backGroundPictureLabel, todayTurnoverJLabel, memberPictureJLabel, yearMonthDayJLabel, symbolJLabel, sumTurnoverJLabel, logoffPictureJLabel;
	private JLabel[] seatPictureJLabel;
	private JButton search;
	private int windowsWedth = 900, windowsHeight = 550;
	private int[] temporary = new int[40];
	private String turnover;
	private String[] year = {"", "2015", "2016", "2017", "2018", "2019"},
			month = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"},
			day = {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", 
					"11", "12","13", "14", "15", "16", "17", "18", "19", "20", 
					"21", "22","23", "24", "25", "26", "27", "28", "29", "30", "31"},
			date = {"年", "月", "日"};
	private JComboBox yearFront, yearBehind, monthFront, monthBehind, dayFront, dayBehind;
	
	public reception_administrator() {
		setLayout(null);		
		today_turnoverMethod();
		sum_turnoverMethod();
		logoffPictureMethod();
		memberMethod();
		backgroundPictureMethod();
		setVisible(true);
		setTitle("欢迎您！管理员");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
	}
	
	void today_turnoverMethod() {
		Random r=new Random();
		turnover = String.format("%.2f", (float)(2000000 + r.nextInt(999999))/100);
		todayTurnoverJLabel = new JLabel("今日营业额为：  25,698.63");
		todayTurnoverJLabel.setFont(new Font("宋体",Font.PLAIN,25));
    	getContentPane().add(todayTurnoverJLabel);
    	todayTurnoverJLabel.setBounds(125,120,400,25);		
	}
	
	void sum_turnoverMethod() {
		yearFront = new JComboBox();
		yearBehind = new JComboBox();
		for(int i=0; i<6; i++) {
			yearFront.addItem(year[i]);
			yearBehind.addItem(year[i]);
		}
		monthFront = new JComboBox();
		monthBehind = new JComboBox();
		for(int i=0; i<13; i++) {
			monthFront.addItem(month[i]);
			monthBehind.addItem(month[i]);
		}
		dayFront = new JComboBox();
		dayBehind = new JComboBox();
		for(int i=0; i<32; i++) {
			dayFront.addItem(day[i]);
			dayBehind.addItem(day[i]);
		}
		
		int x = 40, y = 25, height = 420;
		
		yearMonthDayJLabel = new JLabel(date[0]);
		yearMonthDayJLabel.setFont(new Font("宋体",Font.PLAIN,20));
		getContentPane().add(yearMonthDayJLabel);
		yearMonthDayJLabel.setBounds(170,height+2,x,y);
		
		yearMonthDayJLabel = new JLabel(date[1]);
		yearMonthDayJLabel.setFont(new Font("宋体",Font.PLAIN,20));
		getContentPane().add(yearMonthDayJLabel);
		yearMonthDayJLabel.setBounds(250,height+2,x,y);
		
		yearMonthDayJLabel = new JLabel(date[2]);
		yearMonthDayJLabel.setFont(new Font("宋体",Font.PLAIN,20));
		getContentPane().add(yearMonthDayJLabel);
		yearMonthDayJLabel.setBounds(332,height+2,x,y);
		
		yearMonthDayJLabel = new JLabel(date[0]);
		yearMonthDayJLabel.setFont(new Font("宋体",Font.PLAIN,20));
		getContentPane().add(yearMonthDayJLabel);
		yearMonthDayJLabel.setBounds(500,height+2,x,y);
		
		yearMonthDayJLabel = new JLabel(date[1]);
		yearMonthDayJLabel.setFont(new Font("宋体",Font.PLAIN,20));
		getContentPane().add(yearMonthDayJLabel);
		yearMonthDayJLabel.setBounds(580,height+2,x,y);
		
		yearMonthDayJLabel = new JLabel(date[2]);
		yearMonthDayJLabel.setFont(new Font("宋体",Font.PLAIN,20));
		getContentPane().add(yearMonthDayJLabel);
		yearMonthDayJLabel.setBounds(662,height+2,x,y);

		
		getContentPane().add(yearFront);
		yearFront.setBounds(110,height,52,y);
		getContentPane().add(monthFront);
		monthFront.setBounds(202,height,x,y);
		getContentPane().add(dayFront);
		dayFront.setBounds(284,height,x,y);
		
		getContentPane().add(yearBehind);
		yearBehind.setBounds(440,height,52,y);
		getContentPane().add(monthBehind);
		monthBehind.setBounds(532,height,x,y);
		getContentPane().add(dayBehind);
		dayBehind.setBounds(614,height,x,y);
		
		symbolJLabel = new JLabel("——");
		symbolJLabel.setFont(new Font("宋体",Font.BOLD,24));
    	getContentPane().add(symbolJLabel);
    	symbolJLabel.setBounds(370,height+2,x+50,y);
    	
    	search = new JButton("查找");
    	search.setBackground(new Color(238,238,238));
    	search.setFont(new Font("微软雅黑",Font.PLAIN,18));
    	search.setForeground(new Color(0,0,0));
    	getContentPane().add(search);
    	search.setBounds(705,height-3,80,30);
    	sumTurnoverJLabel = new JLabel("阶段营业额为：");
    	sumTurnoverJLabel.setFont(new Font("宋体",Font.PLAIN,25));
	    getContentPane().add(sumTurnoverJLabel);
	    sumTurnoverJLabel.setBounds(125,260,300,25);
    	search.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				remove(sumTurnoverJLabel);
				remove(backGroundPictureLabel);
				sumTurnoverJLabel = new JLabel("阶段营业额为： 845,963.25");
				sumTurnoverJLabel.setFont(new Font("宋体",Font.PLAIN,25));
			    getContentPane().add(sumTurnoverJLabel);
			    sumTurnoverJLabel.setBounds(125,260,400,25);
			    backgroundPictureMethod();
			}
		});		
	}
	
	void memberMethod() {
		int x = 130, y = 171;
		memberPicture = new ImageIcon("018.jpg");
		memberPicture.setImage(memberPicture.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT));
		memberPictureJLabel = new JLabel(memberPicture);
		getContentPane().add(memberPictureJLabel);
		memberPictureJLabel.setBounds(575,115,x,y);
		memberPictureJLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				dispose();
				new reception_login();
			}
			public void mouseEntered(MouseEvent event){	
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent event){	
				setCursor(Cursor.DEFAULT_CURSOR );
			}
		});	
	}
	
	void logoffPictureMethod() {
		int x = 25, y = 25;
		logoffPicture = new ImageIcon("016.jpg");
		logoffPicture.setImage(logoffPicture.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT));
		logoffPictureJLabel = new JLabel(logoffPicture);
		getContentPane().add(logoffPictureJLabel);
		logoffPictureJLabel.setBounds(5,windowsHeight-67,x,y);
		logoffPictureJLabel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event){	
				dispose();
				new reception_login();
			}
			public void mouseEntered(MouseEvent event){	
				setCursor(Cursor.HAND_CURSOR);
			}
			public void mouseExited(MouseEvent event){	
				setCursor(Cursor.DEFAULT_CURSOR );
			}
		});	
	}
	
	void backgroundPictureMethod() {
		backGroundPicture = new ImageIcon("007.jpg");
		backGroundPicture.setImage(backGroundPicture.getImage().getScaledInstance(windowsWedth,windowsHeight,Image.SCALE_DEFAULT));
		backGroundPictureLabel = new JLabel(backGroundPicture);
		getContentPane().add(backGroundPictureLabel);
		backGroundPictureLabel.setBounds(0,0,windowsWedth,windowsHeight);
	}

	@Override
	public void mousePressed(MouseEvent e) {	
		for(int i=0; i<40; i++){
			if(e.getSource()==seatPictureJLabel[i]){
				if(temporary[i] == 1) {
					dispose();
					new table_detail(i);
				}
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		//鼠标按键被释放时被触发			
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//光标移出组件时被触发
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		//光标移入组件时被触发
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//发生单击事件时被触发
	}
	
	public static void main(String[] args) {
		new reception_administrator();
	}
	
}