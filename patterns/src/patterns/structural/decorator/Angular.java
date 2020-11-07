package patterns.structural.decorator;

public class Angular implements Interactive {

	@Override
	public String makeDialogMenu(String nameFramework) {
		return "I'm cool " + nameFramework + " because google support me!";
	}

}
