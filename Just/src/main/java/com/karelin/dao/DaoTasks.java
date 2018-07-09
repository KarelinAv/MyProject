package com.karelin.dao;

import java.util.List;
import org.hibernate.Session;

import com.karelin.entity.Tasks;
import com.karelin.db.HibernateUtil;

public class DaoTasks implements DaoInterface<Tasks> {

	@Override
	public void insert(Tasks ob) {
		Session session = HibernateUtil.getSession();
		session.save(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void update(Tasks ob) {
		Session session = HibernateUtil.getSession();
		session.update(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void delete(Tasks ob) {
		Session session = HibernateUtil.getSession();
		session.delete(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public Tasks get(int id) {
		Session session = HibernateUtil.getSession();
		Tasks tasks = session.get(Tasks.class, id);
		HibernateUtil.deleteSession(session);
		return tasks;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tasks> getAll(String sql) {
		Session session = HibernateUtil.getSession();
		List<Tasks> list = session.createQuery(sql).list();
		HibernateUtil.deleteSession(session);
		return list;
	}

}
