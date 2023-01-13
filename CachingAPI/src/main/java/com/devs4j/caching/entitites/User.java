package com.devs4j.caching.entitites;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "client")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	@Column(name="name_user", length = 40, nullable = false, unique = false)
	private String name;
	//@Column(name="nick", length = 40, nullable = false, unique = true)
	@Column(name="nick", length = 40, nullable = false, unique = false)
	private String nick;
	@Column(name="password", length = 40, nullable = false, unique = false)
	private String password;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	Role role;
	public User() {
		this.id=0;
	}
	
	public User(String name, String nick, String password,Role role) {
		this.id = 0;
		this.name = name;
		this.nick = nick;
		this.password = password;
		this.role = role;
	}
	
	public User(Integer id,String name, String nick, String password, Role role) {
		this.id = id;
		this.name = name;
		this.nick = nick;
		this.password = password;
		this.role = role;
	}
	

	
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nick
	 */
	public String getNick() {
		return nick;
	}

	/**
	 * @param nick the nick to set
	 */
	public void setNick(String nick) {
		this.nick = nick;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", nick=" + nick + ", password=" + password 
				+ ", role=" + role + "]";
	}
	
	
}
