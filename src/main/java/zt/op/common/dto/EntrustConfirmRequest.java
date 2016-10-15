package zt.op.common.dto;

public class EntrustConfirmRequest extends BaseDTO{
	String entrustSerialNo;
	String confirmCodeno;
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

}
