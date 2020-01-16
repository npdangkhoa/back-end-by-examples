package creational.abstracts.factory.factory;

import creational.abstracts.factory.dto.ESEngine;
import creational.abstracts.factory.dto.ESWeapon;
import creational.abstracts.factory.dto.impl.ESUFOEngine;
import creational.abstracts.factory.dto.impl.ESUFOGun;

public class UFOEnemyShipFactory implements EnemyShipFactory {

	@Override
	public ESWeapon addESGun() {
		return new ESUFOGun();
	}

	@Override
	public ESEngine addESEngine() {
		return new ESUFOEngine();
	}

}
