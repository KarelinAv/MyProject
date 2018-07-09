package com.karelin.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "login", length = 30, unique = true, nullable = false)
	private String login;

	@Column(name = "password", length = 30, nullable = false)
	private String password;

	@Column(name = "email", length = 30, unique = true, nullable = false)
	private String email;

	@ManyToOne
	@JoinColumn(name = "roles")
	private Roles roles;

	@ManyToOne
	@JoinColumn(name = "del_status")
	private DelStatus del_status;

	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<Projects> list4;

	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<UsersTasks> list1;

	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<UsersProjects> list2;

	@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
	private List<Comments> list3;

	public Users() {
	}

	public Users(int id, String login, String password, String email, Roles roles, DelStatus del_status) {

		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.del_status = del_status;
	}
	public Users(int id) {
		this.id = id;
	}
	public Users(String login, String password, String email, Roles roles, DelStatus del_status) {

		this.login = login;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.del_status = del_status;
	}

	public Users(String login, String password, String email) {

		this.login = login;
		this.password = password;
		this.email = email;
		this.del_status = new DelStatus(1);
		this.roles = new Roles(1);
	}

	public Users(String login, String password, String email, Roles roles) {

		this.login = login;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.del_status= new DelStatus(1);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Roles getRoles() {
		return roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public Boolean isRole(String role) {
		return this.roles.getType().equals(role);
		// return Arrays.asList(this.roles).contains(role);
	}

	public DelStatus getDel_status() {
		return del_status;
	}

	public void setDel_status(DelStatus del_status) {
		this.del_status = del_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((del_status == null) ? 0 : del_status.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
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
		Users other = (Users) obj;
		if (del_status == null) {
			if (other.del_status != null)
				return false;
		} else if (!del_status.equals(other.del_status))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + ", roles="
				+ roles + ", del_status=" + del_status + "]";
	}

}
