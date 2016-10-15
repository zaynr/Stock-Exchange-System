package zt.op.common.dto;

import java.util.Date;

/**
 * 
 * @Description DTO基类，所有DTO类需要继承BaseDTO，除分页DTO及其子类不用继承
 * @company 恒生电子股份有限公司
 * @author huangjl09192
 * @date 2015年1月17日
 */
public class BaseDTO {
	private Integer loginCompany;
	private Integer loginOperator;
	private String loginOperatorName;
	private Integer operateDate;
	private Integer operateTime;
	private String mac;
	private String volserialNo;
	private String computerName;
	private String loginIp;
	private String wsCpu;
	private Integer subsysNo;
	private Integer menuIdOp;
	private Integer menuRightIdOp;
	private String operatorClass;
	private String operatorContent;
	private String cancelFlag;
	private String clientType;
	private Integer checkOperator;
	private Date timeStamp;
	private String remarkLong;
	private String operatorDetailinfo;
	private Integer operatedCompanyId;
	private String userToken;
	private Integer funcId;
	private String funcName;
    private String sortStr;//排序字符串,用于sql中使用
	
	public Integer getLoginCompany() {
		return loginCompany;
	}

	public void setLoginCompany(Integer loginCompany) {
		this.loginCompany = loginCompany;
	}

	public Integer getLoginOperator() {
		return loginOperator;
	}

	public void setLoginOperator(Integer loginOperator) {
		this.loginOperator = loginOperator;
	}

	public Integer getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(Integer operateDate) {
		this.operateDate = operateDate;
	}
	public Integer getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Integer operateTime) {
		this.operateTime = operateTime;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getVolserialNo() {
		return volserialNo;
	}
	public void setVolserialNo(String volserialNo) {
		this.volserialNo = volserialNo;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public Integer getSubsysNo() {
		return subsysNo;
	}
	public void setSubsysNo(Integer subsysNo) {
		this.subsysNo = subsysNo;
	}

	public String getOperatorClass() {
		return operatorClass;
	}
	public void setOperatorClass(String operatorClass) {
		this.operatorClass = operatorClass;
	}
	public String getOperatorContent() {
		return operatorContent;
	}
	public void setOperatorContent(String operatorContent) {
		this.operatorContent = operatorContent;
	}
	public String getCancelFlag() {
		return cancelFlag;
	}
	public void setCancelFlag(String cancelFlag) {
		this.cancelFlag = cancelFlag;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public Integer getCheckOperator() {
		return checkOperator;
	}
	public void setCheckOperator(Integer checkOperator) {
		this.checkOperator = checkOperator;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getRemarkLong() {
		return remarkLong;
	}
	public void setRemarkLong(String remarkLong) {
		this.remarkLong = remarkLong;
	}

	public Integer getMenuIdOp() {
		return menuIdOp;
	}

	public void setMenuIdOp(Integer menuIdOp) {
		this.menuIdOp = menuIdOp;
	}

	public Integer getMenuRightIdOp() {
		return menuRightIdOp;
	}

	public void setMenuRightIdOp(Integer menuRightIdOp) {
		this.menuRightIdOp = menuRightIdOp;
	}

	public Integer getOperatedCompanyId() {
		return operatedCompanyId;
	}

	public void setOperatedCompanyId(Integer operatedCompanyId) {
		this.operatedCompanyId = operatedCompanyId;
	}
	
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public Integer getFuncId() {
		return funcId;
	}

	public void setFuncId(Integer funcId) {
		this.funcId = funcId;
	}

	public String getLoginOperatorName() {
		return loginOperatorName;
	}

	public void setLoginOperatorName(String loginOperatorName) {
		this.loginOperatorName = loginOperatorName;
	}

	public String getOperatorDetailinfo() {
		return operatorDetailinfo;
	}

	public void setOperatorDetailinfo(String operatorDetailinfo) {
		this.operatorDetailinfo = operatorDetailinfo;
	}

	public String getWsCpu() {
		return wsCpu;
	}

	public void setWsCpu(String wsCpu) {
		this.wsCpu = wsCpu;
	}

	public String getFuncName() {
		return funcName;
	}

	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	public String getSortStr() {
		return sortStr;
	}

	public void setSortStr(String sortStr) {
		if(sortStr!=null && !sortStr.equals("") && sortStr.matches(".*([';]+|(--)+).*")){
			//防止sql注入
			this.sortStr = "";
			return;
		}
		this.sortStr = sortStr;
	}
	
}
