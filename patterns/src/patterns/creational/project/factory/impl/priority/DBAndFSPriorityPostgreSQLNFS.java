package patterns.creational.project.factory.impl.priority;

import patterns.creational.project.connection.IShareable;

public class DBAndFSPriorityPostgreSQLNFS implements IShareable {

	@Override
	public int[] shareResources(String connectDB, String connectFS, String connectSite) {
		return new int[] { 3, 2, 1 };
	}

}
