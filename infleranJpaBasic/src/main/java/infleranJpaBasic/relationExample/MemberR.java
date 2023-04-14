package infleranJpaBasic.relationExample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class MemberR {
	@Id @GeneratedValue
	private Long id;
	
	@Column(name = "USERNAME")
	private String username;
	
	@ManyToOne
	@JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
	private Team team;
	
	@OneToOne
	@JoinColumn(name="LOCKER_ID")
	private Locker locker;
	
	@OneToMany(mappedBy = "product")
	private List<MemberProdect> members = new ArrayList<>();
}
