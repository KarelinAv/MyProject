package com.karelin.dao;

import java.util.List;
import org.hibernate.Session;
import com.karelin.db.HibernateUtil;
import com.karelin.entity.Roles;

public class DaoRoles implements DaoInterface<Roles> {

	@Override
	public void insert(Roles ob) {
		Session session = HibernateUtil.getSession();
		session.save(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public void update(Roles ob) {
		Session session = HibernateUtil.getSession();
		session.update(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public void delete(Roles ob) {
		Session session = HibernateUtil.getSession();
		session.delete(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public Roles get(int id) {
		Session session = HibernateUtil.getSession();
		Roles roles = session.get(Roles.class, id);
		HibernateUtil.deleteSession(session);
		return roles;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getAll(String sql) {
		Session session = HibernateUtil.getSession();
		List<Roles> list = session.createQuery(sql).list();
		HibernateUtil.deleteSession(session);
		return list;
	}

}