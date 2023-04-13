package infleranJpaBasic.relationExample;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {
	@Id @GeneratedValue
	@Column(name = "TEAM_ID")
	private Long id;
	
	public void addMember(MemberR member) {
		member.setTeam(this);
		members.add(member);
	}
	
	private String name;
	
	@OneToMany(mappedBy = "team") // Member클래스의 관계 맺어져있는 변수명
	private List<MemberR> members = new ArrayList<>(); // 초기화해두는 것은 관례이다. add할때 NPE방지 
	
}
