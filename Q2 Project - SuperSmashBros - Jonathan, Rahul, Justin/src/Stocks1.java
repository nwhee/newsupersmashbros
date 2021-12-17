import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Stocks1 {
	
	//instance variables
	private int x, y;
	private int isDead;

	
	private Image img;
	private AffineTransform tx;
	
	
	//constructors
	public Stocks1(int x, int y) {
		this.x = x;
		this.y = y;

		
		img = getImage("/imgs/Stockplayer1.png");
		
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
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
	
	public void death() {
		x = 10000;
		y = 10000;
	}
	
	public void stockDeath() {
		isDead = 100;
	}
	
	public int getIsDead() {
		return isDead;
	}
	private void update() {
		
		tx.setToTranslation(x, y);
		
		//to scale it up or down to change the size 
		tx.scale(0.5, 0.5);
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
