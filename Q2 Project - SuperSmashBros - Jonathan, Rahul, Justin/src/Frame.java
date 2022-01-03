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
	
	
	//stocks in array form
    Stocks1[] A = new Stocks1[3];
	Stocks2[] B = new Stocks2[3];
	
	
	Stage platform = new Stage(100, 230);
	
	Player1 Albert = new Player1(200,200,true, true);
	Player1 Bertrand = new Player1(750,200,false, false);
	
	Projectile specialA = new Projectile(1000, 1000);
	
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
		specialA.paint(g);
		
		
		//player1 Stocks
		for(int i = 0; i < A.length; i++) {
			A[i].paint(g);
		}
		
		//player2 Stocks
		for(int i = 0; i < B.length; i++) {
			B[i].paint(g);
		}
		
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
		
		if (health1 == 0) { //Albert Status
			
		Font a = new Font("Courier", Font.BOLD, 60);// following string is if the game is a one life system
		g.setFont(a);
		g.setColor(Color.RED);
		g.drawString("Betrand Wins", 300, 50);
		Albert.setResHealth(100);
		Bertrand.setResHealth(100);
			
		Stocks1[] temp = new Stocks1[A.length-1];
		
			for(int i = 0; i < A.length - 1; i++) {
				temp[i] = A[i];
			}
		
			A = temp;
			
			if(A.length == 0) {
				System.exit(0);
			}	
		}

		if (health2 == 0) {//Bertrand Status
		Albert.setResHealth(100);
		Bertrand.setResHealth(100);
		Font b = new Font("Courier", Font.BOLD, 60);// following string is if the game is a one life system
		g.setFont(b);
		g.setColor(Color.RED);
		g.drawString("Albert Wins", 300, 50);
		//B3.death();
		//System.exit(0);
			
		Stocks2[] temp = new Stocks2[B.length-1];
		
			for(int i = 0; i < B.length - 1; i++) {
				temp[i] = B[i];
			}
		
			B = temp;
		
		
			if(B.length == 0) {
			System.exit(0);
			}
		 
		}
		
		health1 = Albert.getHealth();
		health2 = Bertrand.getHealth();			
		
		Font c = new Font("Courier", Font.BOLD, 60);
		g.setFont(c);
		g.setColor(Color.BLACK);
		g.drawString(health1+"%", 175, 500);
		g.drawString(health2+"%", 575, 500);
		
		Rectangle Albert1 = new Rectangle(Albert.getX(), Albert.getY(), Albert.getWidth(), Albert.getHeight());
		Rectangle Bertrand1 = new Rectangle(Bertrand.getX(), Bertrand.getY(), Bertrand.getWidth(), Bertrand.getHeight());
		
		Rectangle special1 = new Rectangle(specialA.getX(), specialA.getY(), specialA.getWidth(), specialA.getHeight());
		
		if(special1.intersects(Bertrand1)) {
			Bertrand.setHealth(10);
			specialA.reset();
		}
	}	
	

		
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
		backs = new Background[3]; //creating an array for the 3 backgrounds
		Background bg0 = new Background(0,0, "/imgs/965x565 skyBG.png");  //daytime 
		
		Background bg1 = new Background(0,0, "/imgs/965x565 skynightBG.png"); //noon    
		
		Background bg2 = new Background(0,0, "/imgs/965x565 skynoonBG.png");  //night
		
		backs[0] = bg0;
		backs[1] = bg1;
		backs[2] = bg2;		
		
		Stocks1 A1 = new Stocks1(150,500);
		Stocks1 A2 = new Stocks1(200,500);
		Stocks1 A3 = new Stocks1(250,500);
		
		A[0] = A1;
		A[1] = A2;
		A[2] = A3;
		
		Stocks2 B1 = new Stocks2(550,500);
		Stocks2 B2 = new Stocks2(600,500);
		Stocks2 B3 = new Stocks2(650,500);
		
		B[0] = B1;
		B[1] = B2;
		B[2] = B3;
		
		JFrame f = new JFrame("super smash bros game");
		f.setSize(new Dimension(965, 800));
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
		
		
		//player1 Stocks
		
		for(int i = 0; i < A.length; i++) {
			int y = 500;
			int x = 150 + 50*i;
			A[i] = new Stocks1(x , y);
		}
		
		//player2 Stocks
		for(int i = 0; i < B.length; i++) {
			int y = 500;
			int x = 550 + 50*i;
			B[i] = new Stocks2(x, y);
		}		
	
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
		//alt jump button: c
		if(arg0.getKeyCode() == 87 && p1JumpCounter > 0 || arg0.getKeyCode() == 67 && p1JumpCounter > 0) {
			Albert.jump();
			p1JumpCounter--;
		}
		/*if(arg0.getKeyCode() == 67) {
			
		}*/
		//function testing button - press q to test
		//v to fire
		if(arg0.getKeyCode() == 86) {
			Albert.fire();
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
		// alt jump button: .
		if(arg0.getKeyCode() == 38 && p2JumpCounter > 0 || arg0.getKeyCode() == 44 && p2JumpCounter > 0) {
			Bertrand.jump();
			p2JumpCounter--;
		}
		// . to fire
		if(arg0.getKeyCode() == 46) {
			Bertrand.fire();
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
