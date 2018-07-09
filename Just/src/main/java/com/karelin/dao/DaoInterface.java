package com.karelin.dao;

import java.util.List;

public interface DaoInterface <T>{
	
	public abstract void insert(T ob);
	
	public abstract void update(T ob);
	
	public abstract void delete(T ob);
	
	public abstract T get(int id);
	
	public abstract List<T> getAll(String sql);

}
