package proyecto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ListaLocales {
	private ArrayList <Local> locales;
	public ListaLocales()
	{
		locales= new ArrayList<Local>();
	}
	public boolean addLocal(Local l)
	{
		if(l!=null)
		{
			if(!locales.contains(l))
				return locales.add(l);
			else
				return false;
		}
		else
			return false;
	}
	public boolean deleteLocal(Local l)
	{
		if(l!=null)
		{
			if(locales.contains(l))
				return locales.remove(l);
			else
				return false;
		}
		else
			return false;
	}
	public boolean deleteLocal(int index)
	{
		if(index>=0&&index<locales.size())
		{
			locales.remove(index);
			return true;
		}
		else
			return false;
	}
	public Local getLocal(int index)
	{
		if(index>=0&&index<locales.size())
		{
			return locales.get(index);
		}
		else
			return null;
	}
	public boolean crearLocal(String direccion,ListaProductos productos,ListaPromociones promociones)
	{
		if(direccion!=null)
		{
			int id=0;
			do{
				id=Principal.randInt(1,100000);
			}while(idRepetida(id));
			Local l=new Local(id,direccion,productos,promociones);
			return addLocal(l);
		}
		else
			return false;
	}
	public boolean crearLocal(String direccion)
	{
		if(direccion!=null)
		{
			int id=0;
			do{
				id=Principal.randInt(1,100000);
			}while(idRepetida(id));
			Local l=new Local(id,direccion);
			return addLocal(l);
		}
		else
			return false;
	}
	
	private boolean idRepetida(int id)
	{
		for(int i=0;i<locales.size();i++)
		{
			if(locales.get(i).getId()==id)
				return true;
		}
		return false;
	}
	public Local buscarLocal(int id)
	{
		for(int i=0;i<locales.size();i++)
		{
			if(locales.get(i).getId()==id)
				return locales.get(i);
		}
		return null;
	}
	public int size()
	{
		return locales.size();
	}
	public boolean cargarArchivo() throws FileNotFoundException, IOException
	{
	    try(BufferedReader br = new BufferedReader(new FileReader("locales.txt"))) {
	        String line = br.readLine();

	        while (line != null) {
	        	crearLocal(line);
	            line = br.readLine();
	        }
	    }
	    catch(Exception e)
	    {
	    	return false;
	    }
	    return true;
	}
	public boolean cargarArchivo(ListaProductos p,ListaPromociones promo) throws FileNotFoundException, IOException
	{
	    try(BufferedReader br = new BufferedReader(new FileReader("locales.txt"))) {
	        String line = br.readLine();

	        while (line != null) {
	        	crearLocal(line,p,promo);
	            line = br.readLine();
	        }
	    }
	    catch(Exception e)
	    {
	    	return false;
	    }
	    return true;
	}
}
