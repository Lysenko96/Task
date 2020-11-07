package patterns.structural.decorator;

public abstract class ControlFramework implements Interactive {

	protected Interactive interactive;

	public ControlFramework(Interactive interactive) {
		this.interactive = interactive;
	}

	public abstract String connectDatabase(String name, String password, String url);

	@Override
	public String makeDialogMenu(String nameFramework) {
		DataDB dataDB = new DataDB();
		String name = dataDB.getName();
		String password = dataDB.getPassword();
		String url = dataDB.getUrl() + interactive.getClass().getSimpleName() + ".com";
		return interactive.makeDialogMenu(nameFramework) + System.lineSeparator()
				+ connectDatabase(name, password, url);
	}

}
