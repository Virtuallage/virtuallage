package com.vipay.data;

// Generated Feb 3, 2013 6:50:08 PM by Hibernate Tools 3.4.0.CR1

/**
 * CodeDetId generated by hbm2java
 */
public class CodeDetId implements java.io.Serializable {

	private String codeHeaderId;
	private String code;

	public CodeDetId() {
	}

	public CodeDetId(String codeHeaderId, String code) {
		this.codeHeaderId = codeHeaderId;
		this.code = code;
	}

	public String getCodeHeaderId() {
		return this.codeHeaderId;
	}

	public void setCodeHeaderId(String codeHeaderId) {
		this.codeHeaderId = codeHeaderId;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CodeDetId))
			return false;
		CodeDetId castOther = (CodeDetId) other;

		return ((this.getCodeHeaderId() == castOther.getCodeHeaderId()) || (this
				.getCodeHeaderId() != null
				&& castOther.getCodeHeaderId() != null && this
				.getCodeHeaderId().equals(castOther.getCodeHeaderId())))
				&& ((this.getCode() == castOther.getCode()) || (this.getCode() != null
						&& castOther.getCode() != null && this.getCode()
						.equals(castOther.getCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodeHeaderId() == null ? 0 : this.getCodeHeaderId()
						.hashCode());
		result = 37 * result
				+ (getCode() == null ? 0 : this.getCode().hashCode());
		return result;
	}

}