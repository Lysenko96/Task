package edu.lysenko.lambda;

import static java.lang.System.out;

public class Program {

	private static Object addNetwork(Object object) {
		return "Network access: " + object;
	}

	public static void main(String[] args) {
		GUI shellGUI = new GUI();
		Core core = new Core();
		Core coreNoProcess = new Core();
		USB usb = new USB();

		// event subscribe
		core.addInteractiveProcess(shellGUI);
		coreNoProcess.addInteractiveProcess();
		core.addInteractiveProcess(usb);

		// use object such function
		core.addInteractiveProcess(handle -> {
			out.println("Divece connect");
			out.println("complete");
		});

		// return object
		core.addInteractiveProcess(network -> out.println(Program.addNetwork(network)));

		// return boolean
		core.addInteractiveProcess(Program::addNetwork);
		core.sharingResources();
		coreNoProcess.sharingResources();

	}

}
