package creational.factory;

import creational.abstracts.factory.factory.EnemyShipFactory;

public class UFOEnemyShip extends Ship {

	public UFOEnemyShip() {
		super();
		
		setName("UFO Enemy Ship");
		setAmtDamage(20.0);
	}

	public UFOEnemyShip(EnemyShipFactory shipPartsFactory) {
	}

	
}
