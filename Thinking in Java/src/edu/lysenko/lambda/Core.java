package edu.lysenko.lambda;

import java.util.ArrayList;
import java.util.List;
import static java.lang.System.out;

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
		if (!processes.isEmpty()) {

			for (Interactive process : processes) {

				if (process != null) {
					out.println("Sharing resources");
					out.println("PID[" + processes.indexOf(process) + "]");
					process.manage(process);
					out.println(process);

				} else {
					out.println("No process");
					break;
				}

			}

		}

	}

}
