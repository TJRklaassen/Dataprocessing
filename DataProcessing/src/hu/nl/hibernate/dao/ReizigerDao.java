package hu.nl.hibernate.dao;

import java.sql.SQLException;
import java.util.List;

import hu.nl.hibernate.pojo.Reiziger;

public interface ReizigerDao {
	public List<Reiziger> findAll() throws SQLException;
	public Reiziger save(Reiziger reiziger) throws SQLException;
	public Reiziger update(Reiziger reiziger) throws SQLException;
	public boolean delete(Reiziger reiziger) throws SQLException;
	Reiziger findByReizigerid(int nummer) throws SQLException;
}
