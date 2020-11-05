package patterns.creational.project.factory.impl.connection;

import patterns.creational.project.connection.IConnectable;

public class PostgreSQLNFS implements IConnectable {

	@Override
	public String connectDB(String login, String password, String url) {
		return "jdbc:postgresql://host:port/database";
	}

	@Override
	public String connectFS(String login, String password) {
		return "/var/share && touch file-example";
	}

	@Override
	public String connectSite(int IP) {
		return "http://www.newsite.com";
	}

}
