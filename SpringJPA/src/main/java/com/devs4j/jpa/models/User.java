package com.devs4j.jpa.models;

import io.micrometer.common.lang.NonNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	@NonNull private String userName;
	@NonNull private String userNick;
	@NonNull private String password;
	
	
	public User(String userName, String userNick, String password) {
		super();
		this.userName = userName;
		this.userNick = userNick;
		this.password = password;
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
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userNick=" + userNick + ", password=" + password + "]";
	}
	
}
