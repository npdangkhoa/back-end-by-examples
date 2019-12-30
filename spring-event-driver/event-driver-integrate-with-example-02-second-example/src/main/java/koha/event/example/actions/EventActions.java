package koha.event.example.actions;

import java.util.function.Function;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

public class EventActions {
	public static void main(final String[] args) {
		Function<Message<String>,String> uppercase = FunctionLib.uppercase();
		System.out.println(uppercase.apply(new GenericMessage<String>("hello")));
	}
}


class FunctionLib {
	public static Function<Message<String>, String> uppercase(){
		return v -> {
			System.out.println("Uppercase: " + v);
			return v.getPayload().toUpperCase();
		};
	}
}



