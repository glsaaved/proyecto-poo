package proyecto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaProductos implements ManejoProductos {
	private ArrayList <Producto> productos;
	public ListaProductos()
	{
		productos=new ArrayList<Producto>();
	}
	public boolean isEmpty()
	{
		return productos.isEmpty();
	}

	public boolean deleteProducto(Producto p)
	{
		if(productos.contains(p))
		{
			if(productos.remove(p))
			{
				return true;
			}
			else
				return false;
		}
		return false;
	}
	@Override
	/**
	 * borra un producto de la lista productos
	 * @param index, posicion del producto a borrar
	 * @return true si lo elimino, false en otro caso
	 */
	public boolean deleteProducto(int index) {
		if(index>=0&&productos.size()>0&&productos.size()>index)
		{
			productos.remove(index);
			return true;
		}
		else
			return false;	

	}
	@Override
	/**
	 * quita todos los productos que sean p
	 * @param p, producto del cual se deben quitar todas las coincidencias
	 * @return true si al menos elimino 1, false en otro caso
	 */
	public boolean deleteAllProducto(Producto p)
	{
		int cont=0;
		while(deleteProducto(p))
		{
			cont++;
		}
		if(cont>0)
			return true;
		else
			return false;
	}
	@Override
	/**
	 * quita todos los elementos de la lista productos
	 */
	public void deleteAll()
	{
		if(!productos.isEmpty())
		{
			productos.clear();
		}
	}

	@Override
	/**
	 * metodo que retorna el producto en la posicion index
	 * @param index, posicion en la lista
	 * @return producto en la posicion index, null en otro caso
	 */
	public Producto getProducto(int index) {
		if(index < 0 || index >= productos.size())
		{
			return null;
		}
		else
		{
			return productos.get(index);
		}
	}
	@Override
	/**
	 * metodo que añade un producto
	 * @param p, producto a añadir
	 * @return true si lo agrega, false en otro caso
	 */
	public boolean addProducto(Producto p) {
		if(p != null)
		{
			if(this.productos.add(p))
			{
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	public int getTotal() {
		int cont=0;
		for(int i=0;i<productos.size();i++)
		{
			cont+=productos.get(i).getPrecio();
		}
		return cont;
	}
	public int size()
	{
		return productos.size();
	}
	public boolean contains(Producto p)
	{
		return productos.contains(p);
	}
	/**
	 * carga desde archivo los productos
	 * @return
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public boolean cargarArchivo() throws FileNotFoundException, IOException
	{
	    try(BufferedReader br = new BufferedReader(new FileReader("productos.txt"))) {
	        String line = br.readLine();

	        while (line != null) {
	        	String s[]= line.split(",");
				if(s.length>=4)
	        	{
						Producto p=new Producto(s[0],s[1],Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4]));
						if(p!=null)
							productos.add(p);
	        	}
	            line = br.readLine();
	        }
	    }
	    catch(Exception e)
	    {
	    	return false;
	    }
	    return true;
	}
	public Producto buscarProducto(String sku)
	{
		if(sku!=null)
		{
			for(int i=0;i<productos.size();i++)
			{
				if(productos.get(i).getSku().equalsIgnoreCase(sku))
					return productos.get(i);
			}
		}
		return null;

	}

}
