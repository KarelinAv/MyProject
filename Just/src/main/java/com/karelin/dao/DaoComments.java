package com.karelin.dao;

import java.util.List;
import org.hibernate.Session;
import com.karelin.entity.Comments;
import com.karelin.db.HibernateUtil;

public class DaoComments implements DaoInterface<Comments> {

	@Override
	public void insert(Comments ob) {
		Session session = HibernateUtil.getSession();
		session.save(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void update(Comments ob) {
		Session session = HibernateUtil.getSession();
		session.update(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void delete(Comments ob) {
		Session session = HibernateUtil.getSession();
		session.delete(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public Comments get(int id) {
		Session session = HibernateUtil.getSession();
		Comments comments = session.get(Comments.class, id);
		HibernateUtil.deleteSession(session);
		return comments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comments> getAll(String sql) {
		Session session = HibernateUtil.getSession();
		List<Comments> list = session.createQuery(sql).list();
		HibernateUtil.deleteSession(session);
		return list;
	}

}
