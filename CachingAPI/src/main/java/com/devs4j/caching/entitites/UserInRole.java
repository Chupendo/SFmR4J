package  com.devs4j.caching.entitites;

import java.util.Objects;

import io.micrometer.common.lang.NonNull;
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

@Entity
@Table(name = "user_role")
@Data
@EqualsAndHashCode(exclude = {"user","role"})
public class UserInRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@NonNull public Integer id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	User user;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	Role role;
	
	public UserInRole() {}
	public UserInRole(Integer id, User user, Role role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserInRole)) {
			return false;
		}
		UserInRole other = (UserInRole) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "UserInRole [id=" + id + ", user=" + user + ", role=" + role + "]";
	}
}
