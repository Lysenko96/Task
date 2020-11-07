package patterns.structural.decorator;

public class React implements Interactive {

	@Override
	public String makeDialogMenu(String nameFramework) {
		return "I'm best " + nameFramework + " because facebook support me!";
	}

}
