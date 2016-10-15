package zt.op.zl.dto;
/** 
 * LS_指令管理_指令证券  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInsstockResponse {
    private Integer insId; //指令序号
    private Integer marketNo; //交易市场编号
    private String reportCode; //证券代码
    private String stockName; //证券名称
    private Integer entrustDirection; //委托方向
    private Double insAmount; //指令数量
    private Double insPrice; //指令价格
    private Double insBalance; //指令金额
    private Double entrustAmount; //委托数量
    private Double entrustBalance; //委托金额
    private Double dealAmount; //成交数量
    private Double dealBalance; //成交金额

    public Integer getInsId(){
        return this.insId;
    }
    public void setInsId( Integer insId ){
        this.insId = insId;
    }
    public Integer getMarketNo(){
        return this.marketNo;
    }
    public void setMarketNo( Integer marketNo ){
        this.marketNo = marketNo;
    }
    public String getReportCode(){
        return this.reportCode;
    }
    public void setReportCode( String reportCode ){
        this.reportCode = reportCode;
    }
    public String getStockName(){
        return this.stockName;
    }
    public void setStockName( String stockName ){
        this.stockName = stockName;
    }
    public Integer getEntrustDirection(){
        return this.entrustDirection;
    }
    public void setEntrustDirection( Integer entrustDirection ){
        this.entrustDirection = entrustDirection;
    }
    public Double getInsAmount(){
        return this.insAmount;
    }
    public void setInsAmount( Double insAmount ){
        this.insAmount = insAmount;
    }
    public Double getInsPrice(){
        return this.insPrice;
    }
    public void setInsPrice( Double insPrice ){
        this.insPrice = insPrice;
    }
    public Double getInsBalance(){
        return this.insBalance;
    }
    public void setInsBalance( Double insBalance ){
        this.insBalance = insBalance;
    }
    public Double getEntrustAmount(){
        return this.entrustAmount;
    }
    public void setEntrustAmount( Double entrustAmount ){
        this.entrustAmount = entrustAmount;
    }
    public Double getEntrustBalance(){
        return this.entrustBalance;
    }
    public void setEntrustBalance( Double entrustBalance ){
        this.entrustBalance = entrustBalance;
    }
    public Double getDealAmount(){
        return this.dealAmount;
    }
    public void setDealAmount( Double dealAmount ){
        this.dealAmount = dealAmount;
    }
    public Double getDealBalance(){
        return this.dealBalance;
    }
    public void setDealBalance( Double dealBalance ){
        this.dealBalance = dealBalance;
    }

}