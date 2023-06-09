package infleranJpaBasic.inheritanceExample;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("Movies")
public class Movies extends Items {
	private String director;
	private String actor;
}
