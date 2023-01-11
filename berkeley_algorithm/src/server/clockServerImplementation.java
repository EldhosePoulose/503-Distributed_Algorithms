// used to monitor the clock updation

package server;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import global.berkeleyParams;

public class clockServerImplementation extends UnicastRemoteObject implements clockServer {
	
	private LocalTime time;
	public clockServerImplementation(LocalTime time) throws RemoteException {
		this.time = time; // fetch the time
	}
	
	@Override
	public LocalTime getTime() throws RemoteException {
		return time;
	}
	
	@Override
	public void adjustTime(LocalTime slaveTime, long delta) throws RemoteException {
		long localTime = slaveTime.toSecondOfDay(); // fetch the time from slaves in seconds
		long serverTime = this.getTime().toSecondOfDay(); // fetch the time from master in seconds
		var deltaTime = serverTime - localTime; // compute the difference in time between master and slave
		deltaTime = deltaTime * -1 + delta + serverTime;
		LocalTime updatedClock = LocalTime.ofSecondOfDay(deltaTime);
		System.out.println("Updated Time is: " + berkeleyParams.dateformatter.format(updatedClock));
		this.time = updatedClock;
	}		
		
}