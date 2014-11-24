package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Producto extends Componente {
	private int precio;
	private double cantidad;
	private String tipo;
	private String unidades;
	
	public Producto(String sku,String nombre,int precio,double cantidad, int tipo)
	{
		super(nombre,sku);
		
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
		this.precio=precio;
		this.cantidad=cantidad;
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

	public String getTipo() {
		return tipo;
	}

	public String getUnidades() {
		return unidades;
	}

	@Override
	public int getTotal() {
		return precio;
	}

	@Override
	public String describe() {
		return super.getSku()+" : "+super.getNombre();
	}
	

}
