package zt.op.common.dto;

public class AckResponseDTO {
	String errorNo;
	String errorInfo;
	String entrustNo;
	String reportNo;
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
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

}
