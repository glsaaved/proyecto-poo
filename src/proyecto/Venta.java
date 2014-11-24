package proyecto;

import java.util.*;

public class Venta implements Contable{
	private Fecha_Hora fecha;
	private Trabajador atendido_por;
	private Lista vendidos;

	private boolean valida;//verifica la integridad de la venta
	public Venta(Trabajador t)
	{
		this.fecha=new Fecha_Hora();
		this.vendidos=new ListaComponentes();
		valida=false;
		setAtendido_por(t);
	}
	
	public Venta() {
		this.fecha=new Fecha_Hora();
		this.vendidos=new ListaComponentes();
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
		if(vendidos.isEmpty()||getTotal()==0)
		{
			this.valida=false;
		}
		else
		{
			if(!valida)
				valida=true;
		}
	}
	public int getTotal() {

		return ((ListaComponentes)vendidos).getTotal();
	}
	public boolean add(Componente c)
	{
		return vendidos.add(c);
	}
	public String printVendidos() {
		String s="";
		int i=0;
		while(vendidos.search(i)!=null)
		{
			s+=((Componente)vendidos.search(i)).getNombre()+":"+((Componente)vendidos.search(i)).getTotal()+"\n";
			i++;
		}
		return s;
	}

}
