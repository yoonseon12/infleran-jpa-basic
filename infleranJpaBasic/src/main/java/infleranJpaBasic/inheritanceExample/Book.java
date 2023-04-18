package infleranJpaBasic.inheritanceExample;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@DiscriminatorValue("Book")
public class Book extends Items {
	private String author;
	private String isbn;
}
