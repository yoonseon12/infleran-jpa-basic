package infleranJpaBasic.domain;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public abstract class BaseEntity {
	private String createId;
	private String createDate;
	private String modifiedId;
	private String modifiedDate;
}
