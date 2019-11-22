package koha.event.example;

import java.util.function.Function;

public class main {
	public static void main(String[] args) {
		Function<Message<String>,String> uppercase = FunctionLib.uppercase();
		System.out.println(uppercase.apply(new Message<String>("hello")));
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



