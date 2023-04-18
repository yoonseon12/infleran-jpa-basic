package infleranJpaBasic.mappedSuperclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class SubEntity extends BaseEntity {
	@Id @GeneratedValue
	private Long Id;
	private String name;
}
