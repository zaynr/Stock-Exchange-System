package zt.op.zl.object;

import zt.op.common.dto.BaseDTO;

public class InstructionDTO extends BaseDTO{
	private Integer businessDate;
	private Integer insId;
	private Integer directOperator;
	private Integer tradeOperator;
	private String insStatus;
	private Integer insUpdateTime;
	private String remark;
	public Integer getBusinessDate() {
		return businessDate;
	}
	public void setBusinessDate(Integer businessDate) {
		this.businessDate = businessDate;
	}
	public Integer getInsId() {
		return insId;
	}
	public void setInsId(Integer insId) {
		this.insId = insId;
	}
	public Integer getDirectOperator() {
		return directOperator;
	}
	public void setDirectOperator(Integer directOperator) {
		this.directOperator = directOperator;
	}
	public Integer getTradeOperator() {
		return tradeOperator;
	}
	public void setTradeOperator(Integer tradeOperator) {
		this.tradeOperator = tradeOperator;
	}
	public String getInsStatus() {
		return insStatus;
	}
	public void setInsStatus(String insStatus) {
		this.insStatus = insStatus;
	}
	public Integer getInsUpdateTime() {
		return insUpdateTime;
	}
	public void setInsUpdateTime(Integer insUpdateTime) {
		this.insUpdateTime = insUpdateTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
