package pl.wb.crud.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="user_without_security")
public class User {

	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;

	// UTC date and time when account was created
	@Column(name="account_creation_date")
	private LocalDateTime accountCreationDate = Instant.now().atOffset(ZoneOffset.UTC).toLocalDateTime();
	
	public User (int id, String firstName, String lastName, String email, LocalDateTime accountCreationDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.accountCreationDate = accountCreationDate;
	}

	public User (String firstName, String lastName, String email, LocalDateTime accountCreationDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.accountCreationDate = accountCreationDate;
	}
	public User (String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String toString () {
		return "UserDao{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", accountCreationDate=" + localDateTimeToString(accountCreationDate) +
				'}';
	}

	private String localDateTimeToString(LocalDateTime accountCreationDate){

		// Custom format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		// Format LocalDateTime
		return accountCreationDate.format(formatter);
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		if (id != user.id) return false;
		if (!firstName.equals(user.firstName)) return false;
		if (!lastName.equals(user.lastName)) return false;
		if (!email.equals(user.email)) return false;
		return accountCreationDate.equals(user.accountCreationDate);
	}

	@Override
	public int hashCode () {
		int result = id;
		result = 31 * result + firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + email.hashCode();
		result = 31 * result + accountCreationDate.hashCode();
		return result;
	}
}











