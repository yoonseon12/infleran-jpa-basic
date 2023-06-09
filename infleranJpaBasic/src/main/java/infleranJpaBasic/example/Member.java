package infleranJpaBasic.example;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
	@Id
	private Long id;
	private String name;
	private int age;
	
	public Member() {}
	
	public Member(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
