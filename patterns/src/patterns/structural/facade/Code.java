package patterns.structural.facade;

import java.util.Deque;

public class Code {

	private Deque<String> code;

	public Code(Deque<String> stack) {
		this.code = stack;
	}

	public Deque<String> getCode() {
		return code;
	}

	public void setCode(Deque<String> code) {
		this.code = code;
	}

}
