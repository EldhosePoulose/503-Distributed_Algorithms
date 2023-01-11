// This file includes the client side implementation of the algorithm
// 5 server/ slave machines time is fetched and the time is adjusted.
// time difference and the average of them is computed and adjusted.
//


package client;
import java.rmi.*;
import java.rmi.registry.*;
import static global.berkeleyParams.dateformatter;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;
import java.util.ArrayList;
import global.berkeleyParams;
import server.clockServer;
import server.clockServerImplementation;

//master/Client Side Implementation

public class masterClock {

	public static void main(String[] args) {
		try {
			var slavetimes = new ArrayList<LocalTime>();
			
			LocalTime masterTime = LocalTime.parse("12:00:00", berkeleyParams.dateformatter);
			slavetimes.add(masterTime);
			System.out.println("Local time: " + dateformatter.format(masterTime));
			
			System.out.println("###### Berkeley Algorithm ######");
			System.out.println("###### Fetched the Master Clock ######");
			
			// Connect to slave 01 and get Time
			Registry registry01 = LocateRegistry.getRegistry(berkeleyParams.servername01, berkeleyParams.serverport01);
			clockServer ts01 = (clockServer) registry01.lookup(clockServerImplementation.class.getSimpleName());
			System.out.println("Connected successfully to: SLAVE 01");
			LocalTime slaveTime01 = ts01.getTime();
			slavetimes.add(slaveTime01);
			System.out.println("time at slave 01 is: " + dateformatter.format(slaveTime01));

			// Connect to slave 02 and get Time
			Registry registry02 = LocateRegistry.getRegistry(berkeleyParams.servername02, berkeleyParams.serverport02);
			clockServer ts02 = (clockServer) registry02.lookup(clockServerImplementation.class.getSimpleName());
			System.out.println("Connected successfully to: SLAVE 02");
			LocalTime slaveTime02 = ts02.getTime();
			slavetimes.add(slaveTime02);
			System.out.println("time at slave 02 is: " + dateformatter.format(slaveTime02));


			// Connect to slave 03 and get Time
			Registry registry03 = LocateRegistry.getRegistry(berkeleyParams.servername03, berkeleyParams.serverport03);
			clockServer ts03 = (clockServer) registry03.lookup(clockServerImplementation.class.getSimpleName());
			System.out.println("Connected successfully to: SLAVE 03");
			LocalTime slaveTime03 = ts03.getTime();
			slavetimes.add(slaveTime03);
			System.out.println("time at slave 03 is: " + dateformatter.format(slaveTime03));
			
			// Connect to slave 04 and get Time
			Registry registry04 = LocateRegistry.getRegistry(berkeleyParams.servername04, berkeleyParams.serverport04);
			clockServer ts04 = (clockServer) registry04.lookup(clockServerImplementation.class.getSimpleName());
			System.out.println("Connected successfully to: SLAVE 04");
			LocalTime slaveTime04 = ts04.getTime();
			slavetimes.add(slaveTime04);
			System.out.println("time at slave 04 is: " + dateformatter.format(slaveTime04));

			// Connect to slave 04 and get Time
			Registry registry05 = LocateRegistry.getRegistry(berkeleyParams.servername05, berkeleyParams.serverport05);
			clockServer ts05 = (clockServer) registry05.lookup(clockServerImplementation.class.getSimpleName());
			System.out.println("Connected successfully to: SLAVE 05");
			LocalTime slaveTime05 = ts05.getTime();
			slavetimes.add(slaveTime05);
			System.out.println("time at slave 05 is: " + dateformatter.format(slaveTime05));

// COMPUTATION of TIME DIFFERENCE AND AVERAGING THEM
			
			var localTimeSeconds = masterTime.toSecondOfDay();
			
			var delta01 = slaveTime01.toSecondOfDay() - localTimeSeconds;
			var delta02 = slaveTime02.toSecondOfDay() - localTimeSeconds;
			var delta03 = slaveTime03.toSecondOfDay() - localTimeSeconds;
			var delta04 = slaveTime04.toSecondOfDay() - localTimeSeconds;
			var delta05 = slaveTime05.toSecondOfDay() - localTimeSeconds;
			
			var delta_average = (delta01 + delta02 + delta03 + delta04 + delta05) / 5; 
			System.out.println("Average Delta Computed is: "+delta_average+" seconds");

			// Assign new time to the nodes
			ts01.adjustTime(masterTime, delta_average);
			ts02.adjustTime(masterTime, delta_average);
			ts03.adjustTime(masterTime, delta_average);
			ts04.adjustTime(masterTime, delta_average);
			ts05.adjustTime(masterTime, delta_average);
			masterTime = masterTime.plusSeconds(delta_average);
			System.out.println("Successfully Updated the Clock...");

			// Verifying the time on all machines
			System.out.println("New Master/Local Time: " + dateformatter.format(masterTime));
			System.out.println("New time at slave 01 is: " + dateformatter.format(ts01.getTime()));
			System.out.println("New time at slave 02 is: " + dateformatter.format(ts02.getTime()));
			System.out.println("New time at slave 03 is: " + dateformatter.format(ts03.getTime()));
			System.out.println("New time at slave 04 is: " + dateformatter.format(ts04.getTime()));
			System.out.println("New time at slave 05 is: " + dateformatter.format(ts05.getTime()));

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
