package zt.op.zl.object;
/** 
 * 获取指令操作流水出参
 * @author ares studio
 * 
 */ 
public class OppInsopout {
    private Integer serialNo; //流水号
    private Integer businessDate; //业务日期
    private String insOpType; //指令操作类型
    private String insStatus; //指令状态
    private Integer insId; //指令序号
    private Integer operatorNo; //操作员序号
    private Integer operateDate; //操作日期
    private Integer operateTime; //操作时间
    private Integer tradeOperator; //执行人
    private String remark; //备注

    public Integer getSerialNo(){
        return this.serialNo;
    }
    public void setSerialNo( Integer serialNo ){
        this.serialNo = serialNo;
    }
    public Integer getBusinessDate(){
        return this.businessDate;
    }
    public void setBusinessDate( Integer businessDate ){
        this.businessDate = businessDate;
    }
    public String getInsOpType(){
        return this.insOpType;
    }
    public void setInsOpType( String insOpType ){
        this.insOpType = insOpType;
    }
    public String getInsStatus(){
        return this.insStatus;
    }
    public void setInsStatus( String insStatus ){
        this.insStatus = insStatus;
    }
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
    public Integer getOperateDate(){
        return this.operateDate;
    }
    public void setOperateDate( Integer operateDate ){
        this.operateDate = operateDate;
    }
    public Integer getOperateTime(){
        return this.operateTime;
    }
    public void setOperateTime( Integer operateTime ){
        this.operateTime = operateTime;
    }
    public Integer getTradeOperator(){
        return this.tradeOperator;
    }
    public void setTradeOperator( Integer tradeOperator ){
        this.tradeOperator = tradeOperator;
    }
    public String getRemark(){
        return this.remark;
    }
    public void setRemark( String remark ){
        this.remark = remark;
    }

}