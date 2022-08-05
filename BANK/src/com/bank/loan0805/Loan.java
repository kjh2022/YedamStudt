package com.bank.loan0805;

import java.sql.Date;

public class Loan {
	private String loanId;
	private String membeId;
	private Date loanDate;
	private String state;

	public String getLoanId() {
		return loanId;
	}

	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}

	public String getMembeId() {
		return membeId;
	}

	public void setMembeId(String membeId) {
		this.membeId = membeId;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
