package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Program {

	String name;
	List<Byte> code = new ArrayList<>();

	public Program() {
	}

	public Program(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Byte> getCode() {
		return code;
	}

	public void setCode(List<Byte> code) {
		this.code = code;
	}

}
