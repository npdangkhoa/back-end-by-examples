package creational.abstracts.factory.factory;

import creational.abstracts.factory.dto.ESEngine;
import creational.abstracts.factory.dto.ESWeapon;
import creational.abstracts.factory.dto.impl.ESUFOBossEngine;
import creational.abstracts.factory.dto.impl.ESUFOBossGun;

public class UFOBossEnemyShipFactory implements EnemyShipFactory {

	@Override
	public ESWeapon addESGun() {
		return new ESUFOBossGun();
	}

	@Override
	public ESEngine addESEngine() {
		return new ESUFOBossEngine();
	}

}
