package spring.berrekate.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "username"),
				@UniqueConstraint(columnNames = "email")
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 100)
	private String name;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@Size(max = 50)
	private String city;

	@Size(max = 50)
	private String country;

	@Size(max = 20)
	private String telephone;

	private Date created;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ImageModel> userProfileImages = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Comment> userComments = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reservation> reservations = new HashSet<>();

	public User(String name, String telephone, String city, String country, String username, String email, String encode, Date date) {
		this.name=name;
		this.telephone=telephone;
		this.city=city;
		this.country=country;
		this.username=username;
		this.email=email;
		this.password=encode;
		this.created=date;
	}

	public User(long id, String name, String telephone, String city, String country, String username, String email, String password, Date created) {
		this.id=id;
		this.name=name;
		this.telephone=telephone;
		this.city=city;
		this.country=country;
		this.username=username;
		this.email=email;
		this.password=password;
		this.created=created;
	}
}
