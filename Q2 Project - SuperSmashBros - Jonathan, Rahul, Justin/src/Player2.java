
public class Player2 {
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
	private int gravity = -4;
	
	//constructors
	public Player2() {
		x = 0;
		y = 0;
		health = 100;
		speed = 10;
		regularDamage = 5;
		specialDamage = 10;
		ultimateDamage = 30;
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
	
}
