package proyecto;

import java.util.*;

public class Promocion implements ManejoProductos{
	private String nombre;
	private ListaProductos productos;
	private int descuento;//entero entre 0 y 100, representa el porcentaje
	/**
	 * constructor
	 * @param d,corresponde al porcentaje de descuento
	 */
	public Promocion(int d, String nombre)
	{
		this.nombre=nombre;
		descuento=0;
		setDescuento(d);
		productos=new ListaProductos();
	}
	public String getNombre()
	{
		return nombre;
	}
	/**
	 * metodo interno que calcula el total real de los productos
	 * @return cont, total de los precios de los productos
	 */
	private int get_total()
	{
		return productos.getTotal();
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
	@Override
	/**
	 * metodo que añade un producto
	 * @param p, producto a añadir
	 * @return true si lo agrega, false en otro caso
	 */
	public boolean addProducto(Producto p) {
		if(p != null)
		{
			if(this.productos.addProducto(p))
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
	/**
	 * borra un producto de la lista productos
	 * @param p, producto a borrar
	 * @return true si lo elimino, false en otro caso
	 */
	public boolean deleteProducto(Producto p)
	{
		if(productos.contains(p))
		{
			if(productos.deleteProducto(p))
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
			productos.deleteProducto(index);
			return true;
		}
		else
			return false;	

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
			return productos.getProducto(index);
		}
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
			productos.deleteAll();
		}
	}
	/**
	 * retorna el precio de la promocion
	 * @return el precio total de productos  - descuento
	 */
	public int getTotal()
	{
		double desc=(descuento/100)*get_total();
		return (int)(get_total()-desc);
	}

	
}
