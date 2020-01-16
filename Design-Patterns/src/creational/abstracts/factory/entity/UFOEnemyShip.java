package creational.abstracts.factory.entity;

import creational.abstracts.factory.factory.EnemyShipFactory;

public class UFOEnemyShip extends EnemyShip {
	
	EnemyShipFactory factory;

	public UFOEnemyShip(EnemyShipFactory shipPartsFactory) {
		this.factory = shipPartsFactory;
	}

	@Override
	public void makeShip() {
		System.out.println("Making enemy ship " + getName());
		weapon = factory.addESGun();
		engine = factory.addESEngine();
	}

	@Override
	public void displayEnemyShip() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void followHeroShip() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enemyShipShoots() {
		// TODO Auto-generated method stub
		
	}


}
