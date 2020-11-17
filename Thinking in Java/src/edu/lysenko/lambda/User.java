package edu.lysenko.lambda;

public class User implements Interactive {

	void useGUI() {
		System.out.println("use GUI");
	}

	@Override
	public void manage() {
		useGUI();
	}

}
