package proyecto.graphics;

import static javax.swing.GroupLayout.Alignment.CENTER;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

import proyecto.AdapterDefaultList;
import proyecto.AdapterDefaultListComponentes;
import proyecto.Cadena;
import proyecto.Componente;
import proyecto.Lista;
import proyecto.ListaComponentes;
import proyecto.ListaVentas;
import proyecto.Local;
import proyecto.Principal;
import proyecto.ProductoException;
import proyecto.Venta;
import proyecto.loadFileException;
import proyecto.saveFileException;

public class localPane extends JPanel {
	
	private Local local;
	private AdapterDefaultListComponentes componentes;
	private ListaVentas ventas;
	private Venta ventaActual;
	private JDialog dialog;
	private ventaDetail pane; 
    private JButton remallbtn;
    private JButton addbtn;
    private JButton renbtn;
    private JButton delbtn;
    private JButton chgbtn;
    private JButton aceptar;
	private JButton cancelar;
	/**
	 * Create the panel.
	 */
	public localPane(Local l,ListaComponentes comp)  {
		
		if(l!=null)
    	{
			local=l;
			componentes=new AdapterDefaultListComponentes();
			if(comp!=null)
			{
				for(int i=0;i<comp.size();i++)
				{
					Componente c=(Componente)comp.search(i);
					l.addComponente(c);
					componentes.add(c);
				}
			}
			ventas=new ListaVentas();
			ventaActual=null;
            initUI();
    	}
		else
		{
			JOptionPane optionPane = new JOptionPane("Error Local nulo", JOptionPane.ERROR_MESSAGE);   
			  JDialog dialog = optionPane.createDialog("Error");
			  dialog.setAlwaysOnTop(true);
			  dialog.setVisible(true);
		}
		componentes=new AdapterDefaultListComponentes();

	}
	private void initUI()  {
        createButtons();
        GroupLayout gl = new GroupLayout(this);
        this.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup()
                        .addComponent(addbtn)
                        //.addComponent(chgbtn)
                        //
                        .addComponent(delbtn)
                        .addComponent(remallbtn))
                        .addComponent(renbtn)
        );

        gl.setVerticalGroup(gl.createParallelGroup(CENTER)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(addbtn)
                        //.addComponent(chgbtn)
                        //.addComponent(renbtn)
                        .addComponent(delbtn)
                        .addComponent(remallbtn))
                        .addComponent(renbtn)
        );

        gl.linkSize(addbtn, delbtn, remallbtn,renbtn);
        setName("Locales");
    }
	  private void createButtons()  {
		  
	        try
	        {
	        	BufferedImage buttonIcon = ImageIO.read(new File("menu21.png"));
	        	addbtn = new JButton(new ImageIcon(buttonIcon));
	        	addbtn.setBorder(BorderFactory.createEmptyBorder());
	        	addbtn.setContentAreaFilled(false);
	        }
	        catch(IOException e)
	        {
	        	e.printStackTrace();
	        	addbtn= new JButton("Realizar Venta");
	        }
	        try
	        {
	        	BufferedImage buttonIcon = ImageIO.read(new File("fastfood.png"));
	        	chgbtn = new JButton(new ImageIcon(buttonIcon));
	        	chgbtn.setBorder(BorderFactory.createEmptyBorder());
	        	chgbtn.setContentAreaFilled(false);
	        }
	        catch(IOException e)
	        {
	        	e.printStackTrace();
	        	chgbtn= new JButton("Cargar");
	        }
	        try
	        {
	        	BufferedImage buttonIcon = ImageIO.read(new File("shopping86.png"));
	        	renbtn = new JButton(new ImageIcon(buttonIcon));
	        	renbtn.setBorder(BorderFactory.createEmptyBorder());
	        	renbtn.setContentAreaFilled(false);
	        }
	        catch(IOException e)
	        {
	        	e.printStackTrace();
	        	renbtn= new JButton("cancelar venta");
	        }
	        try
	        {
	        	BufferedImage buttonIcon = ImageIO.read(new File("full22.png"));
	        	delbtn = new JButton(new ImageIcon(buttonIcon));
	        	delbtn.setBorder(BorderFactory.createEmptyBorder());
	        	delbtn.setContentAreaFilled(false);
	        }
	        catch(IOException e)
	        {
	        	e.printStackTrace();
	        	delbtn= new JButton("Venta total detalle");
	        }
	        try
	        {
	        	BufferedImage buttonIcon = ImageIO.read(new File("invoice1.png"));
	        	remallbtn = new JButton(new ImageIcon(buttonIcon));
	        	remallbtn.setBorder(BorderFactory.createEmptyBorder());
	        	remallbtn.setContentAreaFilled(false);
	        }
	        catch(IOException e)
	        {
	        	e.printStackTrace();
	        	remallbtn= new JButton("boleta");
	        }
	        aceptar=new JButton("Aceptar");
	        cancelar=new JButton("Cancelar");
	        

	        addbtn.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
                    Window parentWindow = SwingUtilities.windowForComponent(addbtn);
                    dialog = new JDialog(parentWindow);

                    dialog.setModal(true);
                    dialog.setIconImage(CuadroDialogo.img.getImage());
                    pane = new ventaDetail(local);

                    pane.add(aceptar);
                    pane.add(cancelar);
                    dialog.add(pane);
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    if(local.sizeComponentes()==0)
                    	dialog.setVisible(false);
                    else
                    	dialog.setVisible(true);
	            	
	            }
	        });
	        chgbtn.addActionListener(new ActionListener() {

				@Override
	    			public void actionPerformed(ActionEvent arg0) {
	    				// TODO Auto-generated method stub
						
	    			}
	        });

	        delbtn.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	
                    Window parentWindow = SwingUtilities.windowForComponent(addbtn);
                    dialog = new JDialog(parentWindow);
                    String s="";
                    if(ventaActual!=null)
                    {
                    	s+=ventaActual.printVendidos();
                    	s+="\n============\n";
                    	s+="Total  :  "+ventaActual.getTotal();
                    	JTextArea label=new JTextArea();
                    	label.setText(s);
                    	textAreaProperties(label);
                        dialog.add(label);
                        dialog.setBackground(Color.BLACK);
                    }
                    else
                    {
                    	JLabel label=new JLabel("No se han añadido productos a la venta");
                        dialog.add(label);
                    }
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    dialog.setSize(400,400);
                    dialog.setVisible(true);
	            }

	        });

	        renbtn.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	ventaActual=null;
                    JOptionPane optionPane = new JOptionPane("Venta Anulada", JOptionPane.INFORMATION_MESSAGE);   
	      			  JDialog dialog = optionPane.createDialog("Exitoso");
	      			  dialog.setAlwaysOnTop(true);
	      			  dialog.setVisible(true);
	            }
	        });

	        remallbtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if(ventaActual!=null)
	            	{String s="";
	        		s+=ventaActual.getFecha().getFecha_long()+"                                             \n";
	        		s+="Local: "+local.getDireccion()+"\n";
	        		
	        		s+="             "+"Productos                         "+"Valor                +\n";
	        		s+=ventaActual.printVendidos();
	        		s+="_________________________________________________\n";
	        		s+="             "+"Total                            "+ventaActual.getTotal()+"\n\n\n";
	        		s+="                         Gracias por su preferencia                    \n";
	        		int id=Principal.randInt(10000, 2000000);
	                try {
	                    File file = new File("boleta "+id+".txt");
	                    BufferedWriter output = new BufferedWriter(new FileWriter(file));
	                    output.write(s);
	                    output.close();
	                    JOptionPane optionPane = new JOptionPane("Se ha guardado la boleta", JOptionPane.INFORMATION_MESSAGE);   
		      			  JDialog dialog = optionPane.createDialog("Exitoso");
		      			  dialog.setAlwaysOnTop(true);
		      			  dialog.setVisible(true);
		      			 local.addVenta(ventaActual);
		      			 ventaActual=null;
	                  } catch ( IOException e1) {
	              		System.out.println("No se pudo guardar, reintente");
	        			JOptionPane optionPane = new JOptionPane("Error con archivo de destino", JOptionPane.ERROR_MESSAGE);   
		      			  JDialog dialog = optionPane.createDialog("Error");
		      			  dialog.setAlwaysOnTop(true);
		      			  dialog.setVisible(true);
	                  }
	            	}
	            	else
	            	{
	        			JOptionPane optionPane = new JOptionPane("No hay elementos en venta", JOptionPane.ERROR_MESSAGE);   
		      			  JDialog dialog = optionPane.createDialog("Error");
		      			  dialog.setAlwaysOnTop(true);
		      			  dialog.setVisible(true);
	            	}

	            
	            }
	        });
	        aceptar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if(pane!=null&&pane.getComponente()!=null)
	            		{
	            			if (ventaActual==null)
	            				ventaActual=new Venta();
	            			ventaActual.add(pane.getComponente());
	            			System.out.println("Total: "+ventaActual.getTotal());
	            		}
	            	dialog.dispose();
	            
	            }
	        });
	        cancelar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	dialog.dispose();
	            
	            }
	        });

	    }
	    public static JLabel newLabel(String label) {
	        JLabel l = new JLabel(label);
	        l.setFont(l.getFont().deriveFont(24.0f));
	        return l;
	    }
	    private JTextArea textAreaProperties(JTextArea textArea) {
	        textArea.setEditable(false);  
	        textArea.setCursor(null);  
	        textArea.setOpaque(false);  
	        textArea.setFocusable(false);
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        Font font = new Font("Verdana", Font.BOLD, 20);
	        textArea.setFont(font);
	        textArea.setForeground(Color.BLACK);
	        textArea.setBackground(Color.BLACK);
	        return textArea;
	    }


}
