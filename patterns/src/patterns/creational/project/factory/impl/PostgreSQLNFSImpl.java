package patterns.creational.project.factory.impl;

import patterns.creational.project.connection.IConnectable;
import patterns.creational.project.connection.IShareable;
import patterns.creational.project.factory.impl.connection.PostgreSQLNFS;
import patterns.creational.project.factory.impl.priority.DBAndFSPriorityPostgreSQLNFS;
import patterns.creational.project.factory.interfaces.IManageable;

// special factory

public class PostgreSQLNFSImpl implements IManageable {

	@Override
	public IConnectable createConnect() {
		return new PostgreSQLNFS();
	}

	@Override
	public IShareable createPriority() {
		return new DBAndFSPriorityPostgreSQLNFS();
	}

}
