package infleranJpaBasic.inheritanceExample;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("Album")
public class Album extends Items {
	private String artist;
}
