package patterns.creational.project.start;

import java.util.Arrays;

import patterns.creational.project.connection.IConnectable;
import patterns.creational.project.connection.IShareable;
import patterns.creational.project.factory.impl.MySQLSambaImpl;
import patterns.creational.project.factory.impl.PostgreSQLNFSImpl;
import patterns.creational.project.factory.interfaces.IManageable;

public class Main {

	private static IManageable manageable;

	public static void main(String[] args) {

		double number = Math.random();

		if (number >= 0.5) {
			manageable = new MySQLSambaImpl();
		} else {
			manageable = new PostgreSQLNFSImpl();
		}
		IConnectable connect = manageable.createConnect();

		IShareable share = manageable.createPriority();

		System.out.println(connect.connectDB("login", "password", "url"));
		System.out.println(connect.connectFS("login", "password"));
		System.out.println(connect.connectSite(192 + 168 + 1 + 1));

		System.out.println(Arrays.toString(share.shareResources("connectDB", "connectFS", "connectSite")));
	}
}
