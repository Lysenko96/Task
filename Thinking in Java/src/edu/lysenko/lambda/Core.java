package edu.lysenko.lambda;

import java.util.ArrayList;
import java.util.List;

public class Core {

	private List<Interactive> processes = new ArrayList<>();

	public void addInteractiveProcess(Interactive process) {
		processes.add(process);
	}

	public void addInteractiveProcess() {
		processes.add(null);
	}

	public void removeInteractiveProcess(Interactive process) {
		processes.remove(process);
	}

	public void removeInteractiveProcess() {
		processes.remove(null);
	}

	void sharingResources() {
		System.out.println("Sharing resources");
		if (!processes.isEmpty()) {
			for (Interactive process : processes) {
				if (process != null) {
					process.manage();
				} else {
					System.out.println("No users");
					break;
				}
			}
		}
	}

}
