package patterns.creational.project.factory.impl.priority;

import patterns.creational.project.connection.IShareable;

public class DBAndFSPriorityMySQLSamba implements IShareable {

	@Override
	public int[] shareResources(String connectDB, String connectFS, String connectSite) {
		return new int[] { 1, 2, 3 };
	}

}
