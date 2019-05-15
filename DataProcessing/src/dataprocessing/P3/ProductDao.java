package dataprocessing.P3;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
	public List<Product> findAll() throws SQLException;
	public List<Product> findByKaart(OVChipkaart kaart) throws SQLException;
	public Product save(Product product) throws SQLException;
	public Product update(Product product) throws SQLException;
	public boolean delete(Product product) throws SQLException;
	List<Product> findAllWithCards() throws SQLException;
}
