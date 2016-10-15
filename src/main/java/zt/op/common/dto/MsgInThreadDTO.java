package zt.op.common.dto;

/**
 * 
 * @Description 存放在线程变量里的数据
 * @company 恒生电子股份有限公司
 * @author qiujm
 * @date 2015年3月24日
 */
public class MsgInThreadDTO {
	private Integer loginOperator;
	private Integer loginCompany;//登录公司
	private String loginOperatorName;
	private Integer menuIdOp;
	private String mac;
	private String volserialNo;
	private String computerName;
	private String loginIp;
	private String userToken;
	private String companyId;//路由公司
	private String wsCpu;
	private String funId;
	
	public Integer getLoginOperator() {
		return loginOperator;
	}
	public void setLoginOperator(Integer loginOperator) {
		this.loginOperator = loginOperator;
	}
	public Integer getLoginCompany() {
		return loginCompany;
	}
	public void setLoginCompany(Integer loginCompany) {
		this.loginCompany = loginCompany;
	}
	public Integer getMenuIdOp() {
		return menuIdOp;
	}
	public void setMenuIdOp(Integer menuIdOp) {
		this.menuIdOp = menuIdOp;
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
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getLoginOperatorName() {
		return loginOperatorName;
	}
	public void setLoginOperatorName(String loginOperatorName) {
		this.loginOperatorName = loginOperatorName;
	}
	public String getWsCpu() {
		return wsCpu;
	}
	public void setWsCpu(String wsCpu) {
		this.wsCpu = wsCpu;
	}
	public String getFunId() {
		return funId;
	}
	public void setFunId(String funId) {
		this.funId = funId;
	}

	
}
