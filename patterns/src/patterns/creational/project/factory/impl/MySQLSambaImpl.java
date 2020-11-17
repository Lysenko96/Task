package patterns.creational.project.factory.impl;

import patterns.creational.project.connection.IConnectable;
import patterns.creational.project.connection.IShareable;
import patterns.creational.project.factory.impl.connection.MySQLSamba;
import patterns.creational.project.factory.impl.priority.DBAndFSPriorityMySQLSamba;
import patterns.creational.project.factory.interfaces.IManageable;

// special factory
public class MySQLSambaImpl implements IManageable {

	@Override
	public IConnectable createConnect() {
		return new MySQLSamba();
	}

	@Override
	public IShareable createPriority() {
		return new DBAndFSPriorityMySQLSamba();
	}

}
