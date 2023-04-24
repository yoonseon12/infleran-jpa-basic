package infleranJpaBasic.relationExample;

import java.util.Objects;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class Address {
	private String city;
	private String street;
	private String zipcode;
	
	public Address() {} // 기본 생성자 필수
	
	public Address(String city, String street, String zipcode) {
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, street, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) &&
				Objects.equals(street, other.street) &&
				Objects.equals(zipcode, other.zipcode);
	}




	
	
	
	
	
}
