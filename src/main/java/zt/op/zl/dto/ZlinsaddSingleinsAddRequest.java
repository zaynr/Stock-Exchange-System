package zt.op.zl.dto;
/** 
 * LS_指令下达_单产品指令下达  请求参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsaddSingleinsAddRequest {
    private Integer entrustDirection = 0; //委托方向
    private Double insPrice = 0.0; //指令价格
    private Double insAmount = 0.0; //指令数量
    private Double insBalance = 0.0; //指令金额
    private Integer tradeOperator = 0; //执行人
    private Integer directOperator = 0; //下达人
    private String remark; //备注
    private Integer interCode = 0; //证券内码

    public Integer getEntrustDirection(){
        return this.entrustDirection;
    }
    public void setEntrustDirection( Integer entrustDirection ){
        this.entrustDirection = entrustDirection;
    }
    public Double getInsPrice(){
        return this.insPrice;
    }
    public void setInsPrice( Double insPrice ){
        this.insPrice = insPrice;
    }
    public Double getInsAmount(){
        return this.insAmount;
    }
    public void setInsAmount( Double insAmount ){
        this.insAmount = insAmount;
    }
    public Double getInsBalance(){
        return this.insBalance;
    }
    public void setInsBalance( Double insBalance ){
        this.insBalance = insBalance;
    }
    public Integer getTradeOperator(){
        return this.tradeOperator;
    }
    public void setTradeOperator( Integer tradeOperator ){
        this.tradeOperator = tradeOperator;
    }
    public Integer getDirectOperator(){
        return this.directOperator;
    }
    public void setDirectOperator( Integer directOperator ){
        this.directOperator = directOperator;
    }
    public String getRemark(){
        return this.remark;
    }
    public void setRemark( String remark ){
        this.remark = remark;
    }
    public Integer getInterCode(){
        return this.interCode;
    }
    public void setInterCode( Integer interCode ){
        this.interCode = interCode;
    }

}