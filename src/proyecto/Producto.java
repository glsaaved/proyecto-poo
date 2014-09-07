package proyecto;

public class Producto {
	private String sku;//codigo de identificacion unico
	private String nombre;
	private int precio;
	private double cantidad;
	private String tipo;
	private String unidades;
	
	public Producto(String sku,String nombre,int precio,double cantidad, int tipo)
	{
		if(tipo==1)
		{
			this.tipo="comestible";
			this.unidades="gramos";
		}
		else if(tipo==2)
		{
			this.tipo="bebestible";
			this.unidades="cc";
		}
		else
		{
			this.tipo="complementario";
			this.unidades="unidades";
		}
		this.sku=sku;
		this.nombre=nombre;
		this.precio=precio;
		this.cantidad=cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public String getSku() {
		return sku;
	}

	public String getTipo() {
		return tipo;
	}

	public String getUnidades() {
		return unidades;
	}
	

}
