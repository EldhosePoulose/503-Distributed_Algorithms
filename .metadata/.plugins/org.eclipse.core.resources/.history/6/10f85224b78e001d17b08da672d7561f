package server;

import static global.berkeleyParams.dateformatter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;
import global.berkeleyParams;

// Initiate the Slave 02
			
public class slave02 {

	public static void main(String[] args) {
		try {
			clockServer ts02 = new clockServerImplementation(LocalTime.parse("12:02:50", dateformatter));
			Registry registry02 = LocateRegistry.createRegistry(berkeleyParams.serverport02);
			registry02.rebind(clockServerImplementation.class.getSimpleName(), ts02);
			System.out.println(String.format("Slave 02 started at port: %s", berkeleyParams.serverport02));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
