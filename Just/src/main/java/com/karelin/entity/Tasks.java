package com.karelin.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tasks")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "description", length = 3000, unique = true, nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "status")
	private TasksStatuses status;

	@OneToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
	private List<Comments> list;

	@ManyToOne
	@JoinColumn(name = "id_projects")
	private Projects projects;

	@OneToMany(mappedBy = "tasks", fetch = FetchType.LAZY)
	private List<UsersTasks> tasks;

	@Temporal(TemporalType.DATE)
	private Date date;

	public Tasks() {

	}

	public Tasks(String description, Projects projects, Date date) {
		this.description = description;
		this.projects = projects;
		this.date = date;
	}

	public Tasks(String description, TasksStatuses status, Projects projects, Date date) {
		super();
		this.description = description;
		this.status = status;
		this.projects = projects;
		this.date = date;
	}

	public Tasks(int id, List<Comments> list, Projects projects, Date date) {
		super();
		this.id = id;
		this.list = list;
		this.projects = projects;
		this.date = date;
	}

	public Tasks(int id) {
		this.id = id;
	}

	public Tasks(List<Comments> list, Projects projects, Date date) {
		super();
		this.list = list;
		this.projects = projects;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Comments> getList() {
		return list;
	}

	public void setList(List<Comments> list) {
		this.list = list;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	public Date getDate() {
		return date;
	}

	public TasksStatuses getStatus() {
		return status;
	}

	public void setStatus(TasksStatuses status) {
		this.status = status;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
		result = prime * result + ((projects == null) ? 0 : projects.hashCode());
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
		Tasks other = (Tasks) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		if (projects == null) {
			if (other.projects != null)
				return false;
		} else if (!projects.equals(other.projects))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tasks [id=" + id + ", list=" + list + ", projects=" + projects + ", date=" + date + "]";
	}

}
