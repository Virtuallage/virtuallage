package com.vipro.data;

import java.util.Date;

public class LetterHistory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8391837513788409207L;
	private Long letterHistoryId;
	private Account account;
	private Letter letter;
	private String status;
	private Long createdBy;
	private Date dateCreated;

	public LetterHistory() {
	}

	public LetterHistory(Account account) {
		this.account = account;
	}

	public LetterHistory(Account account, Letter letter, String status,
			Long createdBy, Date dateCreated) {
		this.account = account;
		this.letter = letter;
		this.status = status;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
	}

	public Long getLetterHistoryId() {
		return letterHistoryId;
	}

	public void setLetterHistoryId(Long letterHistoryId) {
		this.letterHistoryId = letterHistoryId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Letter getLetter() {
		return letter;
	}

	public void setLetter(Letter letter) {
		this.letter = letter;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
