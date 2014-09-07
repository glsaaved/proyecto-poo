package proyecto;

public abstract class Persona {
	private String rut;
	private String nombre;
	private String apellido;
	private Fecha fecha_nacimiento;
	private char sexo;
	private double estatura;
	private double peso;
	public Persona(int rut,char dig_verificador,String nombre,String apellido,int dia,int mes,int a�o,char sexo,double estatura,double peso){
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_nacimiento=new Fecha(dia,mes,a�o);
		if(sexo=='F'||sexo=='M')
			this.sexo=sexo;
		else
			this.sexo='_';
		this.estatura=estatura;
		this.peso=peso;
	}
	public Persona(int rut,char dig_verificador,String nombre,String apellido,int dia,int mes,int a�o,char sexo){
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_nacimiento=new Fecha(dia,mes,a�o);
		if(sexo=='F'||sexo=='M'||sexo=='m'||sexo=='f')
			this.sexo=sexo;
		else
			this.sexo='_';
		this.estatura=0;
		this.peso=0;
	}
	public Persona(int rut,char dig_verificador,String nombre,String apellido,int dia,int mes,int a�o){
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_nacimiento=new Fecha(dia,mes,a�o);
		this.sexo='_';
		this.estatura=0;
		this.peso=0;
	}
	public char getSexo()
	{
		return this.sexo;
	}
	public String getSexo_Completo()
	{
		if(this.sexo=='m'||this.sexo=='M')
			return "Masculino";
		else if(this.sexo=='f'||this.sexo=='F')
			return "Femenino";
		else
			return "Inv�lido";
	}
	public String getRut()
	{
		return rut;
	}
	public String getNombre_Completo()
	{
		return nombre+" "+apellido; 
	}
	public int getEdad()
	{
		return fecha_nacimiento.a�os_diff();
	}
	public Fecha getFecha()
	{
		return this.fecha_nacimiento;
	}
	public double getEstatura()
	{
		return this.estatura;
	}
	public double getPeso()
	{
		return this.peso;
	}
}
