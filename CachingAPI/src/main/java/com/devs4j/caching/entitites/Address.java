package  com.devs4j.caching.entitites;

import java.util.Objects;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="address")
@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"street","number","city","profile"})
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@NonNull private Integer id;
	@Column(name="street")
	@NonNull private String street;
	@Column(name="number")
	@NonNull private String number;
	@Column(name="city")
	@NonNull private String city;
	@ManyToOne
	@NonNull private Profile profile;
	
	public Address() {}
	
	public Address(Integer id, String street, String number, String city, Profile profile) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.city = city;
		this.profile = profile;
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
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", number=" + number + ", city=" + city + ", profile="
				+ profile + "]";
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
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
