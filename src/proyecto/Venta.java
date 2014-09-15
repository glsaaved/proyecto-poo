package proyecto;

import java.util.*;

public class Venta implements ManejoProductos,ManejoPromociones {
	private Fecha_Hora fecha;
	private int total;
	private Trabajador atendido_por;
	private ArrayList<Producto> productos;
	private ArrayList<Promocion> promociones;
	private boolean valida;//verifica la integridad de la venta
	public Venta(Trabajador t)
	{
		this.fecha=new Fecha_Hora();
		this.productos=new ArrayList<Producto>();
		this.promociones=new ArrayList <Promocion>();
		valida=false;
		setAtendido_por(t);
	}
	
	/**
	 * return si es valida la venta o no
	 */
	public boolean isValida() {
		return valida;
	}
	/**
	 * cambia el estado de la venta
	 * @param valida, cambia el valor de this.valida
	 */
	public void setValida(boolean valida) {
		this.valida = valida;
	}
	/**
	 * 
	 * @return atendido_por
	 */
	public Trabajador getAtendido_por() {
		return atendido_por;
	}
	/**
	 * cambia el trabajador que atiende la venta
	 * @param t, nuevo trabajador, solo lo cambia si no es nulo
	 */
	public void setAtendido_por(Trabajador t){
		if(t!=null)
			this.atendido_por=t;
	}
	/**
	 * 
	 * @return fecha
	 */
	public Fecha_Hora getFecha() {
		return fecha;
	}
	/**
	 * cambia la fecha_hora de la venta en caso de cambio de la venta
	 * @param fecha, nueva fecha de la venta
	 */
	public void setFecha(Fecha_Hora fecha) {
		this.fecha = fecha;
	}
	/**
	 * cambia y verifica validez de la venta
	 */
	private void verifValida()
	{
		if((productos.isEmpty()&&promociones.isEmpty())||total==0)
		{
			this.valida=false;
		}
		else
		{
			if(!valida)
				valida=true;
		}
	}
	
	//implementacion de interface
	
	//producto
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
			if(productos.remove(p))
			{
				total-=p.getPrecio();
				if(total<0)
					total=0;
				verifValida();
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
		if(index>=0&&productos.size()>0&&productos.size()<index)
		{
			total-=productos.get(index).getPrecio();
			if(total<0)
				total=0;
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
			total-=p.getPrecio();
			if(total<0)
				total=0;
		}
		verifValida();
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
			total=0;
		}
		verifValida();
	}
	@Override
	/**
	 * retorna el total de la venta
	 * @return 
	 */
	public int getTotal() {

		return total;
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
				total+=p.getPrecio();
				verifValida();
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}


	//promociones
	@Override
	public boolean addPromocion(Promocion p) {
		if(p != null)
		{
			if(this.promociones.add(p))
			{
				total+=p.getTotal();
				verifValida();
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
				total-=p.getTotal();
				if(total<0)
					total=0;
				verifValida();
				return true;
			}
			else
				return false;
		}
		return false;
	}
	@Override
	public boolean deletePromocion(int index) {
		if(index>=0&&promociones.size()>0&&promociones.size()<index)
		{
			total-=promociones.get(index).getTotal();
			if(total<0)
				total=0;
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
			total-=p.getTotal();
			if(total<0)
				total=0;
		}
		verifValida();
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
			total=0;
		}
		verifValida();
		
	}
}
