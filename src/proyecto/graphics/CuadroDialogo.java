package proyecto.graphics;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import proyecto.*;
 
public class CuadroDialogo
{
  static JFrame frame;
 
  public static void displayJFrame()
  {
    frame = new JFrame("Fast Food Delivery");
    
    JLabel userLabel = new JLabel("Cadena");
	userLabel.setBounds(10, 10, 80, 25);
	frame.add(userLabel);
	
	JTextField userText = new JTextField(20);
	userText.setBounds(100, 10, 160, 25);
	frame.add(userText);
    // create our jbutton, then tell it what to do when
    // it is pressed
    JButton showDialogButton = new JButton("Aceptar");
    JButton closeButton = new JButton("Cancelar");

 
    // put the button on the frame
    frame.getContentPane().setLayout(new FlowLayout());
    frame.add(showDialogButton);
    frame.add(closeButton);
 
    // set up the jframe, then display it
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(300, 100));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    showDialogButton.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        // display/center the jdialog when the button is pressed
    	  Cadena c=null;
		c = new Cadena(userText.getText());
		if(c!=null)
			try {
				frame.setVisible(false);
				c.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	 // c.show(frame);
      }
    });
    closeButton.addActionListener(new ActionListener ()
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		System.exit(0);
    	}
    });
  }
}
