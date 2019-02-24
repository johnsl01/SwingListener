/** 
* Slistener
*
* port listener class for Swing Listener 
*
*/

package swinglistener ;

import java.util.ArrayList;

import static swinglistener.SwingListener.println;

// import java.io.IOException;

import java.net.Socket;
// import java.net.SocketException;
import java.net.ServerSocket;

import static swinglistener.SwingListener.println;

// import swinglistener.Shandler;

public class Slistener
             implements Runnable // because it is started as a thread by the gui
{
    // class variables 
    int port = 0 ; // the port on which to listen
    
    static ArrayList<Thread> handlers;
    
    ServerSocket incomingSocket;
    
  
    public Slistener ( int port)
    {
        this.port = port ; // pick up port parameter and pass to class variable
        swinglistener.SwingListener.println(9," ");
        println(6, "In Slistener . Slistener ()  " );
        println(6, "In Slistener . Slistener () -- port is " + port + " " );
        println(6, "In Slistener . Slistener () -- this.port is " + this.port + " " );
        test() ;
        // set up array list
        handlers = new ArrayList<>();
        // set up incomingsocket serversoket
        try
        {
        	incomingSocket = new ServerSocket (port) ;
        }
        catch (Exception e)
        {
        	println(0, "Exception setting up Server Socket");
        }
        
    } // Slistener ()
    
    public void test()
    {   	
    	println(6, "In Slistener . test () " );
    	println(6, "In Slistener . test () -- port is " + port + " " );
    	println(6, "In Slistener . test () -- this.port is " + this.port + " " );
    }
    
    public void listen(int port)
    {
		while(true)
		{
			try 
			{
				// wait for connections on existing server socket 
				Socket skt = incomingSocket.accept();
				
				// Construct new handler thread
				Thread sh = new Thread(new Shandler(skt));
				
				// store threads in array list as created
				handlers.add(sh);
				
				sh.start();	
			} 
			catch (Exception e) 
			{				 
				println(0, "Exception strating new handler");
			} 

		}
	}
    
    public void run()
    {   	
    	println(6, "In Slistener . run () " );
    	println(6, "In Slistener . run () -- port is " + port + " " );
    	println(6, "In Slistener . run () -- this.port is " + this.port + " " );
    	test() ;
    	listen(port);
    }
  
} // class Slistener
