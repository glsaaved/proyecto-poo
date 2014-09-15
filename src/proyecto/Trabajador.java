package proyecto;

import java.util.*;

public class Trabajador {
	private String id_trabajador;
	private String cargo;
	private ArrayList<Turno> historial_turnos;;
	private double estatura;
	private double peso;
	
	
	public double getEstatura()
	{
		return this.estatura;
	}
	public double getPeso()
	{
		return this.peso;
	}
}
