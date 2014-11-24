package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import proyecto.graphics.ListModels;
import proyecto.graphics.defaultException;

public class Cadena   {
	private Lista locales;
	private Lista productos;
	private String nombre;

	public Cadena(String nombre)
	{
		this.nombre=nombre;
		this.locales=new ListaLocales();
		this.productos=new ListaComponentes();
		
	}
	public Cadena(String nombre,Lista locales)
	{
		this.nombre=nombre;
		this.locales=locales;
		this.productos=new ListaComponentes();
	}
	public Cadena(String nombre,Lista locales, Lista componentes)
	{
		this.nombre=nombre;
		this.locales=locales;
		this.productos=componentes;
	}
	public void setLocales(ListaLocales l)
	{
		locales=l;
	}
	public int sizeLocales()
	{
		return locales.size();
	}
	/**
	 * añade un local a la lista locales
	 * @param l, Local a añadir
	 * @return true si lo añade, false en otro caso
	 */
	public boolean add(Local l)
	{
		if(l!=null)
		{
			return locales.add(l);
		}
		else
			return false;
	}
	/**
	 * crea un local y lo añade
	 * @param direccion, string necesario para crear el local
	 * @return true si lo crea , false en otro caso
	 */
	public boolean crearLocal(String direccion)
	{
		return ((ListaLocales)locales).crearLocal(direccion);
	}
	/**
	 * elimina un local de la lista locales
	 * @param id, id del local a eliminar
	 * @return true si lo elimina, false en otro caso
	 */
	public boolean deleteLocal(int id)
	{
		Local l=(Local)locales.search(id);
		if(l!=null)
		{
			return locales.delete(l);
		}
		else
			return false;
	}
	/**
	 * llama al metodo de menu
	 * @throws IOException
	 * @throws defaultException 
	 */
	public void show()throws IOException, defaultException 
	{
		ListModels ex = new ListModels(this);
        ex.setVisible(true);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * menu para realizar operaciones sobre los datos de la cadena
	 * @throws IOException
	 */
	public void menu() throws IOException 
	{
		int opcion=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("=====================================");
		System.out.println("=====================================");
		System.out.println("======"+nombre+"========");
		System.out.println("Locales");
		listar();
		System.out.println("=====================================");
		System.out.println("=====================================");
		do{
			do
			{
				System.out.println("Elija una opcion");
				System.out.println("1. Agregar un Local");
				System.out.println("2. Eliminar un Local");
				System.out.println("3. Ver Detalle Local");
				System.out.println("4. Cargar productos globales");
				System.out.println("5. Modificar productos globales");
				System.out.println("6. Cargar promociones globales");
				System.out.println("7. Modificar promociones globales");
				System.out.println("8. Cargar Locales");
				System.out.println("9. SALIR");
				try
				{
					opcion=Integer.parseInt(br.readLine());
				}
				catch(Exception e)
				{
					opcion=0;
				}
			}while(opcion<1||opcion>8);
			if(opcion==1)
			{
				menuAgregar(br);
			}
			if(opcion==2)
			{
				menuEliminar(br);
			}
			if(opcion==3)
			{
				menuDetalle(br);
			}
			if(opcion==4)
			{
				//menuCargaProductos(br);
			}
			if(opcion==5)
			{
				menuModificarProductos(br);
			}
			if(opcion==6)
			{
				//menuCargarPromociones(br);
			}
			if(opcion==7)
			{
				menuModificarPromociones(br);
			}
			if(opcion==8)
			{
				//menuCargarLocal(br);
			}
		}while(opcion!=9);
		System.exit(0);
	}
	/**
	 * carga el archivo predeterminado de locales
	 * @param br
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	/**private void menuCargarLocal(BufferedReader br) throws FileNotFoundException, IOException {
		System.out.println("=====================================");
		System.out.println("=====================================");
		if(locales.loadFile("locales.txt"))
			System.out.println("Se cargaron correctamente las promociones");
		else
			System.out.println("Ocurrio un error, verifique el archivo promociones.txt");
		System.out.println("=====================================");
		System.out.println("=====================================");
		menu();
		
	}**/
	/**
	 * sin implementacion
	 * @param br
	 * @throws IOException
	 */
	private void menuModificarPromociones(BufferedReader br) throws IOException {
		menu();
		
	}
	/**
	 * menu que carga las promociones predeterminadas
	 * @param br
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	/**private void menuCargarPromociones(BufferedReader br) throws FileNotFoundException, IOException {
		
		System.out.println("=====================================");
		System.out.println("=====================================");
		if(productos.loadFile("promociones.txt"))
			System.out.println("Se cargaron correctamente las promociones");
		else
			System.out.println("Ocurrio un error, verifique el archivo promociones.txt");
		System.out.println("=====================================");
		System.out.println("=====================================");
		menu();
		
	}**/
	/**
	 * sin implementacion
	 * @param br
	 * @throws IOException
	 */
	private void menuModificarProductos(BufferedReader br) throws IOException {
		menu();
		
	}
	/**
	 * metodo que carga los productos predeterminados
	 * @param br
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	/**private void menuCargaProductos(BufferedReader br) throws FileNotFoundException, IOException {
		productos=new ListaComponentes();
		System.out.println("=====================================");
		System.out.println("=====================================");
		if(productos.loadFile("productos.txt"))
			System.out.println("Se cargaron correctamente los productos");
		else
			System.out.println("Ocurrio un error, verifique el archivo productos.txt");
		System.out.println("=====================================");
		System.out.println("=====================================");
		menu();
		
	}**/
	/**
	 * lista los locales en la lista locales
	 */
	public void listar()
	{
		if(locales.size()>0)
			for(int i=0;i<locales.size();i++)
			{
				System.out.println(i+". Local :" + ((Local)locales.search(i)).getId()+" , Direccion: "+((Local)locales.search(i)).getDireccion());
			}
		else
			System.out.println("No hay locales");
	}
	/**
	 * Agrega un local manualmente, se añade las listas predeterminads de productos y promociones
	 * @param br
	 * @throws IOException
	 */
	public void menuAgregar(BufferedReader br) throws IOException
	{
		int opcion = 0;
		String s;
		System.out.println("=====================================");
		System.out.println("=====================================");
		System.out.println("#########  CREAR LOCAL  #############");
		do
		{
			System.out.println("Direccion");
			s=br.readLine();
			System.out.println("=====================================");
			System.out.println("La Direccion de su local es :" +s +" ¿es correcto?");
			System.out.println("1. si");
			System.out.println("2. no");
			try
			{
				opcion=Integer.parseInt(br.readLine());
			}
			catch(Exception e)
			{
				opcion=0;
			}
		}while (opcion!=1);
		((ListaLocales)locales).crearLocal(s);
		menu();
		
	}
	/**
	 * elimina un local manualmente, identificado por el id
	 * @param br
	 * @throws IOException
	 */
	private void menuEliminar(BufferedReader br) throws IOException {
		
		int opcion = 0;
		int eliminar=-1;
		System.out.println("=====================================");
		System.out.println("=====================================");
		System.out.println("#########  BORRAR LOCAL  ############");
		listar();
		do
		{
			System.out.println("Digite el id del local");
			try{
				eliminar=Integer.parseInt(br.readLine());
			}
			catch(Exception e)
			{
				eliminar=-1;
			}
			System.out.println("=====================================");
			System.out.println("El local a eliminar es :" +eliminar +" ¿es correcto?");
			System.out.println("1. si");
			System.out.println("2. no");
			try
			{
				opcion=Integer.parseInt(br.readLine());
			}
			catch(Exception e)
			{
				opcion=0;
			}
		}while (opcion!=1);
		Local l=(Local)((ListaLocales)locales).searchId(eliminar);
		if(l!=null)
		{
			locales.delete(l);
			System.out.println("Se elimino exitosamente");
		}
		else
		{
			System.out.println("No existe un local con ese id");
		}
		menu();
	}
	/**
	 * imprime detalles del local 
	 * @param br
	 * @throws IOException
	 */
	private void menuDetalle(BufferedReader br) throws IOException {
		int id=-1;
		System.out.println("=====================================");
		System.out.println("=====================================");
		System.out.println("######### DETALLE LOCAL  ############");
		listar();
		do
		{
			System.out.println("Digite el id del local");
			try{
				id=Integer.parseInt(br.readLine());
			}
			catch(Exception e)
			{
				id=-1;
			}
			System.out.println("=====================================");
		}while (id==-1);
		Local l=(Local)((ListaLocales)locales).searchId(id);
		if(l!=null)
		{
			l.show();
		}
		else
		{
			System.out.println("No existe un local con ese id");
		}
		menu();
		
	}
	public Local search(int i)
	{
		return (Local)locales.search(i);
	}
	public void loadProductos(File f) throws FileNotFoundException, IOException, loadFileException
	{
		productos.loadFile(f);
	}
	public String productosCargados()
	{
		String s="";
		for(int i=0;i<productos.size();i++)
		{
			Componente c=(Componente)productos.search(i);
			if(c!=null)
			{
				s+=c.describe();
			}
		}
		return s;
	}
	public int sizeComponentes()
	{
		return productos.size();
	}
	public Componente searchComponente(int i)
	{
		return (Componente)productos.search(i);
	}
	public void deleteComponente(Object o)
	{
		if(o!=null)
			productos.delete(o);
	}
	public boolean saveFile(File f) throws saveFileException, IOException
	{
		productos.saveFile(f);
		if(locales.saveFile(f))
			return true;
		
		return false;
		
	}
}
