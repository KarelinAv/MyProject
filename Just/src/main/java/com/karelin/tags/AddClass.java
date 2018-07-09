package com.karelin.tags;

import java.util.Iterator;
import java.util.List;

import com.karelin.dao.DaoUsers;
import com.karelin.entity.Users;

public class AddClass {
	private List<Users> list;
	private Iterator<Users> iter;
	private int count;

	public AddClass() {
		DaoUsers du = new DaoUsers();
		list = du.getAll("FROM Users");
		iter = list.iterator();
		count = list.size();

	}

	public int getCount() {
		return count;
	}

	public String getUsers() {
		if (iter.hasNext()) {
			return iter.next().toString();
		}
		return null;
	}
}
