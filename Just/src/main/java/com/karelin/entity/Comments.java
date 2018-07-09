package com.karelin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "comments")
public class Comments {
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

	@Column(name = "message", length = 250, unique = false)
	private String message;

	@Temporal(TemporalType.DATE)
	private Date date;

	


	public Comments() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
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
		Comments other = (Comments) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", message=" + message + ", date=" + date + "]";
	}

	public Comments(int id, Tasks tasks, Users users, String message, Date date) {
		super();
		this.id = id;
		this.tasks = tasks;
		this.users = users;
		this.message = message;
		this.date = date;
	}
	public Comments(int id) {
		this.id = id;
	}
	public Comments(Tasks tasks, Users users, String message, Date date) {
		super();
		this.tasks = tasks;
		this.users = users;
		this.message = message;
		this.date = date;
	}

	public Comments(int id, String message, Date date) {
		super();
		this.id = id;
		this.message = message;
		this.date = date;
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

}
