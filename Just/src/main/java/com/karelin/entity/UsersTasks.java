package com.karelin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_tasks")
public class UsersTasks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_tasks")
	private Tasks tasks;


	@ManyToOne
	@JoinColumn(name = "id_users")
	private Users users;
	
	public UsersTasks() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tasks getTasks() {
		return tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersTasks other = (UsersTasks) obj;
		if (id != other.id)
			return false;
		if (tasks == null) {
			if (other.tasks != null)
				return false;
		} else if (!tasks.equals(other.tasks))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsersTasks [id=" + id + ", tasks=" + tasks + ", users=" + users + "]";
	}

	public UsersTasks(int id, Tasks tasks, Users users) {
		super();
		this.id = id;
		this.tasks = tasks;
		this.users = users;
	}

	public UsersTasks(Tasks tasks, Users users) {
		super();
		this.tasks = tasks;
		this.users = users;
	}

	
	
	
}
