package patterns.creational.project.connection;

public interface IConnectable {

	String connectDB(String login, String password, String url);

	String connectFS(String login, String password);

	String connectSite(int IP);
	
}
