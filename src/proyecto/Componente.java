package proyecto;

import java.io.File;

public abstract class Componente implements Contable{
	private String nombre;
	private String sku;
	
	public Componente(String nombre, String sku)
	{
		this.nombre=nombre;
		this.sku=sku;
	}
	public abstract String describe();//hacer implementacion para nombre y precio
	
	public void add(Componente e) throws ProductoException
	{
		if((this instanceof Producto))
			throw new ProductoException();
	}
	public void remove(Componente e) throws ProductoException
	{
		if((this instanceof Producto))
			throw new ProductoException();
	}
	public Componente getChild(int i)
	{
		return null;
	}
	public boolean isThis(String sku)
	{
		if(sku.equalsIgnoreCase(this.sku))
			return true;
		else
			return false;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String s) {
		sku=s;
	}
	public boolean getChild()
	{
		return false;
	}
	@Override
	public String toString()
	{
		return sku+": "+nombre;
	}
}

