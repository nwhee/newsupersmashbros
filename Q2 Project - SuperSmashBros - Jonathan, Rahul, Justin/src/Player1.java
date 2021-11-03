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
	private int fallSpeed = 0;
	private int gravity = 1;
	
	private Image img;
	private AffineTransform tx;
	
	
	//constructors
	public Player1() {
		x = 0;
		y = 0;
		health = 100;
		speed = 10;
		jumpHeight = 20;
		regularDamage = 5;
		specialDamage = 10;
		ultimateDamage = 30;
		
		img = getImage("/imgs/player1.png");
		
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y);
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
		//floor
		if(y > 480) {
			y = 480; //works at tx.scale(3, 3) and Frame(600,600)
		}
		if(x < 0) {
			x = 0;
		}
		
		tx.setToTranslation(x, y);
		
		//to scale it up or down to change the size 
		tx.scale(3, 3);
	}
	
	public void moveRight() {
		x += 5;
	}
	public void moveLeft() {
		x -= 5;
	}
	public void jump() {
		y -= 50;
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
	
	//setters
	public void setHealth() {
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
