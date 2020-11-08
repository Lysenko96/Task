package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Software implements Executable {

	private List<SoftwareListener> listeners = new ArrayList<>();

	public List<SoftwareListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<SoftwareListener> listeners) {
		this.listeners = listeners;
	}

	@Override
	public Byte[] download() {
		Byte[] bytes = new Byte[100];
		for (int index = 0; index < 100; index++) {
			bytes[index] = (byte) new Random().nextInt(127);
		}
		return bytes;
	}

	@Override
	public Program setup() {
		Program install = new Program();
		List<Byte> byteInstall = new ArrayList<>();
		for (int index = 0; index < 100; index++) {
			if (index % 2 == 0)
				byteInstall.add((byte) new Random().nextInt(63));
			else
				Collections.copy(Arrays.asList(download()), byteInstall);

		}
		install.code = byteInstall;
		return install;
	}

	@Override
	public Program run() {
		return new Program();
	}

	@Override
	public List<SoftwareListener> sendProgram(String name) {
		for (SoftwareListener actionListener : listeners) {
			actionListener.send(name);
		}
		return listeners;
	}

	void createPackageForSender(String name) {
		System.out.println("Setup: " + setup().code + System.lineSeparator() + "Run: " + run().toString()
				+ System.lineSeparator() + name);
		for (SoftwareListener actionListener : listeners) {
			System.out.println(actionListener.send(name));
		}

	}

}
