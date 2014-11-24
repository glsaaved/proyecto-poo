package proyecto;

public class Trabajador extends Persona{
	private String id_trabajador;
	private String cargo;
	private double estatura;
	private double peso;
	private double jornada;
	
	public Trabajador(int rut,char dig_verificador,String nombre,String apellido,int dia,int mes,int año,double jornada,double peso,double estatura)
	{
		super(rut,dig_verificador,nombre,apellido,dia,mes,año);
		this.peso=peso;
		this.estatura=estatura;
		this.jornada=jornada;
	}
	public void setJornada(int a)
	{
		if(a<0||a>23)
			this.jornada=8;
		else
			this.jornada=a;
	}
	public double getEstatura()
	{
		return this.estatura;
	}
	public void setEstatura(double d)
	{
		this.estatura=d;
	}
	public double getPeso()
	{
		return this.peso;
	}
	public void setPeso(double p)
	{
		this.peso=p;
	}
}
