package patterns.creational.project.factory.impl.connection;

import patterns.creational.project.connection.IConnectable;

public class MySQLSamba implements IConnectable {

	@Override
	public String connectDB(String login, String password, String url) {
		return "jdbc:mysql://localhost:3306/database";
	}

	@Override
	public String connectFS(String login, String password) {
		return "/usr/bin/smbclient \\\\\\\\home\\\\user mypasswd";
	}

	@Override
	public String connectSite(int IP) {
		return "http://www.site.com";
	}

}
