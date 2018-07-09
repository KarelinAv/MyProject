package com.karelin.dao;

import java.util.List;
import org.hibernate.Session;

import com.karelin.entity.UsersProjects;
import com.karelin.db.HibernateUtil;

public class DaoUsersProjects implements DaoInterface<UsersProjects> {

	@Override
	public void insert(UsersProjects ob) {
		Session session = HibernateUtil.getSession();
		session.save(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void update(UsersProjects ob) {
		Session session = HibernateUtil.getSession();
		session.update(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void delete(UsersProjects ob) {
		Session session = HibernateUtil.getSession();
		session.delete(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public UsersProjects get(int id) {
		Session session = HibernateUtil.getSession();
		UsersProjects usersProjects = session.get(UsersProjects.class, id);
		HibernateUtil.deleteSession(session);
		return usersProjects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersProjects> getAll(String sql) {
		Session session = HibernateUtil.getSession();
		List<UsersProjects> list = session.createQuery(sql).list();
		HibernateUtil.deleteSession(session);
		return list;
	}

}
