package behavioral.memento;

public class Client {
	public static void main(String[] args) {
		Editor edit = new Editor();
		History history = new History();
		
		edit.setContent("a");
		history.push(edit.createState());
		edit.setContent("b");
		history.push(edit.createState());
		edit.setContent("c");
		
		edit.resore(history.pop());
		edit.resore(history.pop());

		System.out.println(edit);
	}
}
