package test01.stub;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.simpleprogrammer.proteintracker.HistoryItem;
import com.simpleprogrammer.proteintracker.InvalidGoalException;
import com.simpleprogrammer.proteintracker.SMSNotifier;
import com.simpleprogrammer.proteintracker.TrackingService;


public class TrackingServiceTests {

	private TrackingService service;
	
	
	@Test
	public void WhenGoalIsMetHistoryIsUpdatedWithSMSNotifier() throws InvalidGoalException
	{
		
		service = new TrackingService(new SMSNotifier(" userName", " password", " numberToMessage"));
	
		service.setGoal(5);
		service.addProtein(6);
		
		HistoryItem result = service.getHistory().get(1);
		assertEquals("sent:goal met", result.getOperation());
		
	}	
	
	
	@Test
	public void WhenGoalIsMetHistoryIsUpdatedWithNotifierStub() throws InvalidGoalException
	{
		
		service = new TrackingService(new NotifierStub());
	
		service.setGoal(5);
		service.addProtein(6);
		
		HistoryItem result = service.getHistory().get(1);
		assertEquals("sent:goal met", result.getOperation());
		
	}		
	
}
