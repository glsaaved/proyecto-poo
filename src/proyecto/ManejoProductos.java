package proyecto;

public interface ManejoProductos {
	public boolean addProducto(Producto p);
	public boolean deleteProducto(Producto p);
	public Producto getProducto(int index);
	public boolean deleteAllProducto(Producto p);
	public void deleteAll();
	public int getTotal();
	

}
