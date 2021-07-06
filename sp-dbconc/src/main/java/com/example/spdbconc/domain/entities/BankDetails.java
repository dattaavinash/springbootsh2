package com.example.spdbconc.domain.entities;

public class BankDetails {

	private String accno;
	
	private int port;

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public BankDetails(String accno,int port)
	{
		this.accno=accno;
		this.setPort(port);
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}
