package edu.lysenko.lambda;
import static java.lang.System.out;
public class GUI implements Interactive {

	void workGUI() {
		out.println("Work GUI");
	}

	@Override
	public void manage(Object handle) {
		workGUI();
	}

}
