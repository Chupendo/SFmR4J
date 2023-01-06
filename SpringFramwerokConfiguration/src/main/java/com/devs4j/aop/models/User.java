package com.devs4j.aop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class User {

	@NonNull
	private String nickName;
	@NonNull
	private String username;
	@NonNull
	private String password;
	
	public User(@NonNull String nickName, @NonNull String username, @NonNull String password) {
		super();
		this.nickName = nickName;
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "User [nickName=" + nickName + ", username=" + username + ", password=" + password + "]";
	}
}
