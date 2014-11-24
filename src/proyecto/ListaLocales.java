package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;

public class ListaLocales extends Lista{
	public ListaLocales()
	{
		super();
	}
	public Object searchId(int id) {
		for(int i=0;i<super.size();i++)
		{
			Local c=(Local)super.search(i);
			if(c!=null&&c.getId()==id)
				return c;
		}
		return null;
	}
	@Override
	public boolean add(Object l)
	{
		if(l!=null)
		{
			if(!super.contains(l))
				return super.add(l);
			else
				return false;
		}
		else
			return false;
	}

	@Override
	public Object search(String s) {
		for(int i=0;i<super.size();i++)
		{
			Local c=(Local)super.search(i);
			if(c!=null&&c.getDireccion().equalsIgnoreCase(s))
				return c;
		}
		return null;
	}
	
	public boolean crearLocal(String direccion,ListaComponentes productos)
	{
		if(direccion!=null)
		{
			int id=0;
			do{
				id=Principal.randInt(1,100000);
			}while(idRepetida(id));
			Local l=new Local(id,direccion,productos);
			if(search(direccion)==null)
				return add(l);
			else
				return false;
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
			if(search(direccion)==null)
				return add(l);
			else
				return false;
		}
		else
			return false;
	}
	public boolean crearLocal(String direccion, int index, int id1) {
		if(direccion!=null)
		{
			int id=id1;
			if(idRepetida(id))
			do{
				id=Principal.randInt(1,100000);
			}while(idRepetida(id));
			Local l=new Local(id,direccion);
			if(search(direccion)==null)
				return add(l);
			else
				return false;
		}
		else
			return false;
		
	}
	
	private boolean idRepetida(int id)
	{
		for(int i=0;i<super.size();i++)
		{
			if(((Local)super.search(i)).getId()==id)
				return true;
		}
		return false;
	}

	public boolean loadFile(ListaComponentes p) throws FileNotFoundException, IOException
	{
	    try(BufferedReader br = new BufferedReader(new FileReader("locales.txt"))) {
	        String line = br.readLine();

	        while (line != null) {
	        	crearLocal(line,p);
	            line = br.readLine();
	        }
	    }
	    catch(Exception e)
	    {
	    	return false;
	    }
	    return true;
	}
	public boolean loadFile(File f) throws FileNotFoundException, IOException, loadFileException
	{
	    try(BufferedReader br = new BufferedReader(new FileReader(f))) {
	        String line = br.readLine();
	        ListaComponentes l = null;
	        //if(line!="..")
	        //{
	        	//l=new ListaComponentes();
	        	//l.loadFile(line);
	        //}
	        //line = br.readLine();
	        while (line != null) {
	        	//if(l!=null)
	        		crearLocal(line);
	            line = br.readLine();
	        }
	    }
	    catch(Exception e)
	    {
	    	throw new loadFileException();
	    }
	    return true;
	}

	private void reasignar(int index) {
		// TODO Auto-generated method stub
		
	}
	public boolean saveFile(File f) throws saveFileException, FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter(f, "UTF-8");
		for(int i=0;i<super.size();i++)
		{
			Local l=(Local)super.search(i);
			if(l!=null)
			{
				writer.println(l.getDireccion());
				
			}
		}
		writer.close();
		return true;
	}


}
