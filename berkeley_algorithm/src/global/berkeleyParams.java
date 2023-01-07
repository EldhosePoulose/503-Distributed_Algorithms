// Here we provide random port number to all the slaves we defined.
package global;

import java.time.format.DateTimeFormatter;

public interface berkeleyParams {
	
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
	
	public final DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("HH:mm:ss");

}
