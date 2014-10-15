package proyecto;

import java.util.Calendar;

public class Fecha_Hora extends Fecha {

	private int hora;
	private int minuto;
	private int segundo;
	public Fecha_Hora(int dia, int mes, int año, int hora,int minuto,int segundo) {
		super(dia, mes, año);
		if(isValida())
		{
			if(hora>=0&&hora<24&&minuto>=0&&minuto<60&&segundo>=0&&segundo<60)
			{
				this.hora=hora;
				this.minuto=minuto;
				this.segundo=segundo;
			}
			else
				setValida();
		}
	}
	public Fecha_Hora()
	{
		super();
		this.hora=getFecha().get(Calendar.HOUR);
		this.minuto=getFecha().get(Calendar.MINUTE);
		this.segundo=getFecha().get(Calendar.SECOND);
		if(!isValida())
		{
			setValida();
		}
	}
	public int getHora() {
		return hora;
	}
	public int getMinuto() {
		return minuto;
	}
	public int getSegundo() {
		return segundo;
	}
	public String getHora_String()
	{
		return hora+":"+minuto+":"+segundo;
	}
	public String getFecha_long()
	{
		return getDia()+" de "+getMes_String()+", "+getAño()+" -HORA: "+getHora_String();
	}
	public String getFecha_short()
	{
		return getDia()+"/"+getMes()+"/"+(getAño()%100)+" - "+getHora_String();
	}

}
