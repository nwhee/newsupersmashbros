import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Fireball {
	
	private int x, y;
	private int speed;
	
	private Image img;
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
	
	
	public void shotLeft() {
		moveLeft = true;
		if(x > -30 && x < 800) {
			moveLeft = true;
			x -= speed;
		}
		else {
			moveLeft = false;
		}

	}
	public void shotRight() {
		moveRight = true;
		if(x > -30 && x < 800) {
			x += speed;
		}
		else {
			moveRight = false;
		}

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
