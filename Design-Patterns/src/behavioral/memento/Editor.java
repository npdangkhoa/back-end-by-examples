package behavioral.memento;

public class Editor {
	private String content;

	public void resore(EditorState state) {
		content = state.getContent();
	}
	
	public EditorState createState() {
		return new EditorState(content);
	}
	
	
	public Editor(String content) {
		super();
		this.content = content;
	}


	public String getContent() {
		return content;
	}

	public Editor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Editor [content=" + content + "]";
	}
	
	
	
	

}
