package test01.stub;

import com.simpleprogrammer.proteintracker.Notifier;

public class NotifierStub implements Notifier {

	@Override
	public boolean send(String message) {
		
		return true;
	}

}
