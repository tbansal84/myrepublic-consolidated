package services.interview.myrepublic.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.swing.text.html.HTML.Tag;

/**
 * The persistent class for the Customer database table.
 * 
 */
@Entity
@Table(name = "Customer")
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique = true, nullable = false, length = 25)
	private String id;

	@Column(length = 50)
	private String familyname;

	@Column(length = 50)
	private String givenname;

	@Column(nullable = false, length = 50)
	private String middlename;

	@Column(nullable = false, length = 50)
	private String name;

	@Column(length = 8)
	private String postalcode;

	@JoinTable(name = "Customer_PhoneNumbers", joinColumns = {
			@JoinColumn(name = "customer_id") }, inverseJoinColumns = { @JoinColumn(name = "phone_number") })
	private Set<PhoneNumber> numbers = new HashSet<>();

	public Customer() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFamilyname() {
		return this.familyname;
	}

	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}

	public String getGivenname() {
		return this.givenname;
	}

	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public Set<PhoneNumber> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<PhoneNumber> numbers) {
		this.numbers = numbers;
	}

}