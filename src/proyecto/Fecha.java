
package proyecto;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Fecha {
	private int dia;
	private int mes;
	private int a�o;
	private String mes_1;
	private boolean valida;
	private Calendar fecha;

	//clase que usada para el manejo de una fecha
	//no puede ser mayor al a�o actual+1
	public Fecha(int dia, int mes, int a�o)
	{
		setFecha(new GregorianCalendar());
		int a�o_actual = getFecha().get(Calendar.YEAR);
		if(dia>0&&dia<=31&&mes>0&&mes<=12&&a�o>1900&&a�o<=a�o_actual+1)
		{	
			if(mes==2&&dia>29)
				valida=false;
			else
			{
				this.dia=dia;
				this.mes=mes;
				this.a�o=a�o;
				asignar_mes();
				valida=true;
			}
		}
		else
			valida=false;
	}
	public Fecha()
	{
		setFecha(new GregorianCalendar());
		a�o = getFecha().get(Calendar.YEAR);
        mes = getFecha().get(Calendar.MONTH);
        dia = getFecha().get(Calendar.DAY_OF_MONTH);
        asignar_mes();
        valida=true;
	}
	//asigna el mes con su correspondiente string
	private void asignar_mes()
	{
		if(mes==1)
			mes_1="Enero";
		else if(mes==2)
			mes_1="Febrero";
		else if(mes==3)
			mes_1="Marzo";
		else if(mes==4)
			mes_1="Abril";
		else if(mes==5)
			mes_1="Mayo";
		else if(mes==6)
			mes_1="Junio";
		else if(mes==7)
			mes_1="Julio";
		else if(mes==8)
			mes_1="Agosto";
		else if(mes==9)
			mes_1="Septiembre";
		else if(mes==10)
			mes_1="Octubre";
		else if(mes==11)
			mes_1="Noviembre";
		else if(mes==12)
			mes_1="Diciembre";
	}
	//metodo para calcular la diferencia en a�os con la fecha actuali
	public int a�os_diff()
	{
		int diff;
		int a�o1 = getFecha().get(Calendar.YEAR);
        int mes1 = getFecha().get(Calendar.MONTH);
        int dia1 = getFecha().get(Calendar.DAY_OF_MONTH);
        if(a�o1<a�o)
        	diff=a�o-a�o1;
        else
        	diff=a�o1-a�o;
        if(mes1<mes)
        	diff--;
        else if(mes1==mes)
        {
        	if(dia1<dia)
        		diff--;
        }
        if(diff<0)
        	diff=0;
		return diff;
	}
	//metodo para calcular la diferencia en meses de 2 fechas, la fecha guardada debe ser menor a la actual
	public int mes_diff_menor()
	{
		int diff;
		int a�o1 = getFecha().get(Calendar.YEAR);
        int mes1 = getFecha().get(Calendar.MONTH);
        int dia1 = getFecha().get(Calendar.DAY_OF_MONTH);
        if(a�o1<a�o)
        {
        	diff=(a�o-a�o1-1)*12;
            diff+=mes1;//verificar
            if(dia<=dia1)
            	diff++;
        }
        else if(a�o==a�o1)
        {
        	if(mes>mes1)
        		diff=-1;
        	else
        	{
        		diff=mes1-mes;
        		if(dia<=dia1)
        			diff++;
        		
        	}
        }
        else
        	diff=-1;

		return diff;
	}
	public String getFecha_long()
	{
		return dia+" de "+mes_1+", "+a�o;
	}
	public String getFecha_short()
	{
		return dia+"/"+mes+"/"+(a�o%100);
	}
	public int getDia() {
		return dia;
	}
	public int getMes() {
		return mes;
	}
	public int getA�o() {
		return a�o;
	}
	public String getMes_String() {
		return mes_1;
	}
	public boolean isValida() {
		return valida;
	}
	public void setValida()
	{
		if(valida)
			valida=false;
		else
			valida=true;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
}
