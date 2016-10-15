package zt.op.common.dto;

public class OfferEntrustWithdrawResponseDTO extends BaseDTO{
	private String errorNo;
	private String errorInfo;
	private String entrustNo;

	public String getErrorNo() {
		return errorNo;
	}
	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}
	public String getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	public String getEntrustNo() {
		return entrustNo;
	}
	public void setEntrustNo(String entrustNo) {
		this.entrustNo = entrustNo;
	}
}
