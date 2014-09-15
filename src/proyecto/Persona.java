package proyecto;

public abstract class Persona {
	private String rut;
	private String nombre;
	private String apellido;
	private Fecha fecha_nacimiento;
	private char sexo;

	public Persona(int rut,char dig_verificador,String nombre,String apellido,int dia,int mes,int a�o,char sexo){
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_nacimiento=new Fecha(dia,mes,a�o);
		if(sexo=='F'||sexo=='M'||sexo=='m'||sexo=='f')
			this.sexo=sexo;
		else
			this.sexo='_';
	}
	public Persona(int rut,char dig_verificador,String nombre,String apellido,int dia,int mes,int a�o){
		this.nombre=nombre;
		this.apellido=apellido;
		this.fecha_nacimiento=new Fecha(dia,mes,a�o);
		this.sexo='_';
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
	public Fecha getFechaNacimiento()
	{
		return this.fecha_nacimiento;
	}

}
