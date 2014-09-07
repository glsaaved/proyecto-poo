package proyecto;

import java.util.ArrayList;
/**
 * 
 * @author Gustavo Saavedra
 * Clase que hereda de persona, corresponde a un cliente
 * 
 *
 */
public class Cliente extends Persona{
	private ArrayList<Venta> compras;
	private String tipo_cliente;

	public Cliente(int rut, char dig_verificador, String nombre,
			String apellido, int dia, int mes, int año) 
	{
		super(rut, dig_verificador, nombre, apellido, dia, mes, año);
		this.setTipo_cliente("Esporádico");
		compras=new ArrayList<Venta>();
	}
	public Cliente(int rut, char dig_verificador, String nombre,
			String apellido, int dia, int mes, int año,char sexo) 
	{
		super(rut, dig_verificador, nombre, apellido, dia, mes, año,sexo);
		this.setTipo_cliente("Esporádico");
		compras=new ArrayList<Venta>();
	}
	/**
	 *Agrega una variable tipo Venta al arraylist compras
	 * @param venta
	 * @return true si lo agrega, false en otro caso
	 */
	public boolean add_compra(Venta venta)
	{
		if(venta!=null&&venta.isValida())
		{
			compras.add(venta);
			tipo_cliente();
			return true;
		}
		else
			return false;
	}
	/**
	 * Quita un elemento tipo Venta del arraylist compras
	 * @param venta
	 * @return true si encuentra y borra el elemento, false en otro caso
	 */
	public boolean delete_compra(Venta venta)
	{
		if(venta!=null&&venta.isValida())
		{
			if(compras.contains(venta))
			{
				if(compras.remove(venta))
					return true;
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
	/**
	 * Quita un elemento tipo Venta del arraylist en base a la posicion en el 
	 * @param index, indice del elemento a eliminar
	 * @return true si el indice es valido y elimina el elemento, false en otro caso
	 */
	public boolean delete_compra(int index)
	{
		if(index>=0&&compras.size()>0&&compras.size()>index)
		{
			compras.remove(index);
			return true;
		}
		else
			return false;
	}
	/**
	 * cambia el tipo de cliente dependiendo de su consumo en la cadena de locales
	 * lo clasifica por la cantidad de compras en los ultimos 6 meses
	 */
	public void tipo_cliente()
	{
		int contador=0;
		for(int i=0;i<compras.size();i++)
		{
			if(compras.get(i)!=null)
			{
				Venta compra=(Venta) compras.get(i);
				//se consideran compras dentro de los ultimos 6 meses
				if(compra.isValida()&&compra.getFecha().mes_diff_menor()<=6&&compra.getFecha().mes_diff_menor()>=0)
					contador++;
			}
		}
		if(contador<10)
			this.setTipo_cliente("Esporádico");
		else if(contador<30)
			this.setTipo_cliente("Normal");
		else if(contador<50)
			this.setTipo_cliente("Potencial");
		else if(contador>=50)
			this.setTipo_cliente("frecuente");
	}
	public String getTipo_cliente() {
		return tipo_cliente;
	}
	private void setTipo_cliente(String tipo_cliente) {
		this.tipo_cliente = tipo_cliente;
	}
	
}
