package zt.op.zl.dto;
/** 
 * LS_指令下达_触警指令继续下达  请求参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsaddWarninscontinueRequest {
    private Integer entrustDirection; //委托方向
    private Double insPrice; //指令价格
    private Double insAmount; //指令数量
    private Double insBalance; //指令金额
    private Integer tradeOperator; //执行人
    private Integer directOperator; //下达人
    private String remark; //备注
    private Integer interCode; //证券内码
    private Integer insId; //指令序号
    private Integer insStockId; //指令证券序号
    private Integer serialNo; //流水号

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
    public Integer getInsId(){
        return this.insId;
    }
    public void setInsId( Integer insId ){
        this.insId = insId;
    }
    public Integer getInsStockId(){
        return this.insStockId;
    }
    public void setInsStockId( Integer insStockId ){
        this.insStockId = insStockId;
    }
    public Integer getSerialNo(){
        return this.serialNo;
    }
    public void setSerialNo( Integer serialNo ){
        this.serialNo = serialNo;
    }

}