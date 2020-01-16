package behavioral.observer;

public class Client {

	public static void main(String[] args) {
		StockGrabberSubject subject = new StockGrabberSubject();
		
		new StockObserver(subject);


		subject.setIbmPrice(1975);
		subject.setApplPrice(1977);
		subject.setGoogPrice(1976);
		
		new StockObserver(subject);
		
		subject.setIbmPrice(2975);
		subject.setApplPrice(2977);
		subject.setGoogPrice(2976);


	}

}
