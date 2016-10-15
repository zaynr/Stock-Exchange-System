package zt.op.common.dto;

public class ZyjyDealhandleRequestDTO extends BaseDTO{
	private String entrustSerialNo;
	private String confirmCodeno;
	private String interCode;
	private String entrustDirection;
	private String dealAmount;
	private String dealPrice;
	private String dealBalance;
	private String dealTime;
	private String dealNo;
	private String capitalAccountId;
	public String getEntrustSerialNo() {
		return entrustSerialNo;
	}
	public void setEntrustSerialNo(String entrustSerialNo) {
		this.entrustSerialNo = entrustSerialNo;
	}
	public String getConfirmCodeno() {
		return confirmCodeno;
	}
	public void setConfirmCodeno(String confirmCodeno) {
		this.confirmCodeno = confirmCodeno;
	}
	public String getInterCode() {
		return interCode;
	}
	public void setInterCode(String interCode) {
		this.interCode = interCode;
	}
	public String getEntrustDirection() {
		return entrustDirection;
	}
	public void setEntrustDirection(String entrustDirection) {
		this.entrustDirection = entrustDirection;
	}
	public String getDealAmount() {
		return dealAmount;
	}
	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}
	public String getDealPrice() {
		return dealPrice;
	}
	public void setDealPrice(String dealPrice) {
		this.dealPrice = dealPrice;
	}
	public String getDealBalance() {
		return dealBalance;
	}
	public void setDealBalance(String dealBalance) {
		this.dealBalance = dealBalance;
	}
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public String getDealNo() {
		return dealNo;
	}
	public void setDealNo(String dealNo) {
		this.dealNo = dealNo;
	}
	public String getCapitalAccountId() {
		return capitalAccountId;
	}
	public void setCapitalAccountId(String capitalAccountId) {
		this.capitalAccountId = capitalAccountId;
	}

}
