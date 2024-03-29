package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * Holiday generated by hbm2java
 */
public class Holiday implements java.io.Serializable {

	private Long holidayId;
	private Institution institution;
	private Date date;
	private String description;

	public Holiday() {
	}

	public Holiday(Institution institution) {
		this.institution = institution;
	}

	public Holiday(Institution institution, Date date, String description) {
		this.institution = institution;
		this.date = date;
		this.description = description;
	}

	public Long getHolidayId() {
		return this.holidayId;
	}

	public void setHolidayId(Long holidayId) {
		this.holidayId = holidayId;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
