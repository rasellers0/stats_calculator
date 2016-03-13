package stats_calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static stats_calculator.PermutationWindow.factorial;

/**
 *
 * @author rasellers0
 */
public class ProbabilityWindow extends JDialog {

    
    public ProbabilityWindow(JFrame frame){
        super(frame, "Probability Calculator", true);
        setLayout(new FlowLayout());
        createUserInterface();
        
    }
    
     public void createUserInterface()
   {
       Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI component
       contentPane.setLayout( null );
       
       //start building gui components here
       
       
       setTitle( "Probability Calculator" ); // set title bar string
       setSize( 350, 180 );          // set window size
       setVisible( true );           // display window
    
}
     
  
  }

