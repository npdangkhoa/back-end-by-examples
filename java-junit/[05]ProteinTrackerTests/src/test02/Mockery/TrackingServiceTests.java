package test02.Mockery;
import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import com.simpleprogrammer.proteintracker.HistoryItem;
import com.simpleprogrammer.proteintracker.InvalidGoalException;
import com.simpleprogrammer.proteintracker.Notifier;
import com.simpleprogrammer.proteintracker.TrackingService;


public class TrackingServiceTests {

	private TrackingService service;
	
	
	
	@Test
	public void WhenGoalIsMetHistoryIsUpdated() throws InvalidGoalException
	{
		Mockery context = new Mockery();
		final Notifier mockNotifier = context.mock(Notifier.class);
		
		service = new TrackingService(mockNotifier);
		
		context.checking(new Expectations() {{
			oneOf(mockNotifier).send("goal met");
			will(returnValue(true));
		}});
		
		service.setGoal(5);
		service.addProtein(6);
		
		HistoryItem result = service.getHistory().get(1);
		assertEquals("sent:goal met", result.getOperation());
		
		context.assertIsSatisfied();
	}	
}
