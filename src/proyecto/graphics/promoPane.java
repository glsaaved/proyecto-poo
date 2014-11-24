package proyecto.graphics;

import static javax.swing.GroupLayout.Alignment.CENTER;

import java.awt.Container;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileSystemView;

import proyecto.AdapterDefaultList;
import proyecto.AdapterDefaultListComponentes;
import proyecto.Cadena;
import proyecto.Lista;
import proyecto.ListaComponentes;
import proyecto.Local;
import proyecto.Principal;
import proyecto.ProductoException;
import proyecto.loadFileException;
import proyecto.saveFileException;

public class promoPane extends JPanel {
	
	private AdapterDefaultListComponentes model;
    private JList list;
    private JButton remallbtn;
    private JButton addbtn;
    private JButton renbtn;
    private JButton delbtn;
    private JButton chgbtn;
	/**
	 * Create the panel.
	 */
	public promoPane(ListaComponentes c)  {
		if(c!=null)
    	{
			model=new AdapterDefaultListComponentes();
    		for(int i=0;i<c.size();i++)
    		{
    			Object o=c.search(i);
    			if(o!=null)
    				model.add(o);
    		}
            initUI(c);
    	}
		model=new AdapterDefaultListComponentes();

	}
	private void initUI(Lista c) {
        createList();
        createButtons();
        JScrollPane scrollpane = new JScrollPane(list);
        GroupLayout gl = new GroupLayout(this);
        this.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(scrollpane)
                /**.addGroup(gl.createParallelGroup()
                        .addComponent(addbtn)
                        .addComponent(chgbtn)
                        .addComponent(renbtn)
                        .addComponent(delbtn)
                        .addComponent(remallbtn))**/
        );

        gl.setVerticalGroup(gl.createParallelGroup(CENTER)
                .addComponent(scrollpane)
                /**.addGroup(gl.createSequentialGroup()
                        .addComponent(addbtn)
                        .addComponent(chgbtn)
                        .addComponent(renbtn)
                        .addComponent(delbtn)
                        .addComponent(remallbtn))**/
        );

        //gl.linkSize(addbtn, chgbtn ,renbtn, delbtn, remallbtn);

        setSize(800, 600);
        setName("Promociones");
    }
	private void createList() {

        list = new JList(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addMouseListener(new MouseAdapter() {

           /** @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    Object item = model.getElementAt(index);
                    String text = JOptionPane.showInputDialog("Cambiar Direccion", ((Local)item).getDireccion());
                    int id=((Local)item).getId();
                    String newitem = null;
                    if (text != null) {
                        newitem = text.trim();
                    } else {
                        return;
                    }

                    if (!newitem.isEmpty()) {
                        model.remove(index);
                        model.add(index, newitem);
                        ListSelectionModel selmodel = list.getSelectionModel();
                        selmodel.setLeadSelectionIndex(index);
                    }
                }
            }**/
        });
    }
	  private void createButtons() {

	        remallbtn = new JButton("Eliminar Todo");
	        addbtn = new JButton("Añadir");
	        chgbtn = new JButton("Cargar");
	        renbtn = new JButton("Modificar");
	        delbtn = new JButton("Eliminar");

	        addbtn.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {

	                String text = JOptionPane.showInputDialog("Añadir Nuevo Local");
	                String item = null;

	                if (text != null) {
	                    item = text.trim();
	                } else {
	                    return;
	                }

	                if (!item.isEmpty()) {
	                    try {
							model.addElement(item);
						} catch (ProductoException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	                }
	            }
	        });
	        chgbtn.addActionListener(new ActionListener() {

				@Override
	    			public void actionPerformed(ActionEvent arg0) {
	    				// TODO Auto-generated method stub
						File startFile=new File(System.getProperty("user.dir"));
	    				  JFileChooser openFile = new JFileChooser();
	    				  try
	    				  {
	    					  openFile.setCurrentDirectory(startFile);
	    				  }
	    				  catch(Exception e)
	    				  {
	    					  JOptionPane optionPane = new JOptionPane("Problema con el directorio con el que estaba trabajando", JOptionPane.ERROR_MESSAGE);   
	    					  JDialog dialog = optionPane.createDialog("Error");
	    					  dialog.setAlwaysOnTop(true);
	    					  dialog.setVisible(true);
	    					  while (!FileSystemView.getFileSystemView().isFileSystemRoot(startFile))
	  			            {
	  			                startFile = startFile.getParentFile();
	  			            }
	    				  }
	    				  finally{
	    				  if (openFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	    					  File file = openFile.getSelectedFile();
	    					  System.out.println(openFile.getSelectedFile().getName());
	    					  try {
								model.loadFile(file);
								}
	    					  	catch (loadFileException e) {
									JOptionPane optionPane = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);   
			    					  JDialog dialog = optionPane.createDialog("Error");
			    					  dialog.setAlwaysOnTop(true);
			    					  dialog.setVisible(true);
								}
	    					  catch(IOException e)
	    					  {
	    						  JOptionPane optionPane = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);   
		    					  JDialog dialog = optionPane.createDialog("Error");
		    					  dialog.setAlwaysOnTop(true);
		    					  dialog.setVisible(true);
	    					  }
	    					  }
	    				  }
	    			}
	        });

	        delbtn.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent event) {
	            	
	            	int result = JOptionPane.showConfirmDialog(null, 
	            			   "¿Estas seguro de eliminarlo?",null, JOptionPane.YES_NO_OPTION);
	            			if(result == JOptionPane.YES_OPTION) {
	                ListSelectionModel selmodel = list.getSelectionModel();
	                int index = selmodel.getMinSelectionIndex();
	                if (index >= 0) {
	                    model.remove(index);
	                }
	            }
	            }

	        });

	        renbtn.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent e) {

	                ListSelectionModel selmodel = list.getSelectionModel();
	                int index = selmodel.getMinSelectionIndex();
	                if (index == -1) {
	                    return;
	                }

	                Object item = model.getElementAt(index);
	                String text = JOptionPane.showInputDialog("Cambiar Direccion", ((Local)item).getDireccion());
	                int id=((Local)item).getId();
	                String newitem = null;
	                if (text != null) {
	                    newitem = text.trim();
	                } else {
	                    return;
	                }

	                if (!newitem.isEmpty()) {
	                    model.remove(index);
	                    model.add(index, newitem);
	                    selmodel.setLeadSelectionIndex(index);
	                }
	            }
	        });

	        remallbtn.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                
	            	int result = JOptionPane.showConfirmDialog(null, 
	            			   "¿Estas seguro de quitar todos los locales?",null, JOptionPane.YES_NO_OPTION);
	            			if(result == JOptionPane.YES_OPTION) {model.clear();
	            }
	            }
	        });

	    }

}
