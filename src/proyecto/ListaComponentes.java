package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaComponentes extends Lista {

	public ListaComponentes()
	{
		super();
	}
	@Override
	public Object search(String sku)
	{
		if(sku!=null)
		{
			for(int i=0;i<super.size();i++)
			{
				Componente c=(Componente)super.search(i);
				if(c!=null&&c.getSku().equalsIgnoreCase(sku))
					return c;
			}
		}
		return null;
	}
	public int getTotal() {
		int total=0;
		for(int i=0;i<super.size();i++)
		{
			total+=((Componente)super.search(i)).getTotal();
		}
		return total;
	}
	/**
	public boolean cargarArchivo(ListaComponentes p) throws FileNotFoundException, IOException
	{
	    try(BufferedReader br = new BufferedReader(new FileReader("promociones.txt"))) {
	        String line = br.readLine();
	        String productos=br.readLine();
	        while (line != null&&productos!=null) {
	        	String s[]= line.split(",");
	        	String prod[]=productos.split(",");
	        	
				if(s.length>=2)
	        	{
						Promocion promo=new Promocion(Integer.parseInt(s[0]),s[1]);
						if(promo!=null)
							{
								
					        	for(int i=0;i<prod.length;i++)
					        	{
					        		Producto aux=p.buscarProducto(prod[i]);
					        		if(aux!=null)
					        			promo.addProducto(aux);
					        	}
					        	promociones.add(promo);
							}
	        	}
	            line = br.readLine();
	            productos=br.readLine();
	        }
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.toString());
	    	return false;
	    }
	    return true;
	}
	 * @throws loadFileException **/
	public boolean loadFile(File f) throws FileNotFoundException, IOException, loadFileException
	{
	    try(BufferedReader br = new BufferedReader(new FileReader(f))) {
	        String line = br.readLine();
	        if(line !=null&&line.equalsIgnoreCase("promocion"))	
	        {   
	        	line = br.readLine();
	        	String productos=br.readLine();
	        	productos.replaceAll("\\s+","");
	        while (line != null&&productos!=null) {
	        	String s[]= line.split(",");
	        	String prod[]=productos.split(",");
	        	
				if(s.length>=2)
	        	{
						Promocion promo=new Promocion(Integer.parseInt(s[0]),s[1],s[2]);
						if(promo!=null)
							{
								
					        	for(int i=0;i<prod.length;i++)
					        	{
					        		Componente aux= (Componente)search(prod[i]);
					        		if(aux!=null)
					        			promo.add(aux);
					        	}
					        	super.add(promo);
							}
	        	}
	            line = br.readLine();
	            productos=br.readLine();
	        }
	        }
	        else if(line !=null&&line.equalsIgnoreCase("producto"))
	        {
	        	line=br.readLine();
	        	while (line != null) {
	        		String s[]= line.split(",");
	        		if(s.length>=4)
	        		{
	        		Producto p1=new Producto(s[0],s[1],Integer.parseInt(s[2]),Integer.parseInt(s[3]),Integer.parseInt(s[4]));
	        		if(p1!=null)
	        		super.add(p1);
	        		}
	        		line = br.readLine();
	        		}
	        }
	        console();
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.toString());
	    	return false;
	    }
	    return true;
	}
	public String listar()
	{
		String s="";
		for(int i=0;i<super.size();i++)
		{
			Componente c=(Componente)super.search(i);
			if(c!=null)
				s+="\n"+c.describe();
				
		}
		return s;
	}
	public void console()
	{
		System.out.println(listar());
	}
	public boolean saveFile(File f) throws saveFileException {
		return false;
		// TODO Auto-generated method stub
		
	}

}
