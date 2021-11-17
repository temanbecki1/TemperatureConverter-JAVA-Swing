import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
*   Filename: GUI.java
*   Author : Teman Beck
*   Date : November 16th, 2021
*   This class defines our GUI for our main program functionality.
*   This class contains our main run method.
*/

public class GUI {

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {                             //This allows our GUI to run in its own thread
            public void run(){
                JFrame frame = new MainFrame("Discussion Week 4 GUI");   //creates a new JFrame 

        frame.setSize(425, 150);                                                //sets GUI pixel size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                   //allows program to close when we hit the x button to exit
        frame.setVisible(true);                                                 //sets GUI to be visible

            }
        });

    }

}