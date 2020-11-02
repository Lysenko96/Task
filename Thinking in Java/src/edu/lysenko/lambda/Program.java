package edu.lysenko.lambda;

public class Program {

	public static void main(String[] args) {
		User user = new User();
		Core core = new Core();
		Core coreNoProcess = new Core();
		USB usb = new USB();
		// event subscribe
		core.addInteractiveProcess(user);
		coreNoProcess.addInteractiveProcess();
		core.addInteractiveProcess(usb);
		// coreNoUsers.removeInteractiveProcess();

		core.sharingResources();
		coreNoProcess.sharingResources();
		core.sharingResources();

	}

}
