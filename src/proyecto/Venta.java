package proyecto;

import java.util.*;

public class Venta {
	private Fecha_Hora fecha;
	private int total;
	private Trabajador atendido_por;
	private ArrayList productos;
	private boolean valida;
	
	
	
	public ArrayList getProductos() {
		return productos;
	}
	public void setProductos(ArrayList productos) {
		this.productos = productos;
	}
	public boolean isValida() {
		return valida;
	}
	public void setValida(boolean valida) {
		this.valida = valida;
	}
	public int getTotal() {
		return total;
	}
	public Trabajador getAtendido_por() {
		return atendido_por;
	}
	public Fecha_Hora getFecha() {
		return fecha;
	}
	public void setFecha(Fecha_Hora fecha) {
		this.fecha = fecha;
	}

}
