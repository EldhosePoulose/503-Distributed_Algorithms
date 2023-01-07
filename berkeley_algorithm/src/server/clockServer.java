// This fetch the delta value of the clock and adjust the Time.


package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;


public interface clockServer extends Remote{
	
	LocalTime getTime() throws RemoteException;
	void adjustTime(LocalTime slaveTime, long delta) throws RemoteException;

}


