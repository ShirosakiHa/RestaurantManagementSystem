import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class customer_completeMeal extends JFrame implements MouseListener{
	private JButton print, exit;
	private JLabel successfulPaymentJLabel, backGroundJLabel, evaluateJLabel, evaluateResultJLabel;
	private JLabel[] evaluateStarsJLabel = new JLabel[5];
	private String[] evaluateResult = {"非常差", "差", "一般", "好", "非常好"};
	private ImageIcon successfulPaymentPicture, starPicture;
	private ImageIcon backGroundPicture;
	private int windowsWedth = 660, windowsHeight = 520;
	
	public customer_completeMeal() {
		setLayout(null);
		successfulPaymentMethod();
		evaluate();
		buttonMethod();		
		backgroundPictureMethod(windowsWedth, windowsHeight);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
     	int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		setVisible(true);
		setTitle("用餐完成");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setBounds((width - windowsWedth) / 2,(height - windowsHeight) / 2,windowsWedth,windowsHeight);
	}
	
	void successfulPaymentMethod(){
		successfulPaymentPicture = new ImageIcon("006.jpg");
		successfulPaymentPicture.setImage(successfulPaymentPicture.getImage().getScaledInstance(440,150,Image.SCALE_DEFAULT));
		successfulPaymentJLabel = new JLabel(successfulPaymentPicture);
		getContentPane().add(successfulPaymentJLabel);
		successfulPaymentJLabel.setBounds(150,40,440,150);
	}
	
	void evaluate() {
		evaluateJLabel = new JLabel("说出我的评价：");
		evaluateJLabel.setFont(new Font("宋体",Font.BOLD,18));
    	getContentPane().add(evaluateJLabel);
    	evaluateJLabel.setBounds(30,220,200,25);		
		for(int i=0; i<5; i++) {
			starPicture = new ImageIcon("008.jpg");
			starPicture.setImage(starPicture.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
			evaluateStarsJLabel[i] = new JLabel(starPicture);
			getContentPane().add(evaluateStarsJLabel[i]);
			evaluateStarsJLabel[i].setBounds(80*i+125,280,70,70);
			evaluateStarsJLabel[i].addMouseListener(this);		
		}
	}

	void buttonMethod() {
		print = new JButton("打印纸质账单和发票");
    	print.setBackground(new Color(181,230,29));
    	print.setFont(new Font("宋体",Font.PLAIN,14));
    	print.setForeground(new Color(0,0,0));
    	getContentPane().add(print);
    	print.setBounds(70,415,170,35);
    	print.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();		
			}
		});
    	exit = new JButton("退出系统");
    	exit.setBackground(new Color(153,217,234));
    	exit.setFont(new Font("宋体",Font.PLAIN,14));
    	exit.setForeground(new Color(0,0,0));
    	getContentPane().add(exit);
    	exit.setBounds(490,415,95,35);
    	exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new customer_login();			
			}
		}); 	
	}		
	
	void backgroundPictureMethod(int windowsWedth, int windowsHeight) {
		backGroundPicture = new ImageIcon("007.jpg");
		backGroundPicture.setImage(backGroundPicture.getImage().getScaledInstance(windowsWedth,windowsHeight,Image.SCALE_DEFAULT));
		backGroundJLabel = new JLabel(backGroundPicture);
		getContentPane().add(backGroundJLabel);
		backGroundJLabel.setBounds(0,0,windowsWedth,windowsHeight);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {		
		for(int i=0; i<5; i++){
			if(e.getSource()==evaluateStarsJLabel[i]){
				remove(backGroundJLabel);
				for(int j=0; j<5; j++) {
					remove(evaluateStarsJLabel[j]);
					if(j < i+1){
					starPicture = new ImageIcon("009.jpg");
					}else{
						starPicture = new ImageIcon("008.jpg");
					}
					starPicture.setImage(starPicture.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT));
					evaluateStarsJLabel[j] = new JLabel(starPicture);
					getContentPane().add(evaluateStarsJLabel[j]);
					evaluateStarsJLabel[j].setBounds(80*j+125,280,70,70);
				}
				evaluateResultJLabel = new JLabel(evaluateResult[i]);
				evaluateResultJLabel.setFont(new Font("楷体",Font.ITALIC,17));
		    	getContentPane().add(evaluateResultJLabel);
		    	evaluateResultJLabel.setBounds(530,310,200,25);
		    	backgroundPictureMethod(windowsWedth, windowsHeight);
				break;
			}
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		//鼠标按键被释放时被触发			
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setCursor(Cursor.DEFAULT_CURSOR );//光标移出组件时被触发
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		setCursor(Cursor.HAND_CURSOR);//光标移入组件时被触发
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//发生单击事件时被触发
	}
		
	public static void main(String[] args) {
		new customer_completeMeal();
    }
	
}