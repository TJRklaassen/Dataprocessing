package hu.nl.hibernate.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import hu.nl.hibernate.pojo.OVChipkaart;
import hu.nl.hibernate.pojo.Reiziger;

public class ReizigerHibernateDao extends HibernateBaseDao implements ReizigerDao {

	@Override
	public List<Reiziger> findAll() throws SQLException {
		Session session = getSession();
		List<Reiziger> reizigers = session.createQuery("FROM Reiziger").list();
		closeSession();
		return reizigers;
	}
	
	@Override
	public Reiziger findByReizigerid(int nummer) throws SQLException {
		Session session = getSession();
		Reiziger r = session.get(Reiziger.class, nummer);
		closeSession();
		return r;
	}

	@Override
	public Reiziger save(Reiziger reiziger) throws SQLException {
		Session session = getSession();
		session.save(reiziger);
		closeSession();
		return reiziger;
	}

	@Override
	public Reiziger update(Reiziger reiziger) throws SQLException {
		Session session = getSession();
		session.update(reiziger);
		closeSession();
		return reiziger;
	}

	@Override
	public boolean delete(Reiziger reiziger) throws SQLException {
		try {
			Session session = getSession();
			session.delete(reiziger);
			closeSession();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
