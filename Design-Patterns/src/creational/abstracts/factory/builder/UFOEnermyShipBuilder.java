package creational.abstracts.factory.builder;

import creational.abstracts.factory.entity.EnemyShip;
import creational.abstracts.factory.entity.UFOBossEnemyShip;
import creational.abstracts.factory.entity.UFOEnemyShip;
import creational.abstracts.factory.factory.EnemyShipFactory;
import creational.abstracts.factory.factory.UFOBossEnemyShipFactory;
import creational.abstracts.factory.factory.UFOEnemyShipFactory;

public class UFOEnermyShipBuilder extends EnermyShipBuilder {

	@Override
	protected EnemyShip makeEnemyTheShip(String typeOfShip) {
		EnemyShip enemyShip = null;
		EnemyShipFactory shipPartsFactory = null;
		switch (typeOfShip) {
		case "UFO":
			shipPartsFactory= new UFOEnemyShipFactory();
			enemyShip = new UFOEnemyShip(shipPartsFactory);
			enemyShip.setName("UFO Grunt Ship");
			break;
		case "UFO BOSS":
			shipPartsFactory = new UFOBossEnemyShipFactory();
			enemyShip = new UFOBossEnemyShip(shipPartsFactory);
			enemyShip.setName("UFO Boss Ship");
			break;
		default:
			
			break;
		}
		return enemyShip;
	}

}
