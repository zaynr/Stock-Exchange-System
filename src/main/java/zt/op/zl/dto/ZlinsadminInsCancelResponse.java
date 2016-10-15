package zt.op.zl.dto;
/** 
 * LS_指令管理_撤销指令  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInsCancelResponse {
    private String insStatus; //指令状态

    public String getInsStatus(){
        return this.insStatus;
    }
    public void setInsStatus( String insStatus ){
        this.insStatus = insStatus;
    }

}