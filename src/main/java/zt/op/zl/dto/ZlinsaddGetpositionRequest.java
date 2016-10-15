package zt.op.zl.dto;
/** 
 * LS_指令下达_获取持仓  请求参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsaddGetpositionRequest {
    private Integer capitalAccountId; //资金账户序号

    public Integer getCapitalAccountId(){
        return this.capitalAccountId;
    }
    public void setCapitalAccountId( Integer capitalAccountId ){
        this.capitalAccountId = capitalAccountId;
    }

}