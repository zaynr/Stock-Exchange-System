package zt.op.zl.dto;
/** 
 * LS_指令下达_获取持仓  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsaddGetpositionResponse {
    private Double currentAmount; //当前数量
    private Double enableAmount; //可卖数量
    private String reportCode; //证券代码
    private String stockName; //证券名称
    private Double lastPrice; //最新价
    private String stockStatus; //证券状态
    private Double yesterdayClosePrice; //昨收盘价
    private Double buyAmount; //交易端当日买入数量
    private Double buyBalance; //交易端当日买入金额
    private Double saleAmount; //当日卖出数量
    private Double saleBalance; //当日卖出金额
    private Double uplimitedPrice; //涨停板价格
    private Double downlimitedPrice; //跌停板价格
    private Integer marketNo; //交易市场编号

    public Double getCurrentAmount(){
        return this.currentAmount;
    }
    public void setCurrentAmount( Double currentAmount ){
        this.currentAmount = currentAmount;
    }
    public Double getEnableAmount(){
        return this.enableAmount;
    }
    public void setEnableAmount( Double enableAmount ){
        this.enableAmount = enableAmount;
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
    public Double getLastPrice(){
        return this.lastPrice;
    }
    public void setLastPrice( Double lastPrice ){
        this.lastPrice = lastPrice;
    }
    public String getStockStatus(){
        return this.stockStatus;
    }
    public void setStockStatus( String stockStatus ){
        this.stockStatus = stockStatus;
    }
    public Double getYesterdayClosePrice(){
        return this.yesterdayClosePrice;
    }
    public void setYesterdayClosePrice( Double yesterdayClosePrice ){
        this.yesterdayClosePrice = yesterdayClosePrice;
    }
    public Double getBuyAmount(){
        return this.buyAmount;
    }
    public void setBuyAmount( Double buyAmount ){
        this.buyAmount = buyAmount;
    }
    public Double getBuyBalance(){
        return this.buyBalance;
    }
    public void setBuyBalance( Double buyBalance ){
        this.buyBalance = buyBalance;
    }
    public Double getSaleAmount(){
        return this.saleAmount;
    }
    public void setSaleAmount( Double saleAmount ){
        this.saleAmount = saleAmount;
    }
    public Double getSaleBalance(){
        return this.saleBalance;
    }
    public void setSaleBalance( Double saleBalance ){
        this.saleBalance = saleBalance;
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
    public Integer getMarketNo(){
        return this.marketNo;
    }
    public void setMarketNo( Integer marketNo ){
        this.marketNo = marketNo;
    }

}