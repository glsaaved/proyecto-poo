package proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Local{
	private Lista productos;
	private Lista ventas;
	private int id;
	private String direccion;

	
	public Local(int id, String direccion)
	{
		this.id=id;
		this.direccion=direccion;
		this.productos=new ListaComponentes();;
		this.ventas=new ListaVentas();
	}
	public Local(int id, String direccion,ListaComponentes productos)
	{
		this.id=id;
		this.direccion=direccion;
		if(productos==null)
			this.productos=new ListaComponentes();
		else
			this.productos=productos;
		this.ventas=new ListaVentas();
	}
	
	public void setDireccion(String d)
	{
		if(d!=null)
			this.direccion=d;
	}
	public String getDireccion()
	{
		return direccion;
	}
	
	public int getId()
	{
		return id;
	}
	

	public void show()
	{
		System.out.println("=====================================");
		System.out.println("=====================================");
		System.out.println("####### DETALLE LOCAL "+id+"#########");
		System.out.println("Direccion: "+direccion);
		System.out.println("Ventas: "+ventas.size());
		menu();
	}
	public void menu()
	{
		int opcion=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
			do
			{
			System.out.println("=====================================");
			System.out.println("=====================================");
			System.out.println("=====================================");
			System.out.println("Elija una accion:");
			System.out.println("1. Realizar Venta (necesario vendedor)");
			System.out.println("2. Realizar Venta rapida");
			System.out.println("3. Cargar Trabajadores");
			System.out.println("4. Volver");
			try
			{
				opcion=Integer.parseInt(br.readLine());
			}
			catch(Exception e)
			{
				opcion=0;
			}
		}while(opcion<1||opcion>5);
			if(opcion==1)
			{
				menuRealizarVenta(br);
			}
			if(opcion==2)
			{
				menuRealizarVentaRapida(br);
			}
			if(opcion==3)
			{
				menuCargarTrabajadores();
			}
		}
		while(opcion!=4);
	}

	private void menuCargarTrabajadores() {
		// TODO Auto-generated method stub
		
	}
	private void menuRealizarVenta(BufferedReader br) {
		// TODO Auto-generated method stub
		
	}
	private void menuRealizarVentaRapida(BufferedReader br) {
		Venta v=new Venta();
		int opcion=0;
		do{
			do
			{
			System.out.println("=====================================");
			System.out.println("=====================================");
			System.out.println("=====================================");
			System.out.println("Elija una accion:");
			System.out.println("1. Añadir Producto a Venta");
			System.out.println("2. Añadir Promocion a Venta");
			System.out.println("3. Generar Boleta");
			System.out.println("4. Total");
			System.out.println("5. Volver");
			try
			{
				opcion=Integer.parseInt(br.readLine());
			}
			catch(Exception e)
			{
				opcion=0;
			}
		}while(opcion<1||opcion>6);
			if(opcion==1)
			{
				menuAñadirProducto(br,v);
			}
			if(opcion==3)
			{
				menuBoleta(br,v);
			}
			if(opcion==4)
			{
				menuTotal(br,v);
			}
	}while(opcion!=5);
		if(v!=null)
		{
			ventas.add(v);
		}
		menu();
	}
	private void menuBoleta(BufferedReader br, Venta v) {
		String s="";
		s+=v.getFecha().getFecha_long()+"                                             \n";
		s+="Local: "+direccion+"\n";
		
		s+="             "+"Productos                         "+"Valor                +\n";
		s+=v.printVendidos();
		s+="____________________________________________________________________\n";
		s+="             "+"Total                            "+v.getTotal()+"\n\n\n";
		s+="                         Gracias por su preferencia                    \n";
		int id=Principal.randInt(10000, 2000000);
        try {
            File file = new File("boleta "+id+".txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(s);
            output.close();
          } catch ( IOException e ) {
      		System.out.println("No se pudo guardar, reintente");
          }
		
		
	}
	private void menuTotal(BufferedReader br, Venta v) {
		System.out.println("Total de la Venta: " +v.getTotal());
		
	}
	private void menuAñadirProducto(BufferedReader br,Venta v) {
		int opcion=0;
		Object o=null;
		do
		{
			System.out.println("=====================================");
			System.out.println("Elija el numero de un item:");
			for(int i=0;i<productos.size();i++)
			{
				o=productos.search(i);
				if(o instanceof Componente)
					System.out.println(i+". "+((Componente)o).describe());
			}
		try
		{
			opcion=Integer.parseInt(br.readLine());
		}
		catch(Exception e)
		{
			opcion=0;
		}
	}while(opcion<0||opcion>productos.size());
		v.add((Componente)o);
		
	}
	@Override
	public String toString()
	{
		return "Id: "+id+"- Direccion: "+direccion;
	}
	public void addComponente(Componente o)
	{
		productos.add(o);
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
	public void addVenta(Venta v)
	{
		ventas.add(v);
	}
	public int sizeVentas()
	{
		return ventas.size();
	}
	public Venta searchVentas(int i)
	{
		return (Venta)ventas.search(i);
	}
	public void deleteVentas(Object o)
		{
		if(o!=null)
			ventas.delete(o);
	}
}
