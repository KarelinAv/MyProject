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
@Table(name = "users_projects")
public class UsersProjects {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_projects")
	private Projects projects;

	@ManyToOne
	@JoinColumn(name = "id_users")
	private Users users;

	public UsersProjects() {
		
	}

	public UsersProjects(int id, Projects projects, Users users) {
		super();
		this.id = id;
		this.projects = projects;
		this.users = users;
	}

	public UsersProjects(Projects projects, Users users) {
		super();
		this.projects = projects;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
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
		result = prime * result + ((projects == null) ? 0 : projects.hashCode());
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
		UsersProjects other = (UsersProjects) obj;
		if (id != other.id)
			return false;
		if (projects == null) {
			if (other.projects != null)
				return false;
		} else if (!projects.equals(other.projects))
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
		return "UsersProjects [id=" + id + ", projects=" + projects + ", users=" + users + "]";
	}

	
	

	
}
