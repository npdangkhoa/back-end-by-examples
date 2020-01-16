package creational.factory;

public class Client {
	public static void main(String[] args) {
		
		Ship ufoShip = EnemyShipFactory.makeEnemyShip("U");
		
		doStuffEnemy(ufoShip);
	}

	private static void doStuffEnemy(Ship ufoShip) {
		ufoShip.displayEnemyShip();
		ufoShip.followHeroShip();
		ufoShip.enemyShipShoots();
	}
}
