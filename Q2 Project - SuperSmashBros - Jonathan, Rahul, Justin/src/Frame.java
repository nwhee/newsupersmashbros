import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {
	
	//CREATE THE OBJECT (STEP 1)
	Background[] backs;
	
	Stage platform = new Stage(100, 230);
	
	Player1 Albert = new Player1(200,200,true);
	Player1 Bertrand = new Player1(750,200,false);
	
	Fireball test = new Fireball(100,210);
	
	private int p1JumpCounter = 2;
	private boolean p1MoveLeft = false;
	private boolean p1MoveRight = false;
	
	private int p2JumpCounter = 2;
	private boolean p2MoveLeft = false;
	private boolean p2MoveRight = false;
	
	private double health1 = 100;
	
	private double health2 = 100;
	
	private int bg = (int)(Math.random()*3);


	public void paint(Graphics g) {
		super.paintComponent(g);
		
		backs[bg].paint(g);
		
		//stage object
		platform.paint(g);
		
		//player1 object
		Albert.paint(g);
		Bertrand.paint(g);
		test.paint(g);
		
		if(Albert.getY() == 250 && Albert.onStage) {
			p1JumpCounter = 2;
		}
		else {
			Albert.onStage = false ;
		}
		if(p1MoveLeft) {
			Albert.moveLeft();
		}
		if(p1MoveRight) {
			Albert.moveRight();
		}
		
		//player2
		if(Bertrand.getY() == 250 && Bertrand.onStage) {
			p2JumpCounter = 2;
		}
		else {
			Bertrand.onStage = false ;
		}
		if(p2MoveLeft) {
			Bertrand.moveLeft();
		}
		if(p2MoveRight) {
			Bertrand.moveRight();
		}
		
		if (health1 == 0); //example code for when health reaches 0 reset both players health
		health1 = 100;
		health2 = 100; 
		
		if (health2 == 0);
		health1 = 100;
		health2 = 100;
		
		
		health1 = Albert.getHealth();
		health2 = Bertrand.getHealth();
		
		Font c = new Font("Courier", Font.BOLD, 60);
		g.setFont(c);
		g.setColor(Color.BLACK);
		g.drawString(health1+"%", 175, 500);
		g.drawString(health2+"%", 575, 500);		
	}	
	

		
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		backs = new Background[3]; //creating an array for the 3 backgrounds
		Background bg0 = new Background(0,0, "/imgs/skyBG.png");  //daytime 
		
		Background bg1 = new Background(0,0, "/imgs/skynightBG.png"); //noon    
		
		Background bg2 = new Background(0,0, "/imgs/skynoonBG.jpg");  //night
		
		backs[0] = bg0;
		backs[1] = bg1;
		backs[2] = bg2;		
		
		JFrame f = new JFrame("super smash bros game");
		f.setSize(new Dimension(965, 565));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(16, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
			System.out.println(arg0.getKeyCode());
		if(arg0.getKeyCode() == 65) {
			Albert.setP1(true);
			p1MoveLeft = true;
			
		}
		if(arg0.getKeyCode() == 68) {
			Albert.setP1(true);
			p1MoveRight = true;
		}
		if(arg0.getKeyCode() == 87 && p1JumpCounter > 0) {
			Albert.jump();
			p1JumpCounter--;
		}
		/*if(arg0.getKeyCode() == 67) {
			
		}*/
		//function testing button - press q to test
		if(arg0.getKeyCode() == 81) {
			Albert.setHealth(10);
			test.shotRight();
			
		}

		//player2 movement + actions
		if(arg0.getKeyCode() == 37) {
			Bertrand.setP1(false);
			p2MoveLeft = true;
		}
		if(arg0.getKeyCode() == 39) {
			Bertrand.setP1(false);
			p2MoveRight = true;
		}
		if(arg0.getKeyCode() == 38 && p2JumpCounter > 0) {
			Bertrand.jump();
			p2JumpCounter--;
		}

	}
//test
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == 65) {
			p1MoveLeft = false;
		}
		if(arg0.getKeyCode() == 68) {
			p1MoveRight = false;
		}
		
		//player2 movement
		if(arg0.getKeyCode() == 37) {
			p2MoveLeft = false;
		}
		if(arg0.getKeyCode() == 39) {
			p2MoveRight = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
