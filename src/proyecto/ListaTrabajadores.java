package proyecto;

import java.util.*;

public class ListaTrabajadores implements ManejoTrabajadores {
	private ArrayList <Trabajador> trabajadores;
	public ListaTrabajadores()
	{
		trabajadores=new ArrayList<Trabajador>();
	}
	
	public boolean addTrabajador(Trabajador t)
	{
		if(t!=null)
		{
			if(!trabajadores.contains(t))
			{
				trabajadores.add(t);
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	public boolean deleteTrabajador(Trabajador t)
	{
		if(t!=null&&trabajadores.contains(t))
		{
			trabajadores.remove(t);
			return true;
		}
		else
			return false;
	}
	public boolean deleteTrabajador(int index)
	{
		if(index>=0&&trabajadores.size()>index)
		{
			trabajadores.remove(index);
			return true;
		}
		else
			return false;
	}
	public Trabajador getTrabajador(int index)
	{
		if(index>=0&&trabajadores.size()>index)
		{
			return trabajadores.get(index);
		}
		else
			return null;
	}
	public int getTrabajador(Trabajador p)
	{
		if(p!=null&&trabajadores.contains(p))
		{
			return trabajadores.indexOf(p);
		}
		else
			return -1;
	}
	public int size()
	{
		return trabajadores.size();
	}
	
	public boolean contains(Trabajador p)
	{
		return trabajadores.contains(p);
	}
	
	
}
