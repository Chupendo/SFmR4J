package com.devs4j.jpa.entites;


import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="profile")
@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"first_name","first_name","birth_date"})
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="first_name")
	private String fisrtName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birth_date")
	private Date birthDate;

	public Profile() {} 
	
	public Profile(Integer id, String fisrtName, String lastName, Date birthDate) {
		super();
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.birthDate = birthDate;
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
	 * @return the fisrtName
	 */
	public String getFisrtName() {
		return fisrtName;
	}

	/**
	 * @param fisrtName the fisrtName to set
	 */
	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
		if (!(obj instanceof Profile)) {
			return false;
		}
		Profile other = (Profile) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", fisrtName=" + fisrtName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ "]";
	}
	
	
}
