package com.karelin.entity;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tasks_statuses")
public class TasksStatuses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "label", length = 50, unique = true, nullable = false)
	private String label;

	@OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
	private List<Tasks> list;

	public TasksStatuses() {
	}

	public TasksStatuses(String label) {
		this.label = label;
	}

	public TasksStatuses(int id, String label) {
		this.id = id;
		this.label = label;
	}

	public TasksStatuses(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TasksStatuses [id=" + id + ", label=" + label + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		TasksStatuses other = (TasksStatuses) obj;
		if (id != other.id)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getlabel() {
		return label;
	}

	public void setlabel(String label) {
		this.label = label;
	}

	public List<Tasks> getList() {
		return list;
	}

	public void setList(List<Tasks> list) {
		this.list = list;
	}

}
