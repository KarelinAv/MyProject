package com.karelin.dao;

import java.util.List;
import org.hibernate.Session;

import com.karelin.entity.TasksStatuses;
import com.karelin.db.HibernateUtil;

public class DaoTasksStatuses implements DaoInterface<TasksStatuses> {

	@Override
	public void insert(TasksStatuses ob) {
		Session session = HibernateUtil.getSession();
		session.save(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void update(TasksStatuses ob) {
		Session session = HibernateUtil.getSession();
		session.update(ob);
		HibernateUtil.deleteSession(session);

	}

	@Override
	public void delete(TasksStatuses ob) {
		Session session = HibernateUtil.getSession();
		session.delete(ob);
		HibernateUtil.deleteSession(session);
	}

	@Override
	public TasksStatuses get(int id) {
		Session session = HibernateUtil.getSession();
		TasksStatuses TasksStatuses = session.get(TasksStatuses.class, id);
		HibernateUtil.deleteSession(session);
		return TasksStatuses;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TasksStatuses> getAll(String sql) {
		Session session = HibernateUtil.getSession();
		List<TasksStatuses> list = session.createQuery(sql).list();
		HibernateUtil.deleteSession(session);
		return list;
	}

}
