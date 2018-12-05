package services.interview.myrepublic.domain.dto;

import java.util.Date;

public class PhoneNumberDTO extends PageInfo{

	private String phoneNumber;
	private String status;
	private String updatedBy;
	private Date updatedDate;
	private Date remarks;
	
	

	public PhoneNumberDTO(String phoneNumber, String status, String updatedBy, Date updatedDate, Date remarks) {
		super();
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.remarks = remarks;
	}

	public PhoneNumberDTO(String status, String updatedBy, Date updatedDate) {
		super();
		this.status = status;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public PhoneNumberDTO(String phoneNumber, String status, String updatedBy, Date updatedDate) {
		super();
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public PhoneNumberDTO(String updatedBy, Date updatedDate) {
		super();
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}

	public PhoneNumberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Date getRemarks() {
		return remarks;
	}

	public void setRemarks(Date remarks) {
		this.remarks = remarks;
	}

}
