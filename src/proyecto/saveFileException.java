package proyecto;

public class saveFileException extends Exception {
	public saveFileException()
	{
		super("Error al guardar Archivo: Nombre invalido o no tiene permisos para escribir aquí");
	}
}
