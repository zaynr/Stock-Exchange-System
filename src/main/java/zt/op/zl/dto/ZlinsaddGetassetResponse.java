package zt.op.zl.dto;
/** 
 * LS_指令下达_获取资产信息  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsaddGetassetResponse {
    private Double totalValue; //总资产
    private Double beginCash; //期初资金余额
    private Double currentCash; //现金资产
    private Double stockAssetValue; //股票资产
    private Double availableBalance; //可用金额

    public Double getTotalValue(){
        return this.totalValue;
    }
    public void setTotalValue( Double totalValue ){
        this.totalValue = totalValue;
    }
    public Double getBeginCash(){
        return this.beginCash;
    }
    public void setBeginCash( Double beginCash ){
        this.beginCash = beginCash;
    }
    public Double getCurrentCash(){
        return this.currentCash;
    }
    public void setCurrentCash( Double currentCash ){
        this.currentCash = currentCash;
    }
    public Double getStockAssetValue(){
        return this.stockAssetValue;
    }
    public void setStockAssetValue( Double stockAssetValue ){
        this.stockAssetValue = stockAssetValue;
    }
    public Double getAvailableBalance(){
        return this.availableBalance;
    }
    public void setAvailableBalance( Double availableBalance ){
        this.availableBalance = availableBalance;
    }

}