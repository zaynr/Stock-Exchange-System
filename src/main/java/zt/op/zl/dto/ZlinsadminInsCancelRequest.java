package zt.op.zl.dto;
/** 
 * LS_指令管理_撤销指令  请求参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInsCancelRequest {
    private Integer insId; //指令序号
    private Integer operatorNo; //操作员序号
    private String remark; //备注

    public Integer getInsId(){
        return this.insId;
    }
    public void setInsId( Integer insId ){
        this.insId = insId;
    }
    public Integer getOperatorNo(){
        return this.operatorNo;
    }
    public void setOperatorNo( Integer operatorNo ){
        this.operatorNo = operatorNo;
    }
    public String getRemark(){
        return this.remark;
    }
    public void setRemark( String remark ){
        this.remark = remark;
    }

}