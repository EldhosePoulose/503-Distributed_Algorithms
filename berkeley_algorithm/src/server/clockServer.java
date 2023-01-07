package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;


public interface clockServer extends Remote{
	
	LocalTime getTime() throws RemoteException;
	void adjustTime(LocalTime slaveTime, long delta) throws RemoteException;

}


