package creational.abstracts.factory.entity;

import creational.abstracts.factory.factory.EnemyShipFactory;

public class UFOBossEnemyShip extends EnemyShip {

	EnemyShipFactory factory;

	public UFOBossEnemyShip(EnemyShipFactory shipPartsFactory) {
		this.factory = shipPartsFactory;
	}

	@Override
	public void makeShip() {
		System.out.println("Making boss enemy ship " + getName());
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
