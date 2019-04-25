package dataprocessing.P2;

import java.util.ArrayList;
import java.util.List;

public class OVChipkaartOracleDao extends OracleBaseDao implements OVChipkaartDao{
	private ArrayList<OVChipkaart> kaartLijst = new ArrayList<OVChipkaart>();
	
	public List<OVChipkaart> findAll() {
		return kaartLijst;
	}

	public List<OVChipkaart> findByKaarthouder(Reiziger kaarthouder) {
		List<OVChipkaart> kaartKaarthouderLijst = new ArrayList<OVChipkaart>();
		
		for(OVChipkaart k : kaartLijst) {
			if(k.getKaarthouder() == kaarthouder) {
				kaartKaarthouderLijst.add(k);
			}
		}
		
		return kaartKaarthouderLijst;
	}

	public OVChipkaart save(OVChipkaart kaart) {
		kaartLijst.add(kaart);
		return kaart;
	}

	public OVChipkaart update(OVChipkaart kaart) {
		for(OVChipkaart k : kaartLijst) {
			if(k.getKaartNummer() == kaart.getKaartNummer()) {
				kaartLijst.set(kaartLijst.indexOf(k), kaart);
			}
		}
		return kaart;
	}

	public boolean delete(OVChipkaart kaart) {
		return kaartLijst.remove(kaart);
	}

}