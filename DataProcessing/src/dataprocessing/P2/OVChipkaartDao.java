package dataprocessing.P2;

import java.util.List;

public interface OVChipkaartDao {
	public List<OVChipkaart> findAll();
	public List<OVChipkaart> findByKaarthouder(Reiziger kaarthouder);
	public OVChipkaart save(OVChipkaart kaart);
	public OVChipkaart update(OVChipkaart kaart);
	public boolean delete(OVChipkaart kaart);
}
