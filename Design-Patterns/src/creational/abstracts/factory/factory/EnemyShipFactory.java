package creational.abstracts.factory.factory;

import creational.abstracts.factory.dto.ESEngine;
import creational.abstracts.factory.dto.ESWeapon;

public interface EnemyShipFactory {
	public ESWeapon addESGun();
	public ESEngine addESEngine();
}
