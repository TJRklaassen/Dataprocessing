package dataprocessing.P2;

import java.sql.SQLException;
import java.util.List;

public interface OVChipkaartDao {
	public List<OVChipkaart> findAll() throws SQLException;
	public List<OVChipkaart> findByKaartnummer(int nummer) throws SQLException;
	public List<OVChipkaart> findByKaarthouder(Reiziger kaarthouder) throws SQLException;
	public OVChipkaart save(OVChipkaart kaart) throws SQLException;
	public OVChipkaart update(OVChipkaart kaart) throws SQLException;
	public boolean delete(OVChipkaart kaart) throws SQLException;
}
