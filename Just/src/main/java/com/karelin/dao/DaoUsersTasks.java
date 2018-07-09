package com.karelin.dao;

import java.util.List;
import org.hibernate.Session;

import com.karelin.entity.UsersTasks;
import com.karelin.db.HibernateUtil;

public class DaoUsersTasks implements DaoInterface<UsersTasks> {
	@Override
	public void insert(UsersTasks ob) {
		Session session = HibernateUtil.getSession();
		session.save(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void update(UsersTasks ob) {
		Session session = HibernateUtil.getSession();
		session.update(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void delete(UsersTasks ob) {
		Session session = HibernateUtil.getSession();
		session.delete(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public UsersTasks get(int id) {
		Session session = HibernateUtil.getSession();
		UsersTasks usersTasks = session.get(UsersTasks.class, id);
		HibernateUtil.deleteSession(session);
		return usersTasks;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersTasks> getAll(String sql) {
		Session session = HibernateUtil.getSession();
		List<UsersTasks> list = session.createQuery(sql).list();
		HibernateUtil.deleteSession(session);
		return list;
	}
}
