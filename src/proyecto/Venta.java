package proyecto;

import java.util.*;

public class Venta {
	private Fecha_Hora fecha;
	private int total;
	private Trabajador atendido_por;
	private ArrayList<Producto> productos;
	private boolean valida;//verifica la integridad de la venta
	
	
	/*
	 * metodo que retorna el producto en la posicion index
	 * retorna null en otro caso
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
	/*
	 * metodo que añade un producto a la venta
	 * retorna true en caso de añadirlo, false en otro caso
	 */
	public boolean addProductos(Producto p) {
		if(p != null)
		{
			if(this.productos.add(p))
			{
				total+=p.getPrecio();
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	/*
	 * retorna si es valida la venta o no
	 */
	public boolean isValida() {
		return valida;
	}
	/*
	 * cambia el estado de la venta
	 * si es true es valida 
	 * si es false es invalida
	 */
	public void setValida(boolean valida) {
		this.valida = valida;
	}
	/*
	 * quita el primer producto p que este en productos
	 * retorna true si es valido y se elimino
	 * false en otro caso
	 */
	public boolean deleteProducto(Producto p)
	{
		if(productos.contains(p))
		{
			if(productos.remove(p))
			{
				total-=p.getPrecio();
				if(total<0)
					total=0;
				return true;
			}
			else
				return false;
		}
		return false;
	}
	/*
	 * quita todos los productos que sean p
	 * retorna true si al menos elimino 1 
	 * false en otro caso
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
	/*
	 * quita todos los elementos de la lista productos
	 */
	public void deleteAll()
	{
		if(!productos.isEmpty())
		{
			productos.clear();
			total=0;
		}
	}
	public int getTotal() {
		return total;
	}
	public Trabajador getAtendido_por() {
		return atendido_por;
	}
	public Fecha_Hora getFecha() {
		return fecha;
	}
	public void setFecha(Fecha_Hora fecha) {
		this.fecha = fecha;
	}

}
