package behavioral.observer;

public class StockObserver implements Observer {

	private static int observerIDTracker = 0;
	
	private int observerId;
	private int ibmPrice;
	private int applPrice;
	private int googPrice;
	
	private Subject subject;
	
	 
	
	public StockObserver() {
		super();
	}




	public StockObserver(Subject subject) {
		super();
		this.subject = subject;
		observerId = ++observerIDTracker;
		System.out.println("New Observer " + this.observerId);
		
		this.subject.register(this);
	}
	



	@Override
	public void update(int ibmPrice, int applPrice, int googPrice) {
		this.ibmPrice = ibmPrice;
		this.applPrice  = applPrice;
		this.googPrice = googPrice;
		print();
	}




	
	public void print() {
		System.out.println(">>>>>>>>>>>>>>>>>>>>>ObserverId:  " + this.observerId);
		
		String result =  "StockObserver [ibmPrice=" + ibmPrice + ", applPrice=" + applPrice
				+ ", googPrice=" + googPrice + "]";
		System.out.println(result);
	}
	
	
	
}
