
// Slave 01 Implementation
// Transmit the clock time

package server;

import static global.berkeleyParams.dateformatter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;
import global.berkeleyParams;

// Initiate the Slave 04
			
public class slaveFour {

	public static void main(String[] args) {
		try {
			clockServer ts04 = new clockServerImplementation(LocalTime.parse("12:04:00", dateformatter));
			Registry registry04 = LocateRegistry.createRegistry(berkeleyParams.serverport04);
			registry04.rebind(clockServerImplementation.class.getSimpleName(), ts04);
			System.out.println(String.format("Slave 04 started at port: %s", berkeleyParams.serverport04));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
