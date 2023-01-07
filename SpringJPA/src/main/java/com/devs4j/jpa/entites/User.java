package com.devs4j.jpa.entites;


import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="client")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"username","password"})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id = 0L;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="nick")
	private String userNick;
	
	@Column(name="password")
	private String password;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	public User() {}

	public User(Long id, String userName, String userNick, String password, Role role) {
		super();
		this.id = id;
		this.userName = userName;
		this.userNick = userNick;
		this.password = password;
		this.role = role;
	}
	
	

	public User(String userName, String userNick, String password, Role role) {
		super();
		this.userName = userName;
		this.userNick = userNick;
		this.password = password;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userNick
	 */
	public String getUserNick() {
		return userNick;
	}

	/**
	 * @param userNick the userNick to set
	 */
	public void setUserNick(String userNick) {
		this.userNick = userNick;
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
		return "User [id=" + id + ", userName=" + userName + ", userNick=" + userNick + ", password=" + password
				+ ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

	

}
