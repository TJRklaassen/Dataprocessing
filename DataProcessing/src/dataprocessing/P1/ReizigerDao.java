package dataprocessing.P1;

import java.util.List;

public interface ReizigerDao {
	public List<Reiziger> findAll();
	public List<Reiziger> findByGbdatum(String gbdatum);
	public Reiziger save(Reiziger reiziger);
	public Reiziger update(Reiziger reiziger);
	public boolean delete(Reiziger reiziger);
	public void closeConnection();
}
