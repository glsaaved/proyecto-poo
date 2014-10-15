
package proyecto;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class Fecha {
	private int dia;
	private int mes;
	private int año;
	private String mes_1;
	private boolean valida;
	private Calendar fecha;

	//clase que usada para el manejo de una fecha
	//no puede ser mayor al año actual+1
	public Fecha(int dia, int mes, int año)
	{
		setFecha(new GregorianCalendar());
		int año_actual = getFecha().get(Calendar.YEAR);
		if(dia>0&&dia<=31&&mes>0&&mes<=12&&año>1900&&año<=año_actual+1)
		{	
			if(mes==2&&dia>29)
				valida=false;
			else
			{
				this.dia=dia;
				this.mes=mes;
				this.año=año;
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
		año = getFecha().get(Calendar.YEAR);
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
	//metodo para calcular la diferencia en años con la fecha actuali
	public int años_diff()
	{
		int diff;
		int año1 = getFecha().get(Calendar.YEAR);
        int mes1 = getFecha().get(Calendar.MONTH);
        int dia1 = getFecha().get(Calendar.DAY_OF_MONTH);
        if(año1<año)
        	diff=año-año1;
        else
        	diff=año1-año;
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
		int año1 = getFecha().get(Calendar.YEAR);
        int mes1 = getFecha().get(Calendar.MONTH);
        int dia1 = getFecha().get(Calendar.DAY_OF_MONTH);
        if(año1<año)
        {
        	diff=(año-año1-1)*12;
            diff+=mes1;//verificar
            if(dia<=dia1)
            	diff++;
        }
        else if(año==año1)
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
		return dia+" de "+mes_1+", "+año;
	}
	public String getFecha_short()
	{
		return dia+"/"+mes+"/"+(año%100);
	}
	public int getDia() {
		return dia;
	}
	public int getMes() {
		return mes;
	}
	public int getAño() {
		return año;
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
