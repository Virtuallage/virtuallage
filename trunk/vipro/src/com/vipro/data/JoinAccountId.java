package com.vipro.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

/**
 * JoinAccountId generated by hbm2java
 */
public class JoinAccountId implements java.io.Serializable {

	private long accountId;
	private long customerId;

	public JoinAccountId() {
	}

	public JoinAccountId(long accountId, long customerId) {
		this.accountId = accountId;
		this.customerId = customerId;
	}

	public long getAccountId() {
		return this.accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof JoinAccountId))
			return false;
		JoinAccountId castOther = (JoinAccountId) other;

		return (this.getAccountId() == castOther.getAccountId())
				&& (this.getCustomerId() == castOther.getCustomerId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getAccountId();
		result = 37 * result + (int) this.getCustomerId();
		return result;
	}

}
