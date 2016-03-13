/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stats_calculator;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Date;
import javax.swing.*;
import java.util.*;


/**
 *
 * @author rasellers0
 */
public class Stats_calculator extends JFrame
{
    JLabel header;
    static JLabel results;
    JLabel SampOrPopLabel;
    
    
    public JTextField _1;
    public JTextField _2;
    public JTextField _3;
    public JTextField _4;
    public JTextField _5;
    public JTextField _6;
    public JTextField _7;
    public JTextField _8;
    public JTextField _9;
    public JTextField _10;
    
     JTextField TextFieldArray[];
    
    
     JButton meanButton;
     JButton combinationButton;
     JButton permutationButton;
     JButton probabilityButton;
     JButton varianceButton;
     JButton covarianceButton;
     JButton std_devButton;
     JButton z_scoreButton;
     JButton p_valueButton;
    
    double J;
    Double N;
    Double mean = 0.0;
    
    JButton SampOrPop;
    
    JPanel resultsJPanel;
    
    Double[] numbers;
    
    boolean SampOrPop_ButtonState = false;
    
    //more stuff-- add a "sample/population button, look into poisson and gaussian distribution and linear regression
    
   public Stats_calculator() 
   {
       createUserInterface();
   }
   
   public void createUserInterface()
   {
       Container contentPane = getContentPane();
      
      // enable explicit positioning of GUI component
       contentPane.setLayout( null );
       
       //start building gui components here
  
      _1 = new JTextField();
      _1.setBounds( 50, 20, 40, 25 );
      contentPane.add(_1);
       
      _2 = new JTextField();
      _2.setBounds( 100, 20, 40, 25 );
      contentPane.add(_2);      
      
      _3 = new JTextField();
      _3.setBounds( 150, 20, 40, 25 );
      contentPane.add(_3); 
      
      _4 = new JTextField();
      _4.setBounds( 200, 20, 40, 25 );
      contentPane.add(_4);      
      
      _5 = new JTextField();
      _5.setBounds( 250, 20, 40, 25 );
      contentPane.add(_5);     
      
      _6 = new JTextField();
      _6.setBounds( 50, 70, 40, 25 );
      contentPane.add(_6);
       
      _7 = new JTextField();
      _7.setBounds( 100, 70, 40, 25 );
      contentPane.add(_7);      
      
      _8 = new JTextField();
      _8.setBounds( 150, 70, 40, 25 );
      contentPane.add(_8); 
      
      _9 = new JTextField();
      _9.setBounds( 200, 70, 40, 25 );
      contentPane.add(_9);      
      
      _10 = new JTextField();
      _10.setBounds( 250, 70, 40, 25 );
      contentPane.add(_10);
   
      resultsJPanel = new JPanel();
      resultsJPanel.setLayout(null);
      resultsJPanel.setBounds(10, 240, 330, 200);
      resultsJPanel.setBackground(Color.WHITE);
      resultsJPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      contentPane.add(resultsJPanel);
      
      header = new JLabel("The Answer Is:"+ "\n");
      header.setBounds(10,10, 100, 25);
      resultsJPanel.add(header);
      
      SampOrPopLabel = new JLabel();
      SampOrPopLabel.setBounds(250,10,80,25);
      resultsJPanel.add(SampOrPopLabel);
      
      results = new JLabel();
      results.setBounds(50, 10, 200, 100);
      resultsJPanel.add(results);
       
      SampOrPop = new JButton();
      SampOrPop.setBounds(65,120,210,24);
      SampOrPop.setText("Sample/Population");
      contentPane.add(SampOrPop);
      SampOrPop.addActionListener(
              
          new ActionListener()
          {
              public void actionPerformed(ActionEvent event1)
              {
                  SampOrPopActionPerformed( event1 );
              }
          }
              );
      
            // set up meanButton
      meanButton = new JButton();
      meanButton.setBounds( 40, 150, 70, 24 );
      meanButton.setText( "Mean");
      contentPane.add( meanButton );
      meanButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when meanButton is clicked
            public void actionPerformed( ActionEvent event2 )
            {
               meanButtonActionPerformed( event2 );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      combinationButton = new JButton();
      combinationButton.setBounds( 105, 150, 70, 24 );
      combinationButton.setText( "Combi");
      contentPane.add( combinationButton );
      combinationButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
         public void actionPerformed(ActionEvent e){
            combinationWindow gui = new combinationWindow(Stats_calculator.this);
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setTitle("Combination Calculator");
         }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      permutationButton = new JButton();
      permutationButton.setBounds( 170, 150, 70, 24 );
      permutationButton.setText( "Per");
      contentPane.add( permutationButton );
      permutationButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
         public void actionPerformed(ActionEvent ev){
            PermutationWindow gui = new PermutationWindow(Stats_calculator.this);
            gui.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            gui.setTitle("Permutation Calculator");
      }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      probabilityButton = new JButton();
      probabilityButton.setBounds( 235, 150, 70, 24 );
      probabilityButton.setText( "Prob");
      contentPane.add( probabilityButton );
      probabilityButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when meanButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               probabilityButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      varianceButton = new JButton();
      varianceButton.setBounds( 40, 180, 70, 24 );
      varianceButton.setText( "Var");
      contentPane.add( varianceButton );
      varianceButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when meanButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               varianceButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      covarianceButton = new JButton();
      covarianceButton.setBounds( 105, 180, 70, 24 );
      covarianceButton.setText( "Covar");
      contentPane.add( covarianceButton );
      covarianceButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when meanButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               covarianceButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      std_devButton = new JButton();
      std_devButton.setBounds( 170, 180, 70, 24 );
      std_devButton.setText( "S. Dev");
      contentPane.add( std_devButton );
      std_devButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when meanButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               std_devButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      z_scoreButton = new JButton();
      z_scoreButton.setBounds( 235, 180, 70, 24 );
      z_scoreButton.setText( "Z Score");
      contentPane.add( z_scoreButton );
      z_scoreButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when meanButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               z_scoreButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
      
      p_valueButton = new JButton();
      p_valueButton.setBounds( 137, 210, 70, 24 );
      p_valueButton.setText( "P Val");
      contentPane.add( p_valueButton );
      p_valueButton.addActionListener(

         new ActionListener() // anonymous inner class
         {
            // event handler called when meanButton is clicked
            public void actionPerformed( ActionEvent event )
            {
               p_valueButtonActionPerformed( event );
            }

         } // end anonymous inner class

      ); // end call to addActionListener
         
      contentPane.add(_10);           
       setTitle( "Stats Calculator" ); // set title bar string
       setSize( 350, 470 );          // set window size
       setVisible( true );           // display window
   }
    //declare methods and such:
    
   public void SampOrPopActionPerformed(ActionEvent event)
   {
       try{
       //false = sample, true = population
       if (SampOrPop_ButtonState == false)
       {
           SampOrPop_ButtonState = true;
           SampOrPopLabel.setText("(Population)");
           //TODO: I'd like it to say sample or population of whatever the formula is,
           //ie, sample mean or whatever. I think to do this i need to create an array of
           //the names of the formulas, then look up that name. 
       }
       else if(SampOrPop_ButtonState == true)
       {    
           SampOrPopLabel.setText("(Sample)");
           SampOrPop_ButtonState = false;
       }
   
   }
   catch(Exception ex)
   {
       
   }
   }
   public void meanButtonActionPerformed(ActionEvent event2)
   {
       //Double currentVal = 0.0;
       //Double sum = 0.0;
       

       if (SampOrPop_ButtonState == false)
       {
           numbers = new Double[10];
           getMean(numbers);
           results.setText(String.valueOf(mean));
       }
       else
       {
           numbers = new Double[10];
           getMean(numbers);
           results.setText(String.valueOf(mean));

       }   
       }
   
   
  public void combinationButtonActionPerformed(ActionEvent event3)
  {
      
      
      if (SampOrPop_ButtonState = false)
       {
           
       }
       else
       {
           //TODO: population combination
       }
  }
  
  public void permutationButtonActionPerformed(ActionEvent event4)
  {
      if (SampOrPop_ButtonState = false)
       {
           //TODO: sample permutation
       }
       else
       {
           //TODO: population permutation
       }
  }
  
  public void probabilityButtonActionPerformed(ActionEvent event)
  {
      if (SampOrPop_ButtonState = false)
       {
           //TODO: sample probability
       }
       else
       {
           //TODO: population probability
       }
  }
  
  public void varianceButtonActionPerformed(ActionEvent event)
  {
      if (SampOrPop_ButtonState = false)
       {
           //TODO: sample variance
       }
       else
       {
           //TODO: population variance
       }
  }
  
  public void covarianceButtonActionPerformed(ActionEvent event)
  {
      if (SampOrPop_ButtonState = false)
       {
           //TODO: sample covariance
       }
       else
       {
           //TODO: population covariance
       }
  }
  
  public void std_devButtonActionPerformed(ActionEvent event)
  {
      if (SampOrPop_ButtonState = false)
       {
           //TODO: sample std_dev
       }
       else
       {
           //TODO: population std_dev
       }
  }
  
  public void z_scoreButtonActionPerformed(ActionEvent event)
  {
      if (SampOrPop_ButtonState = false)
       {
           //TODO: sample z_score
       }
       else
       {
           //TODO: population z_score
       }
  }
  
  public void p_valueButtonActionPerformed(ActionEvent event)
  {
      if (SampOrPop_ButtonState = false)
       {
           //TODO: sample p_value
       }
       else
       {
           //TODO: population p_value
       }
  }
  
  public Double[] fillArray(Double[] array)
  { 
        TextFieldArray = new JTextField[10]; 
        TextFieldArray[0] = _1;
        TextFieldArray[1] = _2;
        TextFieldArray[2] = _3;
        TextFieldArray[3] = _4;
        TextFieldArray[4] = _5;
        TextFieldArray[5] = _6;
        TextFieldArray[6] = _7;
        TextFieldArray[7] = _8;
        TextFieldArray[8] = _9;
        TextFieldArray[9] = _10;
      


   for(int j = 0; j < TextFieldArray.length; j++)
   {
       numbers[j] = Double.parseDouble(TextFieldArray[j].getText());
    
   }

   return numbers;
  }
  
  public double getMean(Double[] input)
  {
      Double currentVal = 0.0;
      Double sum = 0.0;
      if (SampOrPop_ButtonState == false)
      {
          //input = new Double[10];
          fillArray(input);
          for(int n = 0; n <input.length; n++)
          {
              sum = currentVal + input[n];
              currentVal = sum;
          } 
          mean = (sum/input.length);

       }
       return mean;
  }
  //TODO: Fix Factorial function!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
      public static long factorial(JTextField input)
      {
          int input_int= Integer.parseInt(input.getText());
          int input_after = input_int - 1;
          long factorial = (long)(input_int * input_after);
          if(input_int== 0)
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

    public static void main( String args[] ) 
   {
      Stats_calculator application = new Stats_calculator();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.setTitle("Stats Calculator");
      //application.setVisible(true);

   } // end method main
}
