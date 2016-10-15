package zt.op.zl.object;
/** 
 * 指令对象
 * @author ares studio
 * 
 */ 
public class OppInstruction {
    private Integer businessDate; //业务日期
    private Integer insId; //指令序号
    private Integer directOperator; //下达人
    private Integer tradeOperator; //执行人
    private String insStatus; //指令状态
    private Integer insUpdateTime; //指令状态变更时间
    private String remark; //备注

    public Integer getBusinessDate(){
        return this.businessDate;
    }
    public void setBusinessDate( Integer businessDate ){
        this.businessDate = businessDate;
    }
    public Integer getInsId(){
        return this.insId;
    }
    public void setInsId( Integer insId ){
        this.insId = insId;
    }
    public Integer getDirectOperator(){
        return this.directOperator;
    }
    public void setDirectOperator( Integer directOperator ){
        this.directOperator = directOperator;
    }
    public Integer getTradeOperator(){
        return this.tradeOperator;
    }
    public void setTradeOperator( Integer tradeOperator ){
        this.tradeOperator = tradeOperator;
    }
    public String getInsStatus(){
        return this.insStatus;
    }
    public void setInsStatus( String insStatus ){
        this.insStatus = insStatus;
    }
    public Integer getInsUpdateTime(){
        return this.insUpdateTime;
    }
    public void setInsUpdateTime( Integer insUpdateTime ){
        this.insUpdateTime = insUpdateTime;
    }
    public String getRemark(){
        return this.remark;
    }
    public void setRemark( String remark ){
        this.remark = remark;
    }

}