import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class reception_table  extends JFrame implements MouseListener{
	private ImageIcon backGroundPicture, seatPicture, seatIndexPicture, logoffPicture;
	private JLabel backGroundPictureLabel, seatIndexJLabel, seatIndexPictureJLabel, logoffPictureJLabel;
	private JLabel[] seatPictureJLabel;
	private int windowsWedth = 900, windowsHeight = 550;
	private int[] temporary = new int[40];
	private String index;
	
	public reception_table() {
		setLayout(null);		
		tableMethod();
		logoffPictureMethod();
		backgroundPictureMethod();
		setVisible(true);
		setTitle("餐桌总览");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
	}
	
	void tableMethod() {
		int x =60, y=70, m, n;
		seatPictureJLabel = new JLabel[40];
		for(int i=1; i<41; i++) {
			Random r=new Random();
			m = (int) Math.ceil((float)i/8);
			n = i -8*(m-1);
			if(r.nextInt(2) == 0) {
				temporary[i-1] = 0;
				seatPicture = new ImageIcon("012.jpg");
				seatIndexPicture = new ImageIcon("014.jpg");
			}else {
				temporary[i-1] = 1;
				seatPicture = new ImageIcon("013.jpg");
				seatIndexPicture = new ImageIcon("015.jpg");
			}
			index = String.valueOf(i);
			seatIndexJLabel = new JLabel(index);
			seatIndexJLabel.setFont(new Font("微软雅黑",Font.BOLD,14));
			getContentPane().add(seatIndexJLabel);
			seatIndexJLabel.setBounds(n*105-36,m*95-60,25,25);
			
			seatIndexPicture.setImage(seatIndexPicture.getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT));
			seatIndexPictureJLabel = new JLabel(seatIndexPicture);
			getContentPane().add(seatIndexPictureJLabel);
			seatIndexPictureJLabel.setBounds(n*105-40,m*95-60,25,25);
			
			seatPicture.setImage(seatPicture.getImage().getScaledInstance(x,y,Image.SCALE_DEFAULT));
			seatPictureJLabel[i-1] = new JLabel(seatPicture);
			getContentPane().add(seatPictureJLabel[i-1]);
			seatPictureJLabel[i-1].setBounds(n*105-57,m*95-65,x,y);
			seatPictureJLabel[i-1].addMouseListener(this);
		}
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
		for(int i=0; i<40; i++){
			if(e.getSource()==seatPictureJLabel[i]){
				if(temporary[i] == 1) {
					setCursor(Cursor.DEFAULT_CURSOR );//光标移出组件时被触发
				}
			}
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i=0; i<40; i++){
			if(e.getSource()==seatPictureJLabel[i]){
				if(temporary[i] == 1) {
					setCursor(Cursor.HAND_CURSOR);//光标移入组件时被触发
				}
			}
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//发生单击事件时被触发
	}
	public static void main(String[] args) {
		new reception_table();
	}
	
}