import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Fireball {
	
	private static int x;
	private static int y;
	private static int speed;
	private int ow = 65, oh = 65; 
	
	private static Image img;
	private AffineTransform tx;
	
	private boolean moveLeft = false;
	private boolean moveRight = true;
	
	
	//constructor
	public Fireball(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 10;
		
		img = getImage("/imgs/Fireball.gif");
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y);
	}
	
	public void paint(Graphics g) {
		//2 lines of code needed to draw image
		Graphics2D fireball = (Graphics2D) g;
		
		update();
		fireball.drawImage(img, tx, null);
	}
	
	private void update() {
		if(moveLeft) {
			x -= speed;
		}
		if(moveRight) {
			x += speed;
		}
		
		tx.setToTranslation(x, y);
		
		//to scale it up or down to change the size 
		tx.scale(.5, .5);
	}
	
	
//	public void shotLeft() {
//		moveLeft = true;
//		if(x > -30 && x < 800) {
//			moveLeft = true;
//			x -= speed;
//		}
//		else {
//			moveLeft = false;
//		}
//
//	}
//	public void shotRight() {
//		moveRight = true;
//		if(x > -30 && x < 800) {
//			x += speed;
//		}
//		else {
//			moveRight = false;
//		}
//
//	}
	
	//methods for movement
	public static void moveRight() {
		speed = 10;
		img = getImage("/imgs/FireballCropRight.png");
	}
	public static void moveLeft() {
		speed = -10;
		img = getImage("/imgs/FireballCrop.png");
	}
	
	public void reset() {
		x = 10000;
		y = 10000;
		speed = 0;
	}
	
	//getters
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getWidth() {
		return ow;
	}
	public int getHeight() {
		return oh;
	}
	
	//setters
	public static void setX(int paramX) {
		x = paramX;
	}
	public static void setY(int paramY) {
		y = paramY;
	}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.5, .5);
	}
	
	private static Image getImage(String path) {
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
