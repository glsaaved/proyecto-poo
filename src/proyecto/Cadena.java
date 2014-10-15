package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import proyecto.graphics.Tree;

public class Cadena   {
	private ListaLocales locales;
	private ListaProductos productos;
	private ListaPromociones promociones;
	private String nombre;

	public Cadena(String nombre)
	{
		this.nombre=nombre;
		this.locales=new ListaLocales();
		this.productos=new ListaProductos();
		this.promociones=new ListaPromociones();
		
	}
	public Cadena(String nombre,ListaLocales locales)
	{
		this.nombre=nombre;
		this.locales=locales;
		this.productos=new ListaProductos();
		this.promociones=new ListaPromociones();
	}
	/**
	 * añade un local a la lista locales
	 * @param l, Local a añadir
	 * @return true si lo añade, false en otro caso
	 */
	public boolean addLocal(Local l)
	{
		if(l!=null)
		{
			return locales.addLocal(l);
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
		return locales.crearLocal(direccion);
	}
	/**
	 * elimina un local de la lista locales
	 * @param id, id del local a eliminar
	 * @return true si lo elimina, false en otro caso
	 */
	public boolean deleteLocal(int id)
	{
		Local l=locales.buscarLocal(id);
		if(l!=null)
		{
			return locales.deleteLocal(l);
		}
		else
			return false;
	}
	/**
	 * llama al metodo de menu
	 * @throws IOException
	 */
	public void show()throws IOException 
	{
		menu();
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
				menuCargaProductos(br);
			}
			if(opcion==5)
			{
				menuModificarProductos(br);
			}
			if(opcion==6)
			{
				menuCargarPromociones(br);
			}
			if(opcion==7)
			{
				menuModificarPromociones(br);
			}
			if(opcion==8)
			{
				menuCargarLocal(br);
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
	private void menuCargarLocal(BufferedReader br) throws FileNotFoundException, IOException {
		System.out.println("=====================================");
		System.out.println("=====================================");
		if(locales.cargarArchivo(productos,promociones))
			System.out.println("Se cargaron correctamente las promociones");
		else
			System.out.println("Ocurrio un error, verifique el archivo promociones.txt");
		System.out.println("=====================================");
		System.out.println("=====================================");
		menu();
		
	}
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
	private void menuCargarPromociones(BufferedReader br) throws FileNotFoundException, IOException {
		
		System.out.println("=====================================");
		System.out.println("=====================================");
		if(promociones.cargarArchivo(productos))
			System.out.println("Se cargaron correctamente las promociones");
		else
			System.out.println("Ocurrio un error, verifique el archivo promociones.txt");
		System.out.println("=====================================");
		System.out.println("=====================================");
		menu();
		
	}
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
	private void menuCargaProductos(BufferedReader br) throws FileNotFoundException, IOException {
		productos=new ListaProductos();
		System.out.println("=====================================");
		System.out.println("=====================================");
		if(productos.cargarArchivo())
			System.out.println("Se cargaron correctamente los productos");
		else
			System.out.println("Ocurrio un error, verifique el archivo productos.txt");
		System.out.println("=====================================");
		System.out.println("=====================================");
		menu();
		
	}
	/**
	 * lista los locales en la lista locales
	 */
	public void listar()
	{
		if(locales.size()>0)
			for(int i=0;i<locales.size();i++)
			{
				System.out.println(i+". Local :" + locales.getLocal(i).getId()+" , Direccion: "+locales.getLocal(i).getDireccion());
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
		Principal.clearConsole();
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
		locales.crearLocal(s);
		menu();
		
	}
	/**
	 * elimina un local manualmente, identificado por el id
	 * @param br
	 * @throws IOException
	 */
	private void menuEliminar(BufferedReader br) throws IOException {
		
		Principal.clearConsole();
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
		Local l=locales.buscarLocal(eliminar);
		if(l!=null)
		{
			locales.deleteLocal(l);
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
		Principal.clearConsole();
		int eliminar=-1;
		System.out.println("=====================================");
		System.out.println("=====================================");
		System.out.println("######### DETALLE LOCAL  ############");
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
		}while (eliminar==-1);
		Local l=locales.buscarLocal(eliminar);
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


}
