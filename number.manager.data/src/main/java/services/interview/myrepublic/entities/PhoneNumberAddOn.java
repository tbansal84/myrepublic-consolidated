package services.interview.myrepublic.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the CustomerAddOn database table.
 * 
 */
@Entity
@Table(name = "CustomerAddOn")
@NamedQuery(name = "CustomerAddOn.findAll", query = "SELECT c FROM CustomerAddOn c")
public class PhoneNumberAddOn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private long id;

	@Column(length = 50)
	private String addon;

	@Column(name = "created_by")
	private Timestamp createdBy;

	@Column(name = "created_dt")
	private Timestamp createdDt;

	@Column(length = 500)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "addOns")
	private Set<PhoneNumber> numbers = new HashSet<>();

	public PhoneNumberAddOn() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddon() {
		return this.addon;
	}

	public void setAddon(String addon) {
		this.addon = addon;
	}

	public Timestamp getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Timestamp createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDt() {
		return this.createdDt;
	}

	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<PhoneNumber> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<PhoneNumber> numbers) {
		this.numbers = numbers;
	}

}