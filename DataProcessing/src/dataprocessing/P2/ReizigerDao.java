package dataprocessing.P2;

import java.sql.SQLException;
import java.util.List;

public interface ReizigerDao {
	public List<Reiziger> findAll() throws SQLException;
	public List<Reiziger> findByGbdatum(String gbdatum) throws SQLException;
	public Reiziger save(Reiziger reiziger) throws SQLException;
	public Reiziger update(Reiziger reiziger) throws SQLException;
	public boolean delete(Reiziger reiziger) throws SQLException;
}
