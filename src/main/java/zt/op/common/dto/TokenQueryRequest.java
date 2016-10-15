package zt.op.common.dto;

public class TokenQueryRequest extends BaseDTO {
	
	private int capitalAccountId;
	
	private String userToken;
	
	public int getCapitalAccountId() {
		return capitalAccountId;
	}

	public void setCapitalAccountId(int capitalAccountId) {
		this.capitalAccountId = capitalAccountId;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	
}
