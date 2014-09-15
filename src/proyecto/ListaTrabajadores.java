package proyecto;

import java.util.*;

public class ListaTrabajadores {
	private ArrayList <Trabajador> trabajadores;
	private int total;
	public ListaTrabajadores()
	{
		trabajadores=new ArrayList<Trabajador>();
		total=0;
	}
	
	public boolean addTrabajador(Trabajador t)
	{
		if(t!=null)
		{
			if(!trabajadores.contains(t))
			{
				trabajadores.add(t);
				total++;
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
			total--;
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
			total--;
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
	
	
}
