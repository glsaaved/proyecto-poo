package proyecto;

public class ProductoException extends Exception{
	public ProductoException()
	{
		super("Error 01: Es un producto unico no una promocion");
	}
}
