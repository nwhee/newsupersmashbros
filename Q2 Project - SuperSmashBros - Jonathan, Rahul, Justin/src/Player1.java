import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Player1 {
	
	//instance variables
	private int x, y;
	private double health;
	private double hLost;
	private double height;
	private double width;
	private double regularDamage;
	private double specialDamage;
	private double ultimateDamage;
	private double jumpHeight;
	private double speed;
	private double fallSpeed = 0;
	private double gravity = 1.5;
	
	private boolean p1;
	private String p1Left = "/imgs/player1flipped.png";
	private String p1Right = "/imgs/player1.png";
	private String p2Left = "/imgs/p2Left.png";
	private String p2Right = "/imgs/p2Right.png";
	
	public boolean onStage = false;
	
	private Image img;
	private AffineTransform tx;
	
	
	
	//constructors
	public Player1(int x, int y, boolean p1) {
		this.x = x;
		this.y = y;
		health = 100;
		speed = 7;
		jumpHeight = 36;
		regularDamage = 5;
		specialDamage = 10;
		ultimateDamage = 30;
		
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y);
		
		if(p1) {
			img = getImage(p1Right);
		}
		else {
			img = getImage(p2Left);
		}
		
		
		
	}
	
	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		init(x, y);      //initialize location of the image
	}
	
	public void paint(Graphics g) {
		//2 lines of code needed to draw image
		Graphics2D p1 = (Graphics2D) g;
		
		//call update to update the picture location
		update();
		p1.drawImage(img, tx, null);
	}
	
	private void update() {
		y += fallSpeed;
		fallSpeed += gravity;
		
		//ceiling
		if(y < 0) {
			y = 0;
		}
		//stage floor limit
		if(y > 250 && y < 280&& x > 135 && x < 800) {  
			y = 250; //works at tx.scale(3, 3) and Frame(600,600)
			onStage = true;
			
		}
		else {
			onStage = false;
		}
		
		
		if(onStage) {
			fallSpeed = 0;
		}
		
		if(x < 0) {
			x = 0;
		}
		
		tx.setToTranslation(x, y);
		
		//to scale it up or down to change the size 
		tx.scale(3, 3);
	}
	
	public void moveRight() {
		x += speed;
		if(p1) {
			img = getImage(p1Right);
		}
		else {
			img = getImage(p2Right);
		}
		
	}
	public void moveLeft() {
		x -= speed;
		if(p1) {
			img = getImage(p1Left);
		}
		else {
			img = getImage(p2Left);
		}
	}
	public void jump() {
		fallSpeed = jumpHeight * -.5;
	}

	
	//getters
	public double getHealth() {
		return health;
	}
	public double getRegularDamage() {
		return regularDamage;
	}
	public double getSpecialDamage() {
		return specialDamage;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	//setters
	public void setHealth(int hLost) {
		health -= hLost;
	}

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Player1.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
}
