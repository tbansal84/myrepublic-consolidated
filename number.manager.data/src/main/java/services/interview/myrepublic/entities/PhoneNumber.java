package services.interview.myrepublic.entities;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.swing.text.html.HTML.Tag;

@Entity
@Table(name = "PhoneNumbers")
@NamedQuery(name = "PhoneNumber.findAll", query = "SELECT p FROM PhoneNumber p")
public class PhoneNumber extends AuditEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, length = 12)
	private String number;

	@Column(name = "created_by", nullable = false, length = 25)
	private String createdBy;

	@Column(name = "created_tm", nullable = false)
	private Timestamp createdTm;

	// bi-directional many-to-one association to NumberStatus
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "status", nullable = false)
	private NumberStatus status;

	@Version
	private Integer version;

	@JoinTable(name = "Number_Addon", joinColumns = { @JoinColumn(name = "phone_number") }, inverseJoinColumns = {
			@JoinColumn(name = "addon_id") })
	private Set<CustomerAddOn> addOns = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "numbers")
	private Set<Customer> numbers = new HashSet<>();

	public PhoneNumber() {
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTm() {
		return createdTm;
	}

	public void setCreatedTm(Timestamp createdTm) {
		this.createdTm = createdTm;
	}

	public NumberStatus getStatus() {
		return status;
	}

	public void setStatus(NumberStatus status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Set<CustomerAddOn> getAddOns() {
		return addOns;
	}

	public void setAddOns(Set<CustomerAddOn> addOns) {
		this.addOns = addOns;
	}

	public Set<Customer> getNumbers() {
		return numbers;
	}

	public void setNumbers(Set<Customer> numbers) {
		this.numbers = numbers;
	}

}
