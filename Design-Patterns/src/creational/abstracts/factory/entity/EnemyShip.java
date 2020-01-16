package creational.abstracts.factory.entity;

import creational.abstracts.factory.dto.ESEngine;
import creational.abstracts.factory.dto.ESWeapon;

public abstract class EnemyShip {

	protected String name;
	protected ESWeapon weapon;
	protected ESEngine engine;
	
	public abstract void makeShip();

	public abstract void displayEnemyShip();

	public abstract void followHeroShip();

	public abstract void enemyShipShoots();


	public ESWeapon getWeapon() {
		return weapon;
	}

	public void setWeapon(ESWeapon weapon) {
		this.weapon = weapon;
	}

	public ESEngine getEngine() {
		return engine;
	}

	public void setEngine(ESEngine engine) {
		this.engine = engine;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "The " + name + " has a top speed of " + engine + " and an attack power of " + weapon;
	}

}
