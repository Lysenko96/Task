package patterns.behavioral.observer;

import java.util.List;

public interface Executable {

	Byte[] download();

	Program setup();

	Program run();

	List<SoftwareListener> sendProgram(String name);
}
