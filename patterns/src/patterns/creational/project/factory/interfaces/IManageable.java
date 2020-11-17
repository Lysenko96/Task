package patterns.creational.project.factory.interfaces;

import patterns.creational.project.connection.IConnectable;
import patterns.creational.project.connection.IShareable;

// factory which create processes with priorities

public interface IManageable {
	
	// what factory will be create
	
	IConnectable createConnect(); // connections
	
	IShareable createPriority(); // priorities of connections
	
}
