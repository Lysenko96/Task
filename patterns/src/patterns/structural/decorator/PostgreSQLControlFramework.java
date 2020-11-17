package patterns.structural.decorator;

public class PostgreSQLControlFramework extends ControlFramework {

	public PostgreSQLControlFramework(Interactive interactive) {
		super(interactive);
	}

	@Override
	public String connectDatabase(String name, String password, String url) {
		return name + System.lineSeparator() + password + System.lineSeparator() + url;
	}

}
