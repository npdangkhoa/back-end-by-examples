package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class StockGrabberSubject implements Subject {
	private int ibmPrice;
	private int applPrice;
	private int googPrice;
	
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	public void register(Observer observer) {
		observers.add(observer);
	}
	
	public void unregister(Observer observer) {
		int indexOf = observers.indexOf(observer);
		observers.remove(indexOf);
		System.out.println("Observer " + (indexOf + 1) + "deleted");

	}
	
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(ibmPrice, applPrice, googPrice);
		}
	}

	public void setIbmPrice(int ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObserver();
	}

	public void setApplPrice(int applPrice) {
		this.applPrice = applPrice;
		notifyObserver();
	}

	public void setGoogPrice(int googPrice) {
		this.googPrice = googPrice;
		notifyObserver();
	}
	
	
	

}
