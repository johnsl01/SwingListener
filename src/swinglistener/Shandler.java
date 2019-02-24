/** 
* Shandler
*
* connection handler class for Swing Listener 
* 
* initiated from Slistener
*
*/

package swinglistener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
// import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import static swinglistener.SwingListener.println;

public class Shandler 
			implements Runnable // because it is started as a thread by the listener
{
	// class variables 
	Socket incomingSocket ;
	
	BufferedReader incomingBReader ;
	
	String incomingRequest ;

	public Shandler(Socket skt)
	{
		println(6, "In Shandler . Shandler ()  " );
		incomingSocket = skt;
		
		try
		{
			incomingSocket.setSoTimeout(5000);
			incomingBReader = new BufferedReader(new InputStreamReader(incomingSocket.getInputStream())) ;
			// incomingBWriter = new BufferedWriter(new OutputStreamWriter(incomingSocket.getOutputStream()));
		} 
		catch (Exception e) 
		{
			println(0, "Exception in Shandler . Shandler () - socketTO and BReader setup " );
		}
		
		
		
		
	} // Shandler()
	

	public void run()
	{
		println(6, "In Shandler . run ()  " );
		try
		{
			incomingRequest = incomingBReader.readLine();
			println(0, "---> " + incomingRequest );
		}
		catch (Exception e)
		{
			println(0, "Exception in Shandler . run () -  BReader readline " );
		}
		
		
	} // run()
	
} // class Shandler
