package proyecto;

public interface ManejoTrabajadores {
	public boolean addTrabajador(Trabajador t);
	public boolean deleteTrabajador(Trabajador t);
	public boolean deleteTrabajador(int index);
	public Trabajador getTrabajador(int index);
	public int getTrabajador(Trabajador p);

}
