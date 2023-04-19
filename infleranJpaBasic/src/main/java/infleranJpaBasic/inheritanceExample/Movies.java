package infleranJpaBasic.inheritanceExample;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("Movie")
public class Movie extends Items {
	private String director;
	private String actor;
}
