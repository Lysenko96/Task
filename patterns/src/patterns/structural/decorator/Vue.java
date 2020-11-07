package patterns.structural.decorator;

public class Vue implements Interactive {

	@Override
	public String makeDialogMenu(String nameFramework) {
		return "I'm beautiful " + nameFramework + " because one man support me!";
	}

}
