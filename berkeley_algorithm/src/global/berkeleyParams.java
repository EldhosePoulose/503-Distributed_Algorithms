// Here we provide random port number to all the slaves we defined.
//

package global;

import java.time.format.DateTimeFormatter;

public interface berkeleyParams {
	// Define Port and name for all the nodes in the network.
	// this values will be later used.

	public final String servername01 = "localhost";
	public final int serverport01 = 1501;
	
	public final String servername02 = "localhost";
	public final int serverport02 = 1502;
	
	public final String servername03 = "localhost";
	public final int serverport03 = 1503;

	public final String servername04 = "localhost";
	public final int serverport04 = 1504;
	
	public final String servername05 = "localhost";
	public final int serverport05 = 1505;
	
	// used for format the time in specific standard format
	public final DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("HH:mm:ss");

}
