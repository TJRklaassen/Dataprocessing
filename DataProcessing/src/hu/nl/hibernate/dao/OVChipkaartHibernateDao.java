package hu.nl.hibernate.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import hu.nl.hibernate.pojo.OVChipkaart;
import hu.nl.hibernate.pojo.Reiziger;

public class OVChipkaartHibernateDao extends HibernateBaseDao implements OVChipkaartDao {

	@Override
	public List<OVChipkaart> findAll() throws SQLException {
		Session session = getSession();
		List<OVChipkaart> kaarten = session.createQuery("FROM OVChipkaart").list();
		closeSession();
		return kaarten;
	}

	@Override
	public OVChipkaart findByKaartnummer(int nummer) throws SQLException {
		Session session = getSession();
		OVChipkaart ov = session.get(OVChipkaart.class, nummer);
		closeSession();
		return ov;
	}

	@Override
	public List<OVChipkaart> findByKaarthouder(Reiziger kaarthouder) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OVChipkaart save(OVChipkaart ov) throws SQLException {
		Session session = getSession();
		session.save(ov);
		closeSession();
		return ov;
	}

	@Override
	public OVChipkaart update(OVChipkaart ov) throws SQLException {
		Session session = getSession();
		session.update(ov);
		closeSession();
		return ov;
	}

	@Override
	public boolean delete(OVChipkaart ov) throws SQLException {
		try {
			Session session = getSession();
			session.delete(ov);
			closeSession();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
