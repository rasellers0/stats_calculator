package stats_calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author rasellers0
 */
public class combinationWindow extends JDialog {
    JTextField Possibilities;
    JTextField Selection;
    
    public combinationWindow(JFrame frame){
        super(frame, "Combination Calculator", true);
        setLayout(new FlowLayout());
        createUserInterface();
        
    }
    
     public void createUserInterface()
   {
       Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI component
       contentPane.setLayout( null );
       
       //start building gui components here
       JLabel SelectLabel = new JLabel("Selection");
       SelectLabel.setBounds(20, 40, 57, 45);
       SelectLabel.setFont(new Font("Sans Serif", Font.PLAIN, 10));
       contentPane.add(SelectLabel);
       
       Selection = new JTextField();
       Selection.setBounds(15,30, 57, 15);
       Selection.setSize(57, 20);
       contentPane.add(Selection);
       
       JLabel OutOf = new JLabel("Out Of");
       OutOf.setBounds(87,35, 55, 15);
       contentPane.add(OutOf);
       
       JLabel PossLabel = new JLabel("Possibilities");
       PossLabel.setBounds(150, 40, 65, 45);
       PossLabel.setFont(new Font("Sans Serif", Font.PLAIN, 10));
       contentPane.add(PossLabel);
       
       Possibilities = new JTextField();
       Possibilities.setBounds(150, 30, 57, 15);
       Possibilities.setSize(57,20);
       contentPane.add(Possibilities);
       
       JButton cancelButton = new JButton();
       cancelButton.setText("Cancel");
       cancelButton.setBounds(150, 120, 80, 25);
       contentPane.add(cancelButton);
       cancelButton.addActionListener(
              
          new ActionListener()
          {
              public void actionPerformed(ActionEvent eventa)
              {
                  cancelButtonActionPerformed( eventa );
              }
          }
              );
       
       
       JButton calculateButton = new JButton();
       calculateButton.setText("Calculate");
       calculateButton.setBounds(240, 120, 95, 25);
       contentPane.add(calculateButton);
       calculateButton.addActionListener(
               
            new ActionListener()
            {
                public void actionPerformed(ActionEvent eventb)
                {
                    calculateButtonActionPerformed(eventb);
                }
            }
               );
       
       setTitle( "Combination Calculator" ); // set title bar string
       setSize( 350, 180 );          // set window size
       setVisible( true );           // display window
    
}
     
  public void cancelButtonActionPerformed(ActionEvent eventa)
   { 
       dispose();
   }

  public void calculateButtonActionPerformed(ActionEvent eventb) 
  {
      //formula for combination is n(total number of items) factorial
      //over ( r(number of items to be selected) factorial times (n-r) factorial
      //so for example, if you were asked to find how many groups of 4 can be chosen
      //from fifteen, it would go 15!/4(15-4)!
      try{
      int n = Integer.parseInt(Possibilities.getText());
      int r = Integer.parseInt(Selection.getText());
      
      int n_fac = Stats_calculator.factorial(Possibilities);
      int r_fac = Stats_calculator.factorial(Selection);
      int n_minus_r = (n - r);
      
      int combination = n_fac / r_fac * n_minus_r;
      
      Stats_calculator.results.setText(String.valueOf(combination));
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "Shit's Fucked, Yo!");
         dispose();
      }
  }
}
