package proyecto.graphics;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;

import static javax.swing.GroupLayout.Alignment.CENTER;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
import proyecto.Cadena;
import proyecto.Componente;
import proyecto.Lista;
import proyecto.ListaComponentes;
import proyecto.Local;
import proyecto.Principal;
import proyecto.Producto;
import proyecto.Promocion;
import proyecto.loadFileException;
import proyecto.saveFileException;

public class ListModels extends JFrame {

    private AdapterDefaultList model;
    private JList list;
    private JButton remallbtn;
    private JButton addbtn;
    private JButton renbtn;
    private JButton delbtn;
    private JButton chgbtn;

    public ListModels(Cadena c) throws defaultException {

    	if(c!=null)
    	{
        	if(c.sizeLocales()==0)
        	{
        		model=new AdapterDefaultList();
        		c.setLocales(model);
        	}
        	else
        	{
        		model=new AdapterDefaultList();
        		for(int i=0;i<c.sizeLocales();i++)
        		{
        			Object o=c.search(i);
        			if(o!=null)
        				model.add(o);
        		}
        		c.setLocales(model);
        	}
            initUI(c);
    	}
    	else
    		throw new defaultException();

    }

    private void createList(Cadena c) {

        list = new JList(model);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        list.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    int index = list.locationToIndex(e.getPoint());
                    Object item = model.getElementAt(index);
                    Window parentWindow = SwingUtilities.windowForComponent(list);
                    JDialog dialog = new JDialog(parentWindow);

                    dialog.setModal(true);
                    dialog.setIconImage(CuadroDialogo.img.getImage());
                    ListaComponentes l=getComponente(c,0);
                    localPane pane = new localPane((Local) item,l);
                    dialog.add(newPane("Local", pane));
                    dialog.pack();
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
            }
        });
    }

    private void createButtons(Cadena c) {

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
                    model.addElement(item);
                }
                c.listar();
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
		    					  dialog.setIconImage(CuadroDialogo.img.getImage());
							}
    					  catch(IOException e)
    					  {
    						  JOptionPane optionPane = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);   
	    					  JDialog dialog = optionPane.createDialog("Error");
	    					  dialog.setAlwaysOnTop(true);
	    					  dialog.setVisible(true);
	    					  dialog.setIconImage(CuadroDialogo.img.getImage());
    					  }
    					  }
    				  }
    				 c.listar();
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
                c.listar();
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
                    model.add(index, newitem,id);
                    selmodel.setLeadSelectionIndex(index);
                }
                c.listar();
            }
        });

        remallbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	int result = JOptionPane.showConfirmDialog(null, 
            			   "¿Estas seguro de quitar todos los locales?",null, JOptionPane.YES_NO_OPTION);
            			if(result == JOptionPane.YES_OPTION) {model.clear();
            			c.listar();
            }
            }
        });

    }

    private void initUI(Cadena c) {
    	 JMenuBar menubar = new JMenuBar();
         ImageIcon iconNew = new ImageIcon("new.png");
         ImageIcon iconOpen = new ImageIcon("open.png");
         ImageIcon iconSave = new ImageIcon("save.png");
         ImageIcon iconExit = new ImageIcon("exit.png");

         JMenu file = new JMenu("Archivo");
         file.setMnemonic(KeyEvent.VK_F);
         
         JMenu productosMenu = new JMenu("Productos");
         productosMenu.setMnemonic(KeyEvent.VK_P);
         
         JMenuItem productosNew = new JMenuItem("Guardar");
         JMenuItem productosDelete = new JMenuItem("Eliminar Todos");
         productosDelete.addActionListener(new ActionListener(){
        	 @Override
 			public void actionPerformed(ActionEvent arg0) {
 				
        		 int result = JOptionPane.showConfirmDialog(null, 
          			   "¿Estas seguro de eliminar todos los productos? Se eliminaran las promociones tambien",null, JOptionPane.YES_NO_OPTION);
          			if(result == JOptionPane.YES_OPTION) {
          			while(c.sizeComponentes()>0)
          			{
          				Componente comp=c.searchComponente((c.sizeComponentes()-1));
          				if(comp!=null)
          					c.deleteComponente(comp);
          			}
          		}
        	 }


         });
         JMenuItem productosChange = new JMenuItem("Ver Todas");
         productosChange.addActionListener(new ActionListener(){
        	 @Override
 			public void actionPerformed(ActionEvent arg0) {
 				
        		 System.out.println(c.productosCargados());
                 Window parentWindow = SwingUtilities.windowForComponent(productosChange);
                 JDialog dialog = new JDialog(parentWindow);
                 dialog.setLocationRelativeTo(productosChange);
                 dialog.setModal(true);
                 dialog.setIconImage(CuadroDialogo.img.getImage());
                 ListaComponentes l=getComponente(c,1);
                 prodPane pane = new prodPane(l);
                 dialog.add(newPane("Label in dialog", pane));
                 dialog.pack();
                 dialog.setVisible(true);
 			}


         });
         
         JMenu promocionesMenu = new JMenu("Promociones");
         promocionesMenu.setMnemonic(KeyEvent.VK_R);

         JMenuItem promocionesNew = new JMenuItem("Guardar");
         JMenuItem promocionesDelete = new JMenuItem("Eliminar Todos");
         promocionesDelete.addActionListener(new ActionListener(){
        	 @Override
  			public void actionPerformed(ActionEvent arg0) {
 				
       		 int result = JOptionPane.showConfirmDialog(null, 
         			   "¿Estas seguro de eliminar todas las promociones?",null, JOptionPane.YES_NO_OPTION);
         			if(result == JOptionPane.YES_OPTION) {
         			ListaComponentes l=getComponente(c,1);
         			while(c.sizeComponentes()!=l.size())
         			{
         				for(int i=0;i<c.sizeComponentes();i++)
         				{
         					Componente comp=c.searchComponente(i);
         					if(comp!=null&&comp.getChild())
         						c.deleteComponente(comp);
         				}
         			}
         			
         		}
       	 }


         });
         JMenuItem promocionesChange = new JMenuItem("Ver Todas");
         promocionesChange.addActionListener(new ActionListener(){
        	 @Override
 			public void actionPerformed(ActionEvent arg0) {
 				
        		 System.out.println(c.productosCargados());
                 Window parentWindow = SwingUtilities.windowForComponent(promocionesChange);
                 JDialog dialog = new JDialog(parentWindow);
                 dialog.setLocationRelativeTo(promocionesChange);
                 dialog.setModal(true);
                 dialog.setIconImage(CuadroDialogo.img.getImage());
                 ListaComponentes l=getComponente(c,2);
                 promoPane pane = new promoPane(l);
                 dialog.add(newPane("Label in dialog", pane));
                 dialog.pack();
                 dialog.setVisible(true);
 			}


         });
         
         JMenu imp = new JMenu("Importar");
         imp.setMnemonic(KeyEvent.VK_M);

         JMenuItem impProductos = new JMenuItem("Importar Productos globales");
         impProductos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                 ActionEvent.CTRL_MASK));
         impProductos.addActionListener(new ActionListener(){
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
 					  dialog.setIconImage(CuadroDialogo.img.getImage());
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
							c.loadProductos(file);
							}
 					  	catch (loadFileException e) {
								JOptionPane optionPane = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);   
		    					  JDialog dialog = optionPane.createDialog("Error");
		    					  dialog.setIconImage(CuadroDialogo.img.getImage());
		    					  dialog.setAlwaysOnTop(true);
		    					  dialog.setVisible(true);
							}
 					  catch(IOException e)
 					  {
 						  JOptionPane optionPane = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);   
	    					  JDialog dialog = optionPane.createDialog("Error");
	    					  dialog.setIconImage(CuadroDialogo.img.getImage());
	    					  dialog.setAlwaysOnTop(true);
	    					  dialog.setVisible(true);
 					  }
 					  }
 				  }
 			}
         });
         
         JMenuItem impPromociones = new JMenuItem("Importar Promociones globales");
         impPromociones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
                 ActionEvent.CTRL_MASK));
         impPromociones.addActionListener(new ActionListener(){
        	 @Override
 			public void actionPerformed(ActionEvent arg0) {
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
 					 dialog.setIconImage(CuadroDialogo.img.getImage());
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
							c.loadProductos(file);
							}
 					  	catch (loadFileException e) {
								JOptionPane optionPane = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);   
		    					  JDialog dialog = optionPane.createDialog("Error");
		    					  dialog.setIconImage(CuadroDialogo.img.getImage());
		    					  dialog.setAlwaysOnTop(true);
		    					  dialog.setVisible(true);
							}
 					  catch(IOException e)
 					  {
 						  JOptionPane optionPane = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);   
	    					  JDialog dialog = optionPane.createDialog("Error");
	    					  dialog.setIconImage(CuadroDialogo.img.getImage());
	    					  dialog.setAlwaysOnTop(true);
	    					  dialog.setVisible(true);
 					  }
 					  }
 				  }
 			}
         });

         imp.add(impProductos);
         imp.add(impPromociones);

         JMenuItem fileNew = new JMenuItem("Nueva Cadena", iconNew);
         fileNew.setMnemonic(KeyEvent.VK_N);
         fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                 ActionEvent.CTRL_MASK));
         fileNew.addActionListener(new ActionListener(){
        	 public void actionPerformed(ActionEvent arg0) {
        		Principal.main(null);
        		setVisible(true); 
        		dispose(); 
        	 }
         });
         JMenuItem fileOpen = new JMenuItem("Abrir Cadena", iconOpen);
         fileOpen.setMnemonic(KeyEvent.VK_O);
         fileOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                 ActionEvent.CTRL_MASK));
         fileOpen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
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

         JMenuItem fileSave = new JMenuItem("Guardar Cadena", iconSave);
         fileSave.setMnemonic(KeyEvent.VK_S);
         fileSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                 ActionEvent.CTRL_MASK));
         fileSave.addActionListener(new ActionListener(){

 			@Override
 			public void actionPerformed(ActionEvent arg0) {
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
				  if (openFile.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					  File file = openFile.getSelectedFile();
					  System.out.println(openFile.getSelectedFile().getName());
					  try {
							c.saveFile(file);
							}
					  	catch (saveFileException e) {
								JOptionPane optionPane = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);   
		    					  JDialog dialog = optionPane.createDialog("Error");
		    					  dialog.setAlwaysOnTop(true);
		    					  dialog.setVisible(true);
							} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					  }
				  }
 			}
          
          });

         JMenuItem fileExit = new JMenuItem("Salir", iconExit);
         fileExit.setMnemonic(KeyEvent.VK_C);
         fileExit.setToolTipText("Exit application");
         fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
             ActionEvent.CTRL_MASK));

         fileExit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent event) {
                 System.exit(0);
             }
         });

         file.add(fileNew);
         file.add(fileOpen);
         file.add(fileSave);
         file.addSeparator();
         file.add(imp);
         file.addSeparator();
         file.add(fileExit);
         
         //productosMenu.add(productosNew);
         productosMenu.add(productosDelete);
         productosMenu.add(productosChange);
         
         //promocionesMenu.add(promocionesNew);
         promocionesMenu.add(promocionesDelete);
         promocionesMenu.add(promocionesChange);
         
         menubar.add(file);
         menubar.add(productosMenu);
         menubar.add(promocionesMenu);

         setJMenuBar(menubar);
         
        createList(c);
        createButtons(c);
        JScrollPane scrollpane = new JScrollPane(list);

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(scrollpane)
                .addGroup(gl.createParallelGroup()
                        .addComponent(addbtn)
                        .addComponent(chgbtn)
                        .addComponent(renbtn)
                        .addComponent(delbtn)
                        .addComponent(remallbtn))
        );

        gl.setVerticalGroup(gl.createParallelGroup(CENTER)
                .addComponent(scrollpane)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(addbtn)
                        .addComponent(chgbtn)
                        .addComponent(renbtn)
                        .addComponent(delbtn)
                        .addComponent(remallbtn))
        );

        gl.linkSize(addbtn, chgbtn ,renbtn, delbtn, remallbtn);
        
        setIconImage(CuadroDialogo.img.getImage());
        pack();
        setSize(800, 600);
        setTitle(c.getNombre()+": Locales ");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static JPanel newPane(String labelText, JPanel pane) {
        
        pane.add(newLabel(labelText));
        pane.add(newButton("Open dialog"), BorderLayout.SOUTH);
        return pane;
    }
    private static JLabel newLabel(String label) {
        JLabel l = new JLabel(label);
        l.setFont(l.getFont().deriveFont(24.0f));
        return l;
    }

    private static JButton newButton(String label) {
        final JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window parentWindow = SwingUtilities.windowForComponent(button);
                JDialog dialog = new JDialog(parentWindow);
                dialog.setLocationRelativeTo(button);
                dialog.setModal(true);
                //dialog.add(newPane("Label in dialog"));
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        return button;
    }
	public ListaComponentes getComponente(Cadena c,int a) {
		
		ListaComponentes l=null;
		if(c!=null)
		{
			l=new ListaComponentes();
			if(a==1)//obtiene productos
			{
				for(int i=0;i<c.sizeComponentes();i++)
				{
					Componente comp=c.searchComponente(i);
					if(comp!=null&& !comp.getChild())
						l.add(comp);
				}
			}
			else if(a==2)//obtiene promociones
			{
				for(int i=0;i<c.sizeComponentes();i++)
				{
					Componente comp=c.searchComponente(i);
					if(comp!=null&& comp.getChild())
						l.add(comp);
				}
			}
			else
			{
				l=new ListaComponentes();
				for(int i=0;i<c.sizeComponentes();i++)
				{
					Componente comp=c.searchComponente(i);
					if(comp!=null)
						l.add(comp);
				}
			}
		}
		return l;
	}


}