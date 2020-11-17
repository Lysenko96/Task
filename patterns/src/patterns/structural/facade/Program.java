package patterns.structural.facade;

import java.util.ArrayDeque;
import java.util.Deque;

public class Program {

	Code makeProgram() {

		Deque<String> stack = new ArrayDeque<>();

		stack.addFirst(new Platform().checkPlatform().toString());
		stack.addFirst(String.valueOf(new Logic().method()));
		stack.addFirst(new GUI().showResult());

		return new Code(stack);
	}
}
