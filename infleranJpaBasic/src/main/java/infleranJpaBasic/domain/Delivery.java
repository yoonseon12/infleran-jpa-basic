package infleranJpaBasic.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {
	@Id @GeneratedValue
	private Long id;
	
	private String city;
	
	private String street;
	
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	@OneToOne(mappedBy = "delivery")
	private Order order;
}
