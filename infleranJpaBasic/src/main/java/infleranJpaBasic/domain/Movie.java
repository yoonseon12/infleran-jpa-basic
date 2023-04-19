package infleranJpaBasic.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("Movie")
public class Movie extends Item {
	private String director;
	private String actor;
}
