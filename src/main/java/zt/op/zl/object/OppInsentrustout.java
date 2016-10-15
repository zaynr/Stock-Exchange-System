package zt.op.zl.object;
/** 
 * 获取指令委托列表出参
 * @author ares studio
 * 
 */ 
public class OppInsentrustout {
    private Integer insId; //指令序号
    private Integer entrustSerialNo; //委托序号
    private String entrustStatus; //委托状态
    private String reportCode; //证券代码
    private String stockName; //证券名称
    private Integer entrustDirection; //委托方向
    private Double entrustAmount; //委托数量
    private Double entrustPrice; //委托价格
    private Double businAmount; //当日成交数量
    private Double businBalance; //当天成交金额
    private Integer entrustTime; //委托时间

    public Integer getInsId(){
        return this.insId;
    }
    public void setInsId( Integer insId ){
        this.insId = insId;
    }
    public Integer getEntrustSerialNo(){
        return this.entrustSerialNo;
    }
    public void setEntrustSerialNo( Integer entrustSerialNo ){
        this.entrustSerialNo = entrustSerialNo;
    }
    public String getEntrustStatus(){
        return this.entrustStatus;
    }
    public void setEntrustStatus( String entrustStatus ){
        this.entrustStatus = entrustStatus;
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
    public Double getEntrustAmount(){
        return this.entrustAmount;
    }
    public void setEntrustAmount( Double entrustAmount ){
        this.entrustAmount = entrustAmount;
    }
    public Double getEntrustPrice(){
        return this.entrustPrice;
    }
    public void setEntrustPrice( Double entrustPrice ){
        this.entrustPrice = entrustPrice;
    }
    public Double getBusinAmount(){
        return this.businAmount;
    }
    public void setBusinAmount( Double businAmount ){
        this.businAmount = businAmount;
    }
    public Double getBusinBalance(){
        return this.businBalance;
    }
    public void setBusinBalance( Double businBalance ){
        this.businBalance = businBalance;
    }
    public Integer getEntrustTime(){
        return this.entrustTime;
    }
    public void setEntrustTime( Integer entrustTime ){
        this.entrustTime = entrustTime;
    }

}