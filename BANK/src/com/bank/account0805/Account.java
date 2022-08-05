package com.bank.account0805;

//import java.util.Date;
import java.sql.Date;

public class Account {
	private String accountId;
	private String memberId;
	private int blance;
	private Date credate;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public int getBlance() {
		return blance;
	}

	public void setBlance(int blance) {
		this.blance = blance;
	}

	public Date getCredate() {
		return credate;
	}

	public void setCredate(Date credate) {
		this.credate = credate;
	}

}
