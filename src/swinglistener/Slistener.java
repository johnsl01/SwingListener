/** 
* Slistener
*
* port listener class for Swing Listener 
*
*/

public class Slistener
             implements Runnable // because it is started as a thread by the gui
{
    // class variables 
    int port ; // the port on which to listen
    
  
    public Slistener ( int port)
    {
        this.port = port; // pick up port parameter and pass to class variable
        
  
  
} // class Slistener
