package zt.op.zl.object;
/** 
 * 获取指令风控列表出参
 * @author ares studio
 * 
 */ 
public class OppInsriskout {
    private Integer insId; //指令序号
    private String reportCode; //证券代码
    private String stockName; //证券名称
    private Integer warnOperation; //触警操作
    private Integer ruleType; //合规规则类型
    private String ruleTypeName; //合规规则类型名称
    private String ruleSummary; //合规规则说明
    private Integer compareDirection; //比较方向
    private Double setValue; //设置值
    private Double calcValue; //计算值
    private String remarkShort; //简短备注

    public Integer getInsId(){
        return this.insId;
    }
    public void setInsId( Integer insId ){
        this.insId = insId;
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
    public Integer getWarnOperation(){
        return this.warnOperation;
    }
    public void setWarnOperation( Integer warnOperation ){
        this.warnOperation = warnOperation;
    }
    public Integer getRuleType(){
        return this.ruleType;
    }
    public void setRuleType( Integer ruleType ){
        this.ruleType = ruleType;
    }
    public String getRuleTypeName(){
        return this.ruleTypeName;
    }
    public void setRuleTypeName( String ruleTypeName ){
        this.ruleTypeName = ruleTypeName;
    }
    public String getRuleSummary(){
        return this.ruleSummary;
    }
    public void setRuleSummary( String ruleSummary ){
        this.ruleSummary = ruleSummary;
    }
    public Integer getCompareDirection(){
        return this.compareDirection;
    }
    public void setCompareDirection( Integer compareDirection ){
        this.compareDirection = compareDirection;
    }
    public Double getSetValue(){
        return this.setValue;
    }
    public void setSetValue( Double setValue ){
        this.setValue = setValue;
    }
    public Double getCalcValue(){
        return this.calcValue;
    }
    public void setCalcValue( Double calcValue ){
        this.calcValue = calcValue;
    }
    public String getRemarkShort(){
        return this.remarkShort;
    }
    public void setRemarkShort( String remarkShort ){
        this.remarkShort = remarkShort;
    }

}