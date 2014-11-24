package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Promocion extends Componente {
	private Lista hijos;
	private int descuento;//entero entre 0 y 100, representa el porcentaje
	/**
	 * constructor
	 * @param d,corresponde al porcentaje de descuento
	 */
	public Promocion(int d, String nombre,String sku)
	{
		super(nombre,sku);
		descuento=0;
		setDescuento(d);
		hijos=new ListaComponentes();
	}
	public String getNombre()
	{
		return super.getNombre();
	}
	public String getsku()
	{
		return super.getSku();
	}

	private int get_total()
	{
		int total=0;
		for(int i=0;i<hijos.size();i++)
		{
			Componente p=(Componente)hijos.search(i);
			if(p!=null)
			{
				total+=p.getTotal();
			}
		}
		return total;
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
	public int getTotal()
	{
		double desc=(descuento/100)*get_total();
		return (int)(get_total()-desc);
	}
	public void add(Componente c) throws ProductoException
	{ 
		hijos.add(c); 
	} 
	public void remove(Componente c) throws ProductoException
	{ 
		hijos.delete(c); 
	} 
	public Componente getChild(int i) { 
		return (Componente)hijos.search(i); 
	}
	@Override
	public String describe() {
		String s=super.getSku()+" : "+super.getNombre();
		for(int i=0;i<hijos.size();i++)
		{
			Componente c=(Componente) hijos.search(i);
			if(c!=null)
				s+="\n"+c.describe();
		}
		return s;
	}
	
	@Override
	/**
	 * retorna si es promocion
	 */
	public boolean getChild()
	{
		return true;
	}

	
}
