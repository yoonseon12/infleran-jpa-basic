package infleranJpaBasic.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User {
	@Id @GeneratedValue
	private Long id; 
	
	@Column(name = "name") 
	private String username;
	
	private Integer age; 
	
	@Enumerated(EnumType.STRING) 
	private RoleType roleType;
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Date createdDate;
	
	@Temporal(TemporalType.TIMESTAMP) 
	private Date lastModifiedDate;
	
	private LocalDate testLocalDate;
	private LocalDateTime testLocalDateTime;
	
	@Lob 
	private String description; 
	
	public User() {}
	
	public User(Long id, String username, RoleType roleType) {
		this.id = id;
		this.username = username;
		this.roleType = roleType;
	}
}



