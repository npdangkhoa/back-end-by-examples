package creational.factory;

public abstract class Ship {
	private String  name;
	private double amtDamage;
	
	public void enemyShipShoots() {
		System.out.println(getName() + " attacks and does " + getAmtDamage());
	}
	
	public void displayEnemyShip() {
		System.out.println(getName() + "is on the screen");

	}
	public void followHeroShip(){
		System.out.println(getName() + "is following the hello");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmtDamage() {
		return amtDamage;
	}
	public void setAmtDamage(double amtDamage) {
		this.amtDamage = amtDamage;
	}
	
	
}
