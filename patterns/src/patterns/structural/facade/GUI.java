package patterns.structural.facade;

public class GUI {

	String showResult() {
		return new GUI().toString();
	}
}
