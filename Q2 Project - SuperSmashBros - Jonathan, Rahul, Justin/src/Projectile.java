import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Projectile {
	
	private int x, y;
	private int speed;
	private int ow = 75, ol = 45;
	private Image img;
	private AffineTransform tx;
	
	
	public Projectile(int x, int y) {
		img = getImage("/imgs/spaceship.gif"); //load the image for Tree
		tx = AffineTransform.getTranslateInstance(x, y );
		init(x, y); 				//initialize the location of the image
									//use your variables
	}

	
	/* update variables here */
	private void update() {
		x += speed;
		speed = 10;
	}
	
	/* Drawing commands */
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		//call update to update the actual picture location
		update();
		
		g2.drawImage(img, tx, null);
		
	}
	
	public void fire() {
		
		speed = 5;
	}
	
	public void reset() {
		x = 10000;
		y = 10000;
		speed = 0;
	}

	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(5, 5);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
