package creational.abstracts.factory;

import creational.abstracts.factory.builder.EnermyShipBuilder;
import creational.abstracts.factory.builder.UFOEnermyShipBuilder;
import creational.abstracts.factory.entity.EnemyShip;

public class Client {

	public static void main(String[] args) {
		EnermyShipBuilder MakeUFOs = new UFOEnermyShipBuilder();
		
		
		EnemyShip theGrunt = MakeUFOs.orderTheShip("UFO"); 
		EnemyShip theBoss = MakeUFOs.orderTheShip("UFO BOSS");
		
		System.out.println(theGrunt);
		System.out.println(theBoss);
		
		
	}

}
