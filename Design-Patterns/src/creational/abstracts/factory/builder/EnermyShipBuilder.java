package creational.abstracts.factory.builder;

import creational.abstracts.factory.entity.EnemyShip;

public abstract class EnermyShipBuilder {

	protected abstract EnemyShip makeEnemyTheShip(String typeOfShip);

	public EnemyShip orderTheShip(String typeOfShip) {
		
		EnemyShip theShip = makeEnemyTheShip(typeOfShip);
		
		theShip.makeShip();
		theShip.displayEnemyShip();
		theShip.followHeroShip();
		theShip.enemyShipShoots();
		
		return theShip;
	}
}
