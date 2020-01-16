package behavioral.memento;

import java.util.ArrayList;
import java.util.List;

public class History {
	private List<EditorState> states = new ArrayList<EditorState>();
	
	public EditorState pop() {
		int lastIndex = states.size() - 1;
		EditorState lastItem = states.get(lastIndex);
		states.remove(lastIndex);
		return lastItem;
	}
	
	public void push(EditorState state) {
		states.add(state);
	}
}
