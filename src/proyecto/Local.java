package proyecto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Local implements ManejoTrabajadores,ManejoProductos,ManejoPromociones{
	private ListaTrabajadores trabajadores;
	private ListaProductos productos;
	private ListaPromociones promociones;
	private ArrayList<Venta> ventas;
	private int id;
	private String direccion;
	private Trabajador jefe_local;
	private Trabajador vendedor_actual;
	
	public Local(int id, String direccion)
	{
		this.id=id;
		this.direccion=direccion;
		this.trabajadores=new ListaTrabajadores();
		this.productos=new ListaProductos();
		this.promociones=new ListaPromociones();
		this.ventas=new ArrayList<Venta>();
	}
	public Local(int id, String direccion,ListaProductos productos,ListaPromociones promociones)
	{
		this.id=id;
		this.direccion=direccion;
		this.trabajadores=new ListaTrabajadores();
		if(productos==null)
			this.productos=new ListaProductos();
		else
			this.productos=productos;
		if(promociones==null)
			this.promociones=new ListaPromociones();
		else
			this.promociones=promociones;
		this.ventas=new ArrayList<Venta>();
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
	
	public void setVendedor_Actual(int i)
	{
		if(i>=0&&i<trabajadores.size())
		{
			this.vendedor_actual=trabajadores.getTrabajador(i);
		}
	}
	public void setVendedor_Actual(Trabajador t)
	{
		if(t!=null)
		{
			if(!trabajadores.contains(t))
				trabajadores.addTrabajador(t);
			this.vendedor_actual=t;
			
		}
			
	}
	public void setJefe_Local(int i)
	{
		if(i>=0&&i<trabajadores.size())
		{
			this.jefe_local=trabajadores.getTrabajador(i);
		}
	}
	public void setJefe_Local(Trabajador t)
	{
		if(t!=null)
		{
			if(!trabajadores.contains(t))
				trabajadores.addTrabajador(t);
			this.jefe_local=t;
			
		}
			
	}
	
	//
	//
	//Implementacion Interfaces
	
	//promocion
	@Override
	public boolean addPromocion(Promocion p) {
		if(!promociones.contains(p))
			return promociones.addPromocion(p);
		else
			return false;
	}
	@Override
	public boolean deletePromocion(Promocion p) {
		return promociones.deletePromocion(p);
	}
	@Override
	public boolean deletePromocion(int index) {
		return promociones.deletePromocion(index);
	}
	@Override
	public Promocion getPromocion(int index) {
		return promociones.getPromocion(index);
	}
	@Override
	public boolean deleteAllPromocion(Promocion p) {
		return promociones.deleteAllPromocion(p);
	}
	@Override
	public void deleteAll_() {
		promociones.deleteAll_();
		
	}
	//producto
	@Override
	public boolean addProducto(Producto p) {
		if(!productos.contains(p))
			return productos.addProducto(p);
		else
			return false;
	}
	@Override
	public boolean deleteProducto(Producto p) {
		return productos.deleteProducto(p);
	}
	@Override
	public boolean deleteProducto(int index) {
		return productos.deleteProducto(index);
	}
	@Override
	public Producto getProducto(int index) {
		return productos.getProducto(index);
	}
	@Override
	public boolean deleteAllProducto(Producto p) {
		return productos.deleteAllProducto(p);
	}
	@Override
	public void deleteAll() {
		productos.deleteAll();
	}
	//trabajador
	@Override
	public boolean addTrabajador(Trabajador t) {
		if(!trabajadores.contains(t))
			return trabajadores.addTrabajador(t);
		else
			return false;
	}
	@Override
	public boolean deleteTrabajador(Trabajador t) {
		return trabajadores.deleteTrabajador(t);
	}
	@Override
	public boolean deleteTrabajador(int index) {
		return trabajadores.deleteTrabajador(index);
	}
	@Override
	public Trabajador getTrabajador(int index) {
		return trabajadores.getTrabajador(index);
	}
	@Override
	public int getTrabajador(Trabajador t) {
		return trabajadores.getTrabajador(t);
	}
	public void show()
	{
		System.out.println("=====================================");
		System.out.println("=====================================");
		System.out.println("####### DETALLE LOCAL "+id+"#########");
		if(jefe_local!=null)
			System.out.println("Jefe Local: "+jefe_local.getNombre_Completo());
		else
			System.out.println("No hay jefe de local");
		if(vendedor_actual!=null)
			System.out.println("Vendedor de Turno: "+vendedor_actual.getNombre_Completo());
		else
			System.out.println("No hay vendedor en este turno");
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
			if(opcion==2)
			{
				menuAñadirPromocion(br,v);
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
		int i=0;
		while(v.getProducto(i)!=null)
		{
			s+="             "+v.getProducto(i).getNombre()+"      "+v.getProducto(i).getPrecio()+"\n";
			i++;
		}
		i=0;
		while(v.getPromocion(i)!=null)
		{
			s+="             "+v.getPromocion(i).getNombre()+"      "+v.getPromocion(i).getTotal()+"\n";
			i++;
		}
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
		do
		{
			System.out.println("=====================================");
			System.out.println("Elija el numero de un producto:");
			for(int i=0;i<productos.size();i++)
			{
				System.out.println(i+". "+productos.getProducto(i).getNombre()+"-- Precio :"+ productos.getProducto(i).getPrecio());
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
		v.addProducto(productos.getProducto(opcion));
		
	}
	private void menuAñadirPromocion(BufferedReader br,Venta v) {
		int opcion=0;
		do
		{
			System.out.println("=====================================");
			System.out.println("Elija el numero de una promocion:");
			for(int i=0;i<promociones.size();i++)
			{
				System.out.println(i+". "+promociones.getPromocion(i).getNombre()+"-- Precio :"+ promociones.getPromocion(i).getTotal());
			}
		try
		{
			opcion=Integer.parseInt(br.readLine());
		}
		catch(Exception e)
		{
			opcion=0;
		}
	}while(opcion<0||opcion>promociones.size());
		v.addPromocion(promociones.getPromocion(opcion));
		
	}
	

}
