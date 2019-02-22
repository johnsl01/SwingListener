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
    
    statis int port = 8080 ;  // the port on which to listen
    
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
        portText.setText ( "8080" ) ;
        
        // add the listeners to the components which need to trigger actions
        // note - changing the URL text is not set to trigger anything
        startButton.addActionListener(this) ;
        clearTextButton.addActionListener(this) ; 
    } // initUI()        
        
    private void createLayout (JComponent... arg)
    {
        Container pane = getContentPane() ;		
	GroupLayout gl = new GroupLayout ( pane ) ;		
	pane.setLayout( gl ) ;
        
        gl.setAutoCreateContainerGaps(true) ;
        gl.setAutoCreateGaps(true) ;
        
	// this is a really tedious mechanism
	// the horizontal and vertical groups define the same stuff
	// but horizontal is parallel then sequential groups
	// whereas vertical is sequental then parallel groups
	// it becomes very messy for complex gui layouts
	// and arguement numbering makes it easy to mess up
	// there is probably a better way - but this works.
	// The layout we want here is :
	//   0    1   :      portLabel       portText
	//   2    3   :      startButton     cleartextButton
	//      4     :           reportSrollPane
        gl.setHorizontalGroup (
            gl.createParallelGroup() 
                .addGroup(gl.createSequentialGroup()
                    .addComponent(arg[0])
                    .addComponent(arg[1]) 
                )
                .addGroup(gl.createSequentialGroup()
                    .addComponent(arg[2])
                    .addComponent(arg[3]) 
                )
                .addComponent(arg[4]) 
        ) ;
        gl.setVerticalGroup (
            gl.createSequentialGroup() 
                .addGroup(gl.createParallelGroup()
                    .addComponent(arg[0])
                    .addComponent(arg[1]) 
                )
                .addGroup(gl.createParallelGroup()
                    .addComponent(arg[2])
                    .addComponent(arg[3]) 
                )
                .addComponent(arg[4]) 
        ) ;        
        gl.linkSize(arg[1])		
	pack();        
    }  // createLayout ()    
    
    
    public void actionPerformed ( ActionEvent e )			
    {
        String actionCommandText ;
        actionCommandText = e.getActionCommand() ;
        
        println( 3, "In actionPerformed ....." ) ;
        println( 3, "Action Command Text :>" + actionCommandText + "<") ;
        
        
        if ( actionCommandText.equals( startButtonText ) )
	{
            println( 3, "Start Button Pressed .... " ) ;
            try 
            {
                port = Integer.parseInt(portText.getText());
                println( 0, "Starting Listener on " + port  + NEWLINE ) ;
                page = getPage(url);
                println( 0, page + NEWLINE + NEWLINE ) ;
            }
            catch (Exception f)
            {
                println( 0, "Oops .. failed to get page \n" ) ;
            }
        }
        else if ( actionCommandText.equals( clearTextButtonText ) )
        {
            // println( 3, "Clear Results Button Pressed .... " ) ; // duh ! 
            reportArea.setText( "Output (reset) : \n" );
        }
        else 
        {
            println( 0, "unidentified action requested >" + actionCommandText + "<" ) ;
        }
           
    } // actionPerformed ()
        
        
        
        
        
        
        
        
        
                      


