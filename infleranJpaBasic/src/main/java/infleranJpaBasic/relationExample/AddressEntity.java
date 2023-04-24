package infleranJpaBasic.relationExample;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="ADDRESS")
public class AddressEntity {
	@Id @GeneratedValue
	private Long id;
	
	@Embedded
	private Address address;
	
	public AddressEntity(String city, String street, String zipcode) {
		this.address = new Address(city, street, zipcode);
	}

	public AddressEntity(Address address) {
		this.address = address;
	}
			
	
	
}

