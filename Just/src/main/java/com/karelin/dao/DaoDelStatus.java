package com.karelin.dao;

import java.util.List;
import org.hibernate.Session;
import com.karelin.entity.DelStatus;
import com.karelin.db.HibernateUtil;

public class DaoDelStatus implements DaoInterface<DelStatus> {

	@Override
	public void insert(DelStatus ob) {
		Session session = HibernateUtil.getSession();
		session.save(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void update(DelStatus ob) {
		Session session = HibernateUtil.getSession();
		session.update(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void delete(DelStatus ob) {
		Session session = HibernateUtil.getSession();
		session.delete(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public DelStatus get(int id) {
		Session session = HibernateUtil.getSession();
		DelStatus delStatus = session.get(DelStatus.class, id);
		HibernateUtil.deleteSession(session);
		return delStatus;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DelStatus> getAll(String sql) {
		Session session = HibernateUtil.getSession();
		List<DelStatus> list = session.createQuery(sql).list();
		HibernateUtil.deleteSession(session);
		return list;
	}
}
