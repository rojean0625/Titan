package com.entity;

import java.util.Date;

public class Trans {

	private String planCode;
	private String campainCode;
	private String sequenNo;
	private String agentNo;
	private double transAmountSum;
	private Date statisticDate;

	public Trans(){}
	public Trans(String sequenNo,double transAmountSum){
		this.sequenNo = sequenNo;
		this.transAmountSum = transAmountSum;

		this.planCode="FA-1001";
		this.campainCode = "HD-1001";
		this.agentNo = "82880200";
		this.statisticDate = new Date();
	}

	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getCampainCode() {
		return campainCode;
	}
	public void setCampainCode(String campainCode) {
		this.campainCode = campainCode;
	}
	public String getSequenNo() {
		return sequenNo;
	}
	public void setSequenNo(String sequenNo) {
		this.sequenNo = sequenNo;
	}
	public String getAgentNo() {
		return agentNo;
	}
	public void setAgentNo(String agentNo) {
		this.agentNo = agentNo;
	}
	public double getTransAmountSum() {
		return transAmountSum;
	}
	public void setTransAmountSum(double transAmountSum) {
		this.transAmountSum = transAmountSum;
	}
	public Date getStatisticDate() {
		return statisticDate;
	}
	public void setStatisticDate(Date statisticDate) {
		this.statisticDate = statisticDate;
	}
}
