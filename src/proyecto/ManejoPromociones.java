package proyecto;

public interface ManejoPromociones {
	public boolean addPromocion(Promocion p);
	public boolean deletePromocion(Promocion p);
	public boolean deletePromocion(int index);
	public Promocion getPromocion(int index);
	public boolean deleteAllPromocion(Promocion p);
	public void deleteAll_();

}
