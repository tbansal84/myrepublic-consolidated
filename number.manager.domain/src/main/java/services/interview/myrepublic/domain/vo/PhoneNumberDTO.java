package services.interview.myrepublic.domain.vo;

import java.util.Date;

public class PhoneNumberDTO {

	public PhoneNumberDTO(String phoneNumber, String status) {
		super();
		this.phoneNumber = phoneNumber;
		this.status = status;
	}

	private String phoneNumber;
	private String status;
	private String createdBy;
	private String updatedBy;
	private Date createdTm;
	private Date updatedTm;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public PhoneNumberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedTm() {
		return createdTm;
	}

	public void setCreatedTm(Date createdTm) {
		this.createdTm = createdTm;
	}

	public Date getUpdatedTm() {
		return updatedTm;
	}

	public void setUpdatedTm(Date updatedTm) {
		this.updatedTm = updatedTm;
	}

}
