package services.interview.myrepublic.domain.vo;

import java.util.Date;

public class PhoneNumberHistoryDTO {

	private String phoneNumber;
	private String status;
	private String updatedBy;
	private Date updatedDate;

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

}
