package com.example.springsecurity.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Table(name="profile")
@Data
@ToString
@EqualsAndHashCode(exclude = {"id","birthDate","user"})
@AllArgsConstructor
public class Profile {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="first_name")
	@NonNull private String firstName;
	
	@Column(name="last_name")
	@NonNull private String lastName;
	
	@Column(name="birth_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "YYYMMDD")
	@NonNull private Date birthDate;
	
	@OneToOne
	@JoinColumn(name="user_id",referencedColumnName = "id")
	User user;
	
	public Profile() {}
	
	public Profile(Profile p) {
		this.id=p.id;
		this.firstName=p.getFirstName();
		this.lastName=p.getLastName();
		this.birthDate=p.getBirthDate();
		this.user=p.getUser();
	}
	
	
}
