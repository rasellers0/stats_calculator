package stats_calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author rasellers0
 */
public class PermutationWindow extends JDialog {
    JTextField Possibilities;
    JTextField Selection;
    
    public PermutationWindow(JFrame frame){
        super(frame, "Permutation Calculator", true);
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
       
       setTitle( "Permutation Calculator" ); // set title bar string
       setSize( 350, 180 );          // set window size
       setVisible( true );           // display window
    
}
     
  public void cancelButtonActionPerformed(ActionEvent eventa)
   { 
       dispose();
   }

  public void calculateButtonActionPerformed(ActionEvent eventb) 
  {
      //formula for combination is n(total number of items) factorial divided by
      //the sum of n minus k(number of selections) factorial: n!/(n-k)!
      //for example, the total number of permutations of ten items taken three
      //at a time is 720
      try{
      int k = Integer.parseInt(Selection.getText());
      int n = Integer.parseInt(Possibilities.getText());
      
      long n_fac = Stats_calculator.factorial(Selection);
      long k_fac = Stats_calculator.factorial(Possibilities);
      long n_minus_k = factorial(Possibilities, Selection);
      
      long permutation = k_fac /n_minus_k;
      String perm_string = String.valueOf(permutation);
      Stats_calculator.results.setText(perm_string);
      dispose();
      }
      catch(Exception ex)
      {
          JOptionPane.showMessageDialog(null, "Shit's Fucked, Yo!");
         dispose();
      }
  }
  
  public static long factorial(JTextField input1, JTextField input2)
  {
      int input1_int = Integer.parseInt(input1.getText());
      int input2_int = Integer.parseInt(input2.getText());
      int input_start = (input1_int - input2_int);
      int input_after = input_start - 1;
      long factorial = input_start * input_after;
      
      if(input1_int == 0 || input2_int == 0)
      {
          throw new NumberFormatException("Please enter a value above zero");
      }
      
      for( int x = input_after; x > 1; x--)
      {
          input_after = input_after - 1;
          factorial = factorial * input_after;
      }
      return factorial;
      }

  
}
