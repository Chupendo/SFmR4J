package  com.devs4j.caching.entitites;

import java.util.Objects;

import io.micrometer.common.lang.NonNull;
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
@Table(name = "role")
@Data
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"name"})
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@NonNull public Integer id;
	@Column(name="name")
	@NonNull public String name;
	public Role() {}
	
	public Role(String name) {
		this.id=0;
		this.name = name;
	}
	
	public Role(Integer id, String name) {
		this.id = id;
		this.name = name;
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
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Role)) {
			return false;
		}
		Role other = (Role) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}
}
