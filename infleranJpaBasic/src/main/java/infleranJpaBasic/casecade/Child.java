package infleranJpaBasic.casecade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Child {
	@Id @GeneratedValue
	private Long id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Parent parent;
}
