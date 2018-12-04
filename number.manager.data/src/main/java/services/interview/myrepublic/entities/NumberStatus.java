package services.interview.myrepublic.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the NumberStatus database table.
 * 
 */
@Entity
@Table(name="NumberStatus")
@NamedQuery(name="NumberStatus.findAll", query="SELECT n FROM NumberStatus n")
public class NumberStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false, length=20)
	private String status;

	@Column(name="created_by", nullable=false, length=25)
	private String createdBy;

	@Column(name="created_tm", nullable=false)
	private Timestamp createdTm;

	@Column(nullable=false, length=500)
	private String descriptions;

	@Column(name="updated_by", length=25)
	private String updatedBy;

	@Column(name="updated_tm")
	private Timestamp updatedTm;

	//bi-directional many-to-one association to PhoneNumbersHistory
	@OneToMany(mappedBy="numberStatus")
	private Set<PhoneNumbersHistory> phoneNumbersHistories;

	public NumberStatus() {
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedTm() {
		return this.createdTm;
	}

	public void setCreatedTm(Timestamp createdTm) {
		this.createdTm = createdTm;
	}

	public String getDescriptions() {
		return this.descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedTm() {
		return this.updatedTm;
	}

	public void setUpdatedTm(Timestamp updatedTm) {
		this.updatedTm = updatedTm;
	}

	public Set<PhoneNumbersHistory> getPhoneNumbersHistories() {
		return this.phoneNumbersHistories;
	}

	public void setPhoneNumbersHistories(Set<PhoneNumbersHistory> phoneNumbersHistories) {
		this.phoneNumbersHistories = phoneNumbersHistories;
	}

	public PhoneNumbersHistory addPhoneNumbersHistory(PhoneNumbersHistory phoneNumbersHistory) {
		getPhoneNumbersHistories().add(phoneNumbersHistory);
		phoneNumbersHistory.setNumberStatus(this);

		return phoneNumbersHistory;
	}

	public PhoneNumbersHistory removePhoneNumbersHistory(PhoneNumbersHistory phoneNumbersHistory) {
		getPhoneNumbersHistories().remove(phoneNumbersHistory);
		phoneNumbersHistory.setNumberStatus(null);

		return phoneNumbersHistory;
	}

}