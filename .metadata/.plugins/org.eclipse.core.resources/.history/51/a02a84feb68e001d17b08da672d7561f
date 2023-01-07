package server;

import static global.berkeleyParams.dateformatter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;
import global.berkeleyParams;

// Initiate the Slave 05
			
public class slave05 {

	public static void main(String[] args) {
		try {
			clockServer ts05 = new clockServerImplementation(LocalTime.parse("12:05:00", dateformatter));
			Registry registry05 = LocateRegistry.createRegistry(berkeleyParams.serverport05);
			registry05.rebind(clockServerImplementation.class.getSimpleName(), ts05);
			System.out.println(String.format("Slave 05 started at port: %s", berkeleyParams.serverport05));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
