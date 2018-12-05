package services.interview.myrepublic.domain.dto;

import java.sql.Timestamp;

public class PhoneNumberAddOnDTO extends PageInfo{

	private String addon;

	private Timestamp createdBy;

	private Timestamp createdDt;

	private String description;


	public String getAddon() {
		return addon;
	}

	public void setAddon(String addon) {
		this.addon = addon;
	}

	public Timestamp getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Timestamp createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
