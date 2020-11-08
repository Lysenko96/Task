package patterns.behavioral.observer;

public class UserOne implements SoftwareListener {

	@Override
	public Program send(String name) {
		// get package "java" from createPackageForSender()
		System.out.println(this.getClass().getSimpleName() + " use " + name.split(" ")[1]);
		return new Program(name);
	}

}
