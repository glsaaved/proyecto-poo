package proyecto;

import java.util.*;

public class Venta implements ManejoProductos,ManejoPromociones {
	private Fecha_Hora fecha;
	private Trabajador atendido_por;
	private ListaProductos productos;
	private ListaPromociones promociones;

	private boolean valida;//verifica la integridad de la venta
	public Venta(Trabajador t)
	{
		this.fecha=new Fecha_Hora();
		this.productos=new ListaProductos();
		this.promociones=new ListaPromociones();
		valida=false;
		setAtendido_por(t);
	}
	
	public Venta() {
		this.fecha=new Fecha_Hora();
		this.productos=new ListaProductos();
		this.promociones=new ListaPromociones();
		valida=false;
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
		if((productos.isEmpty()&&promociones.isEmpty())||getTotal()==0)
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
		boolean b=productos.deleteProducto(p);
		verifValida();
		return b;
	}
	@Override
	/**
	 * borra un producto de la lista productos
	 * @param index, posicion del producto a borrar
	 * @return true si lo elimino, false en otro caso
	 */
	public boolean deleteProducto(int index) {
		boolean b=productos.deleteProducto(index);
		verifValida();
		return b;

	}
	@Override
	/**
	 * quita todos los productos que sean p
	 * @param p, producto del cual se deben quitar todas las coincidencias
	 * @return true si al menos elimino 1, false en otro caso
	 */
	public boolean deleteAllProducto(Producto p)
	{
		boolean b=productos.deleteAllProducto(p);
		verifValida();
		return b;
	}
	@Override
	/**
	 * quita todos los elementos de la lista productos
	 */
	public void deleteAll()
	{
		productos.deleteAll();
		verifValida();
	}

	@Override
	/**
	 * metodo que retorna el producto en la posicion index
	 * @param index, posicion en la lista
	 * @return producto en la posicion index, null en otro caso
	 */
	public Producto getProducto(int index) {
		return productos.getProducto(index);
	}
	@Override
	/**
	 * metodo que añade un producto
	 * @param p, producto a añadir
	 * @return true si lo agrega, false en otro caso
	 */
	public boolean addProducto(Producto p) {
		boolean b=productos.addProducto(p);
		verifValida();
		return b;
	}

	@Override
	public boolean addPromocion(Promocion p) {
		return promociones.addPromocion(p);
	}

	@Override
	public boolean deletePromocion(Promocion p) {
		return promociones.deletePromocion(p);
	}

	@Override
	public boolean deletePromocion(int index) {
		return promociones.deletePromocion(index);
	}

	@Override
	public Promocion getPromocion(int index) {
		return promociones.getPromocion(index);
	}

	@Override
	public boolean deleteAllPromocion(Promocion p) {
		return promociones.deleteAllPromocion(p);
	}

	@Override
	public void deleteAll_() {
		promociones.deleteAll_();
		
	}
	/**
	 * retorna el total de la venta
	 * @return 
	 */
	public int getTotal() {

		int total_final=productos.getTotal()+promociones.getTotal();
		return total_final;
	}

}
