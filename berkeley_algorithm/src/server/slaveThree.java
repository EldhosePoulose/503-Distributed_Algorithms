package server;

import static global.berkeleyParams.dateformatter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;
import global.berkeleyParams;

// Initiate the Slave 03
			
public class slaveThree {

	public static void main(String[] args) {
		try {
			clockServer ts03 = new clockServerImplementation(LocalTime.parse("12:03:59", dateformatter));
			Registry registry03 = LocateRegistry.createRegistry(berkeleyParams.serverport03);
			registry03.rebind(clockServerImplementation.class.getSimpleName(), ts03);
			System.out.println(String.format("Slave 03 started at port: %s", berkeleyParams.serverport03));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
