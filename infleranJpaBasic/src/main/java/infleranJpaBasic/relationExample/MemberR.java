package infleranJpaBasic.relationExample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class MemberR {
	@Id @GeneratedValue
	@Column(name="MEMBER_ID")
	private Long id;
	@Column
	private String username;
	@Embedded
	private Period workPeriod;
	@Embedded
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="city",
						column = @Column(name="WORK_CITY")),
		@AttributeOverride(name="street",
						column = @Column(name="WORK_STREET")),
		@AttributeOverride(name="zipcode",
						column = @Column(name="WORK_ZIPCODE"))
	})
	private Address workAddress;
	
	@ElementCollection
	@CollectionTable(name="FAVORITY_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
	@Column(name = "FOOD_NAME")
	private Set<String> favorityFoods = new HashSet<>();
	
//	@ElementCollection
//	@CollectionTable(name="ADDRESS", joinColumns = @JoinColumn(name="MEMBER_ID"))
//	private List<Address> addressHistory = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "MEMBER_ID")
	private List<AddressEntity> addressHistory = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEAM_ID", insertable = false, updatable = false)
	private Team team;
	
	@OneToOne
	@JoinColumn(name="LOCKER_ID")
	private Locker locker;
	
	@OneToMany(mappedBy = "product")
	private List<MemberProdect> members = new ArrayList<>();
	
}
