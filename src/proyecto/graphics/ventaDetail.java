package proyecto.graphics;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

import proyecto.Local;
import proyecto.Componente;
import proyecto.ProductoException;

public class ventaDetail extends JPanel {
	private JLabel label;
	private Componente c;
	
	/**
	 * Create the panel.
	 */
	public ventaDetail(Local l) {
		try
		{
			
		
		JComboBox comboBox = new JComboBox();
		if(l!=null)
		{
			for(int i=0;i<l.sizeComponentes();i++)
			{
				Object o=l.searchComponente(i);
				if(o!=null)
					comboBox.addItem(o);
			}
		}
		add(comboBox);
		String s=" $ "+((Componente)(comboBox.getSelectedItem())).getTotal()+"";
		label = new JLabel(s);
		label.setFont(label.getFont().deriveFont(24.0f));
		c=((Componente)(comboBox.getSelectedItem()));
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=" $ "+((Componente)(comboBox.getSelectedItem())).getTotal()+"";
				label.setText(s);
				c=((Componente)(comboBox.getSelectedItem()));
			}
		});
		this.add(label);
		}
		catch(Exception e)
		{
			JOptionPane optionPane = new JOptionPane("Error de Lectura, Local sin productos ni promociones", JOptionPane.ERROR_MESSAGE);   
			  JDialog dialog = optionPane.createDialog("Error");
			  dialog.setAlwaysOnTop(true);
			  dialog.setVisible(true);
		}
	}
	public Componente getComponente()
	{
		return c;
	}

	

}
