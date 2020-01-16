package creational.factory;

public class EnemyShipFactory {
	public static Ship makeEnemyShip(String name) {
		switch (name) {
		case "U":
			return new UFOEnemyShip();
		case "R":
			return new RocketEnemyShip();
		default:
			return null;
		}
	}
}
