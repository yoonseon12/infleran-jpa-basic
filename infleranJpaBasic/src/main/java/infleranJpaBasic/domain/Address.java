package infleranJpaBasic.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter(value = AccessLevel.PROTECTED)
public class Address {

	@Column(length = 10)
	private String city;
	@Column(length = 20)
	private String street;
	@Column(length = 5)
	private String zipcode;

	public String fullAddress() {
		return getCity() + " " + getStreet() + " " + getZipcode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) &&
				Objects.equals(street, other.street)&&
				Objects.equals(zipcode, other.zipcode);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(city, street, zipcode);
	}
	
	
}
