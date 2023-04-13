package infleranJpaBasic.relationExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class MemberR {
	@Id @GeneratedValue
	private Long id;
	
	@Column(name = "USERNAME")
	private String username;

//	@Column(name = "TEAM_ID")
//	private Long teamId;
	
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
}
