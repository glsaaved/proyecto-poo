package proyecto;

public class loadFileException extends Exception {
	public loadFileException()
	{
		super("Error al cargar Archivo: Archivo inválido o formato erróneo");
	}
}
