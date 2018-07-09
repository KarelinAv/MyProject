package com.karelin.dao;

import java.util.List;
import org.hibernate.Session;
import com.karelin.entity.Projects;
import com.karelin.db.HibernateUtil;

public class DaoProjects implements DaoInterface<Projects> {

	@Override
	public void insert(Projects ob) {
		Session session = HibernateUtil.getSession();
		session.save(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void update(Projects ob) {
		Session session = HibernateUtil.getSession();
		session.update(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void delete(Projects ob) {
		Session session = HibernateUtil.getSession();
		session.delete(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public Projects get(int id) {
		Session session = HibernateUtil.getSession();
		Projects projects = session.get(Projects.class, id);
		HibernateUtil.deleteSession(session);
		return projects;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projects> getAll(String sql) {
		Session session = HibernateUtil.getSession();
		List<Projects> list = session.createQuery(sql).list();
		HibernateUtil.deleteSession(session);
		return list;
	}

}
