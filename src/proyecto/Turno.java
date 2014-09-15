package proyecto;

public class Turno {
	private Fecha_Hora entrada;
	private Fecha_Hora salida;
	private double duracion_jornada;
	public Turno(double duracion_jornada)
	{
		if(duracion_jornada>0&&duracion_jornada<24)
			this.duracion_jornada=duracion_jornada;
		else
			this.duracion_jornada=8;
		entrada=new Fecha_Hora();
	}
	public void setEntrada(Fecha_Hora entrada)
	{
		if(entrada!=null&&entrada.isValida())
			this.entrada=entrada;
	}
	public void setSalida(Fecha_Hora salida)
	{
		if(salida !=null&&salida.isValida())
			this.salida=salida;
	}
	public Fecha_Hora getEntrada()
	{
		if(entrada.isValida())
			return entrada;
		else
			return null;
	}
	public Fecha_Hora getSalida()
	{
		if(salida.isValida())
			return salida;
		else
			return null;
	}
	public double trabajado()
	{
		return 0;
	}

}
