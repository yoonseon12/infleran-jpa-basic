package infleranJpaBasic.relationExample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;
	private String name;
	
	@OneToMany
	@JoinColumn(name = "TEAM_ID")
	private List<MemberR> members = new ArrayList<>(); 
	
}
