package hu.nl.hibernate.dao;

import java.sql.SQLException;
import java.util.List;

import hu.nl.hibernate.pojo.OVChipkaart;
import hu.nl.hibernate.pojo.Reiziger;

public interface OVChipkaartDao {
	public List<OVChipkaart> findAll() throws SQLException;
	public OVChipkaart findByKaartnummer(int nummer) throws SQLException;
	public List<OVChipkaart> findByKaarthouder(Reiziger kaarthouder) throws SQLException;
	public OVChipkaart save(OVChipkaart kaart) throws SQLException;
	public OVChipkaart update(OVChipkaart kaart) throws SQLException;
	public boolean delete(OVChipkaart kaart) throws SQLException;
}
