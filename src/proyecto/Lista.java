package proyecto;

import java.util.ArrayList;

public abstract class Lista implements Coleccion {
	private ArrayList elementos;
	
	public Lista()
	{
		elementos=new ArrayList();
	}
	@Override
	public boolean add(Object o) {
		if(o != null)
		{
			if(this.elementos.add(o))
			{
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	
	@Override
	public boolean contains(Object o) {
		return elementos.contains(o);
	}

	@Override
	public void deleteAll() {
		if(!elementos.isEmpty())
		{
			elementos.clear();
		}
	}

	@Override
	public boolean delete(Object o) {
		if(elementos.contains(o))
		{
			if(elementos.remove(o))
			{
				return true;
			}
			else
				return false;
		}
		return false;
	}

	@Override
	public boolean delete(int i) {
		if(i>=0&&elementos.size()>0&&elementos.size()>i)
		{
			elementos.remove(i);
			return true;
		}
		else
			return false;	
	}
	
	@Override
	public boolean deleteAllInstances(Object o) {
		int cont=0;
		while(delete(o))
		{
			cont++;
		}
		if(cont>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean isEmpty() {
		return elementos.isEmpty();
	}

	@Override
	public int size() {
		return elementos.size();
	}
	@Override
	public Object search(int i) {
		if(i < 0 || i >= elementos.size())
			return null;
		else
			return elementos.get(i);
	}


}
