package dataprocessing.P2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ReizigerOracleDaoImpl implements ReizigerDao{
	private ArrayList<Reiziger> reizigerLijst = new ArrayList<Reiziger>();
	
	public List<Reiziger> findAll() {
		return reizigerLijst;
	}

	public List<Reiziger> findByGbdatum(String gbdatum) {
		List<Reiziger> reizigerGbdatumLijst = new ArrayList<Reiziger>();
		
		for(Reiziger r : reizigerLijst) {
			if(r.getGbdatum().equals(Date.valueOf(gbdatum))) {
				reizigerGbdatumLijst.add(r);
			}
		}
		
		return reizigerGbdatumLijst;
	}

	public Reiziger save(Reiziger reiziger) {
		reizigerLijst.add(reiziger);
		return reiziger;
	}

	public Reiziger update(Reiziger reiziger) {
		for(Reiziger r : reizigerLijst) {
			if(r.getReizigerID() == reiziger.getReizigerID()) {
				reizigerLijst.set(reizigerLijst.indexOf(r), reiziger);
			}
		}
		return reiziger;
	}

	public boolean delete(Reiziger reiziger) {
		return reizigerLijst.remove(reiziger);
	}
}
