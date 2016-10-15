package zt.op.zl.object;

import java.io.Serializable;

public class TestObj implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -693030241164467313L;
	private int business_date;
	private int ins_id;
	private int direct_operator;
	private int trade_operator;
	private char ins_status;
	private int ins_update_time;
	private String remark;
	public int getBusiness_date() {
		return business_date;
	}
	public void setBusiness_date(int business_date) {
		this.business_date = business_date;
	}
	public int getIns_id() {
		return ins_id;
	}
	public void setIns_id(int ins_id) {
		this.ins_id = ins_id;
	}
	public int getDirect_operator() {
		return direct_operator;
	}
	public void setDirect_operator(int direct_operator) {
		this.direct_operator = direct_operator;
	}
	public int getTrade_operator() {
		return trade_operator;
	}
	public void setTrade_operator(int trade_operator) {
		this.trade_operator = trade_operator;
	}
	public char getIns_status() {
		return ins_status;
	}
	public void setIns_status(char ins_status) {
		this.ins_status = ins_status;
	}
	public int getIns_update_time() {
		return ins_update_time;
	}
	public void setIns_update_time(int ins_update_time) {
		this.ins_update_time = ins_update_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
