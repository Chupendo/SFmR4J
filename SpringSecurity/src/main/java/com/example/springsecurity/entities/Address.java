package com.example.springsecurity.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"street","number","city","profile"})
public class Address {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="street")
	@NonNull private String street;
	
	@Column(name="number")
	@NonNull private String number;
	
	@Column(name="city")
	@NonNull private String city;
	
	@ManyToOne
	@JoinColumn(name = "profile_id",referencedColumnName = "id")
	private Profile profile;
	
	
	public Address() {}
}
