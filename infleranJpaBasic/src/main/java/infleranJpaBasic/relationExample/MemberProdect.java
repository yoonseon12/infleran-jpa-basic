package infleranJpaBasic.relationExample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MemberProdect {
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "MEMBER_ID")
	private MemberR member;
	
	@ManyToOne
	@JoinColumn(name = "PRODECT_ID")
	private Product product;
	
}
