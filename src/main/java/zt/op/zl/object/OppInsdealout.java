package zt.op.zl.object;
/** 
 * 获取指令成交列表出参
 * @author ares studio
 * 
 */ 
public class OppInsdealout {
    private Integer realdealSerialNo; //成交流水序号
    private Integer entrustSerialNo; //委托序号
    private String reportCode; //证券代码
    private String stockName; //证券名称
    private Integer entrustDirection; //委托方向
    private Double dealAmount; //成交数量
    private Double dealBalance; //成交金额
    private Integer dealTime; //成交时间

    public Integer getRealdealSerialNo(){
        return this.realdealSerialNo;
    }
    public void setRealdealSerialNo( Integer realdealSerialNo ){
        this.realdealSerialNo = realdealSerialNo;
    }
    public Integer getEntrustSerialNo(){
        return this.entrustSerialNo;
    }
    public void setEntrustSerialNo( Integer entrustSerialNo ){
        this.entrustSerialNo = entrustSerialNo;
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
    public Integer getDealTime(){
        return this.dealTime;
    }
    public void setDealTime( Integer dealTime ){
        this.dealTime = dealTime;
    }

}