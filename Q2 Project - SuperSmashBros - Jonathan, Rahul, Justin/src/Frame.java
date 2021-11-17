import java.awt.Color;
import java.awt.Dimension;
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
	Background 	bg 	= new Background(0,0);
	
	Stage platform = new Stage(100, 230);
	
	Player1 Albert = new Player1(200,200);
	
	private int p1JumpCounter = 2;
	private boolean p1MoveLeft = false;
	private boolean p1MoveRight = false;


	public void paint(Graphics g) {
		super.paintComponent(g);
		
		bg.paint(g);
		
		//stage object
		platform.paint(g);
		
		//player1 object
		Albert.paint(g);
		
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
	}	
	

		
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
	}
	
	public Frame() {
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
		if(arg0.getKeyCode() == 37) {
			p1MoveLeft = true;
		}
		if(arg0.getKeyCode() == 39) {
			p1MoveRight = true;
		}
		if(arg0.getKeyCode() == 88 && p1JumpCounter > 0) {
			Albert.jump();
			p1JumpCounter--;
		}
		if(arg0.getKeyCode() == 67) {
			
		}

		

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getKeyCode() == 37) {
			p1MoveLeft = false;
		}
		if(arg0.getKeyCode() == 39) {
			p1MoveRight = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
