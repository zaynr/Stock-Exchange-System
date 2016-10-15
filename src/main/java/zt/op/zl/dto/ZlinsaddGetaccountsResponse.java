package zt.op.zl.dto;
/** 
 * LS_指令下达_获取帐号列表  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsaddGetaccountsResponse {
    private Integer capitalAccountId; //资金账户序号
    private String capitalAccountNo; //资金账号
    private String capitalAccountName; //资金帐号名称

    public Integer getCapitalAccountId(){
        return this.capitalAccountId;
    }
    public void setCapitalAccountId( Integer capitalAccountId ){
        this.capitalAccountId = capitalAccountId;
    }
    public String getCapitalAccountNo(){
        return this.capitalAccountNo;
    }
    public void setCapitalAccountNo( String capitalAccountNo ){
        this.capitalAccountNo = capitalAccountNo;
    }
    public String getCapitalAccountName(){
        return this.capitalAccountName;
    }
    public void setCapitalAccountName( String capitalAccountName ){
        this.capitalAccountName = capitalAccountName;
    }

}