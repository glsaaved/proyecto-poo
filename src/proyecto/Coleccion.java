package proyecto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Coleccion {
	public boolean add(Object o);
	public boolean contains(Object o);
	public void deleteAll();
	public boolean deleteAllInstances(Object o);
	public boolean delete(Object o);
	public boolean delete(int i);
	public boolean isEmpty();
	public int size();
	public Object search(int i);
	public Object search(String s);
	public boolean loadFile(File f) throws FileNotFoundException, IOException, loadFileException;
	public boolean saveFile(File f) throws IOException, saveFileException;
}
