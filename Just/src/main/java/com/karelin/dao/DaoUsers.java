package com.karelin.dao;

import java.util.List;
import org.hibernate.Session;
import com.karelin.entity.Users;
import com.karelin.db.HibernateUtil;

public class DaoUsers implements DaoInterface<Users> {

	@Override
	public void insert(Users ob) {
		Session session = HibernateUtil.getSession();
		session.save(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void update(Users ob) {
		Session session = HibernateUtil.getSession();
		session.update(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void delete(Users ob) {
		Session session = HibernateUtil.getSession();
		session.delete(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public Users get(int id) {
		Session session = HibernateUtil.getSession();
		Users users = session.get(Users.class, id);
		HibernateUtil.deleteSession(session);
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getAll(String sql) {
		Session session = HibernateUtil.getSession();
		List<Users> list = session.createQuery(sql).list();
		HibernateUtil.deleteSession(session);
		return list;
	}
}
