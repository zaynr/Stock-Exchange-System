package zt.op.zl.dto;
/** 
 * LS_指令下达_获取证券基本信息  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsaddGetreportsResponse {
    private Integer interCode; //证券内码
    private String reportCode; //证券代码
    private String stockName; //证券名称
    private String stockFullname; //证券全称
    private String stockSpell; //证券拼音码
    private Integer stockType; //证券类别
    private Integer marketNo; //交易市场编号
    private Double outstandingShare; //流通股本
    private Double yesterdayClosePrice; //昨收盘价
    private Double lastPrice; //最新价
    private String stockStopFlag; //停牌标志
    private Double uplimitedAmount; //最高数量限额
    private Double downlimitedAmount; //最低数量限额
    private Double buyUnit; //买入最小单位
    private Double saleUnit; //卖出最小单位
    private String stockStatus; //证券状态
    private Double uplimitedRatio; //涨停板比例
    private Double downlimitedRatio; //跌停板比例
    private Double uplimitedPrice; //涨停板价格
    private Double downlimitedPrice; //跌停板价格
    private Double faceValue; //面值
    private String longStopFlag; //长期停牌标志

    public Integer getInterCode(){
        return this.interCode;
    }
    public void setInterCode( Integer interCode ){
        this.interCode = interCode;
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
    public String getStockFullname(){
        return this.stockFullname;
    }
    public void setStockFullname( String stockFullname ){
        this.stockFullname = stockFullname;
    }
    public String getStockSpell(){
        return this.stockSpell;
    }
    public void setStockSpell( String stockSpell ){
        this.stockSpell = stockSpell;
    }
    public Integer getStockType(){
        return this.stockType;
    }
    public void setStockType( Integer stockType ){
        this.stockType = stockType;
    }
    public Integer getMarketNo(){
        return this.marketNo;
    }
    public void setMarketNo( Integer marketNo ){
        this.marketNo = marketNo;
    }
    public Double getOutstandingShare(){
        return this.outstandingShare;
    }
    public void setOutstandingShare( Double outstandingShare ){
        this.outstandingShare = outstandingShare;
    }
    public Double getYesterdayClosePrice(){
        return this.yesterdayClosePrice;
    }
    public void setYesterdayClosePrice( Double yesterdayClosePrice ){
        this.yesterdayClosePrice = yesterdayClosePrice;
    }
    public Double getLastPrice(){
        return this.lastPrice;
    }
    public void setLastPrice( Double lastPrice ){
        this.lastPrice = lastPrice;
    }
    public String getStockStopFlag(){
        return this.stockStopFlag;
    }
    public void setStockStopFlag( String stockStopFlag ){
        this.stockStopFlag = stockStopFlag;
    }
    public Double getUplimitedAmount(){
        return this.uplimitedAmount;
    }
    public void setUplimitedAmount( Double uplimitedAmount ){
        this.uplimitedAmount = uplimitedAmount;
    }
    public Double getDownlimitedAmount(){
        return this.downlimitedAmount;
    }
    public void setDownlimitedAmount( Double downlimitedAmount ){
        this.downlimitedAmount = downlimitedAmount;
    }
    public Double getBuyUnit(){
        return this.buyUnit;
    }
    public void setBuyUnit( Double buyUnit ){
        this.buyUnit = buyUnit;
    }
    public Double getSaleUnit(){
        return this.saleUnit;
    }
    public void setSaleUnit( Double saleUnit ){
        this.saleUnit = saleUnit;
    }
    public String getStockStatus(){
        return this.stockStatus;
    }
    public void setStockStatus( String stockStatus ){
        this.stockStatus = stockStatus;
    }
    public Double getUplimitedRatio(){
        return this.uplimitedRatio;
    }
    public void setUplimitedRatio( Double uplimitedRatio ){
        this.uplimitedRatio = uplimitedRatio;
    }
    public Double getDownlimitedRatio(){
        return this.downlimitedRatio;
    }
    public void setDownlimitedRatio( Double downlimitedRatio ){
        this.downlimitedRatio = downlimitedRatio;
    }
    public Double getUplimitedPrice(){
        return this.uplimitedPrice;
    }
    public void setUplimitedPrice( Double uplimitedPrice ){
        this.uplimitedPrice = uplimitedPrice;
    }
    public Double getDownlimitedPrice(){
        return this.downlimitedPrice;
    }
    public void setDownlimitedPrice( Double downlimitedPrice ){
        this.downlimitedPrice = downlimitedPrice;
    }
    public Double getFaceValue(){
        return this.faceValue;
    }
    public void setFaceValue( Double faceValue ){
        this.faceValue = faceValue;
    }
    public String getLongStopFlag(){
        return this.longStopFlag;
    }
    public void setLongStopFlag( String longStopFlag ){
        this.longStopFlag = longStopFlag;
    }

}