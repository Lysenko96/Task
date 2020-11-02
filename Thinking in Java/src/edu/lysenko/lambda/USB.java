package edu.lysenko.lambda;

public class USB implements Interactive {

	void mountUSB() {
		System.out.println("Mount USB");
	}

	@Override
	public void manage() {
		mountUSB();
	}

}
