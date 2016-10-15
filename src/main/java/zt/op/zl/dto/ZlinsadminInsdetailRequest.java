package zt.op.zl.dto;
/** 
 * LS_指令管理_指令明细  请求参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInsdetailRequest {
    private Integer insId; //指令序号

    public Integer getInsId(){
        return this.insId;
    }
    public void setInsId( Integer insId ){
        this.insId = insId;
    }

}