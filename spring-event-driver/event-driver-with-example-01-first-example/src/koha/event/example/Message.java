package koha.event.example;

public class Message<T> {
	private T payload;
	
	public Message(T t) {
		payload = t;
	}

	public T getPayload() {
		return payload;
	}

}
