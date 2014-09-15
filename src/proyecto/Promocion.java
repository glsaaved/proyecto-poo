package proyecto;

import java.util.*;

public class Promocion {
	private ArrayList<Producto> productos;
	private int descuento;//entero entre 0 y 100, representa el porcentaje
	public Promocion(int d)
	{
		descuento=0;
		setDescuento(d);
	}
	/**
	 * metodo que añade un producto
	 * @param p, producto a añadir
	 * @return true si lo agrega, false en otro caso
	 */
	public boolean addProductos(Producto p) {
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
	/**
	 * borra un producto de la lista productos
	 * @param p, producto a borrar
	 * @return true si lo elimino, false en otro caso
	 */
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
	/**
	 * metodo interno que calcula el total real de los productos
	 * @return cont, total de los precios de los productos
	 */
	private int get_total()
	{
		int cont=0;
		for(int i=0; i<productos.size();i++)
		{
			if(productos.get(i)!=null)
				cont=productos.get(i).getPrecio();
		}
		return cont;
	}
	/**
	 * retorna el precio de la promocion
	 * @return el precio total de productos  - descuento
	 */
	public int precio()
	{
		double desc=(descuento/100)*get_total();
		return (int)(get_total()-desc);
	}
	/**
	 * actualiza el descuento de la promocion
	 * @param d, nuevo porcentaje de descuento
	 */
	public void setDescuento(int d)
	{
		if(d>=0&&d<100)
			descuento=d;
	}
}
