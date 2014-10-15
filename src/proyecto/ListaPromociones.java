package proyecto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaPromociones implements ManejoPromociones {
	private ArrayList<Promocion> promociones;
	
	public ListaPromociones()
	{
		this.promociones=new ArrayList <Promocion>();
	}
	
	public boolean isEmpty()
	{
		return promociones.isEmpty();
	}
	@Override
	public boolean addPromocion(Promocion p) {
		if(p != null)
		{
			if(this.promociones.add(p))
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
	public boolean deletePromocion(Promocion p) {
		if(promociones.contains(p))
		{
			if(promociones.remove(p))
			{
				return true;
			}
			else
				return false;
		}
		return false;
	}
	@Override
	public boolean deletePromocion(int index) {
		if(index>=0&&promociones.size()>0&&promociones.size()>index)
		{
			promociones.remove(index);
			return true;
		}
		else
			return false;	

	}
	@Override
	public Promocion getPromocion(int index) {
		if(index < 0 || index >= promociones.size())
		{
			return null;
		}
		else
		{
			return promociones.get(index);
		}
	}
	@Override
	public boolean deleteAllPromocion(Promocion p) {
		int cont=0;
		while(deletePromocion(p))
		{
			cont++;
		}
		if(cont>0)
			return true;
		else
			return false;
	}
	@Override
	public void deleteAll_() {
		if(!promociones.isEmpty())
		{
			promociones.clear();
		}
		
	}
	public int getTotal()
	{
		int total=0;
		for(int i=0;i<promociones.size();i++)
		{
			total+=promociones.get(i).getTotal();
		}
		return total;
	}
	public int size()
	{
		return promociones.size();
	}
	
	public boolean contains(Promocion p)
	{
		return promociones.contains(p);
	}
	public boolean cargarArchivo(ListaProductos p) throws FileNotFoundException, IOException
	{
	    try(BufferedReader br = new BufferedReader(new FileReader("promociones.txt"))) {
	        String line = br.readLine();
	        String productos=br.readLine();
	        while (line != null&&productos!=null) {
	        	String s[]= line.split(",");
	        	String prod[]=productos.split(",");
	        	
				if(s.length>=2)
	        	{
						Promocion promo=new Promocion(Integer.parseInt(s[0]),s[1]);
						if(promo!=null)
							{
								
					        	for(int i=0;i<prod.length;i++)
					        	{
					        		Producto aux=p.buscarProducto(prod[i]);
					        		if(aux!=null)
					        			promo.addProducto(aux);
					        	}
					        	promociones.add(promo);
							}
	        	}
	            line = br.readLine();
	            productos=br.readLine();
	        }
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.toString());
	    	return false;
	    }
	    return true;
	}

}
