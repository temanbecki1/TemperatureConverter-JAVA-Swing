import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


/*
*   Filename: MainFrame.java
*   Author : Teman Beck
*   Date : November 16th, 2021
*   This class extends GUI.java and creates all Swing components. This class also acts as the controller or driver class as all events originate here
*/

public class MainFrame extends JFrame {
    final static boolean shouldFill = true;
    private String inputExpression;                                                                             //declare string variable to intake enterTempTxt field
    

    public MainFrame(String title){
        super(title);

        //set layout manager
        setLayout(new GridBagLayout());                                                                         //sets our layout to utilize GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();                                                      //creates our GridBagConstraints object

        //create Swing components
        JLabel enterTempLabel = new JLabel("Enter Temperature");                                                //creates our Enter Expression label
        JLabel resultFieldLabel = new JLabel("Result");                                                         //creates label for result text field

        JTextField enterTempTxt = new JTextField("");                                                           //creates our text field to enter our Expression
        JTextField resultFieldTxt = new JTextField("");                                                         //creates our result text field. This will not be editable by user

        JButton fahrenheitToCelsiusBtn = new JButton("Fahrenheit to Celsius");                                  //creates button to prompt conversion from prefix to postfix 
        JButton celsiusToFahrenheitBtn = new JButton("Celsius to Fahrenheit");                                  //create button to prompt conversion from postfix to prefix

        //Set the result field to uneditable.
        resultFieldTxt.setEditable(false);                                                                      //sets the result field to display result only
          
        //add Swing components to content pane
        //row one includes 1 label and 1 text field
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weighty = 0.35;                                                                                     //we give small spacing between our rows on the y axis 
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(enterTempLabel, gbc);                                                                          //adds the enterTempLabel Label to the GridBagConstraints object gbc

        gbc.gridx = 1;
        gbc.gridy = 0;
        //gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(enterTempTxt, gbc);                                                                            //adds the enterTempTxt field to the GridBagConstraints object



        //row two includes two buttons
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(0,7,0,0);                                                                       //middle padding padding
        this.add(fahrenheitToCelsiusBtn, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth =1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        this.add(celsiusToFahrenheitBtn, gbc);

        //row three includes one label and one text field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        this.add(resultFieldLabel, gbc);


        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(resultFieldTxt, gbc);


        fahrenheitToCelsiusBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //Takes input field expression and converts it to postfix   
                setInputExpression(enterTempTxt.getText());                                                 //calls the setInputExpressionTxt method button event
                
                Conversion conversion = new Conversion(inputExpression);
               
                String operands = conversion.getCelsius();                       
                resultFieldTxt.setText(operands);                                                           //sets JTextfield to operand string 

                // reset();

                

                
            }            
        });

        celsiusToFahrenheitBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setInputExpression(enterTempTxt.getText());

                Conversion conversion = new Conversion(inputExpression);
               
                String operands = conversion.getFahrenheit();                      
                resultFieldTxt.setText(operands);                                                           //sets JTextfield to operand string 

                // reset();


            }

        });        
    }

    public void setInputExpression(String newExpression){
        this.inputExpression = newExpression;                                                           //assigns inputExpression from passed in String 
    } 
}