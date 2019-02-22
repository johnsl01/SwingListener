/**
* SwingListener
*
* Simple Listener with a Swing GUI - which listens on an IP port and reports on requests.
*
* No responses are currently implemented 
*
* This is juat a simple diagnostic tool
*/

package swinglistener;

// AWT imports
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.*;

// SWING imports
import javax.swing.JFrame ;
import javax.swing.GroupLayout;
import javax.swing.JLabel ;
import javax.swing.JButton ;
import javax.swing.JTextField ;
import javax.swing.JTextArea ;
import javax.swing.JScrollPane ;
import javax.swing.JComponent ;

public class SwingGet 
            extends JFrame   // because it needs to have a Swing GUI interface
            implements ActionListener  // because user gui interaction has to trigger actions
            
{
    // class constants
    private static final long serialVersionUID = 1L;
    public static final String TITLE = "Swing Listener (V 1.00 22/02/2019)" ;
    public static final String NEWLINE = "\n";
    // class variables
    static boolean DEBUG = true ;
    static Integer DEBUGLEVEL = 9 ;  // messages to the text area are filtered by this level
    
    // gui components - all within the class's JFrame
    static JLabel portLabel ;    
    static JTextField portText ;
    
    static JButton startButton ;
    static String startButtonText = "Start" ;
    static JButton clearTextButton ;
    static String clearTextButtonText = "Clear Results" ;
    
    static JTextArea reportArea ;
    static JScrollPane reportScrollPane ;

    // put the gui components into the layout 
	  // note comments to keep track of numbers - becomes important with complex layouts	
    createLayout (
                  portLabel, // item 0  
                  portText,
                  startButton,
                  clearTextButton,
                  reportScrollPane // item 4
		              );
                  
    // Class constructor
    public SwingListener()
    {
        initUI();
    } // SwingGet()
    
    private void initUI()
    {
      	// define the gui components being used
        portLabel = new JLabel ( "Port  : " ) ;
      	portText = new JTextField ( 6 ) ;
        startButton = new JButton ( startButtonText ) ;
        clearTextButton = new JButton ( clearTextButtonText ) ;
	      // JTextArea is within a JScrollPane
        reportArea = new JTextArea( "Output : \n", 20, 0  ) ;
        reportArea.setEditable(false);
        reportArea.setLineWrap(true);
        reportArea.setWrapStyleWord(true);
        reportScrollPane = new JScrollPane(reportArea);

        // put the gui components into the layout 
	      // note comments to keep track of numbers - becomes important with complex layouts	
        createLayout (
                      portLabel, // item 0  
                      portText,
                      startButton,
                      clearTextButton,
                      reportScrollPane // item 4
		                  ) ;
                      
        // basic window stuff
        setTitle ( TITLE ) ;
        setLocationRelativeTo ( null ) ;
        setDefaultCloseOperation(EXIT_ON_CLOSE) ;  
        
       // default port value - 8080 a typical proxy port
       // ... and a great little cpu back in the day ...
       portTest.setText ( "8080" ) ;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
                      


