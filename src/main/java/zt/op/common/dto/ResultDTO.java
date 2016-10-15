package zt.op.common.dto;

public class ResultDTO {
	
	/**
	 * 返回错误代码，为0时表示正常
	 */
	private int errorNo;
	
	/**
	 * 返回的错误信息
	 */
	private String errorInfo;
	
	public int getErrorNo() {
		return errorNo;
	}

	public void setErrorNo(int errorNo) {
		this.errorNo = errorNo;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
}
