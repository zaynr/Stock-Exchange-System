package zt.op.zl.object;
/** 
 * 风控返回内容
 * @author ares studio
 * 
 */ 
public class OfkcompliancesetRisk_rows {
    private Integer warnOperation; //触警操作
    private Integer ruleId; //合规规则序号
    private Integer ruleType; //合规规则类型
    private String ruleSummary; //合规规则说明
    private Integer compareDirection; //比较方向
    private Double setValue; //设置值
    private Double calcValue; //计算值
    private String remarkShort; //简短备注

    public Integer getWarnOperation(){
        return this.warnOperation;
    }
    public void setWarnOperation( Integer warnOperation ){
        this.warnOperation = warnOperation;
    }
    public Integer getRuleId(){
        return this.ruleId;
    }
    public void setRuleId( Integer ruleId ){
        this.ruleId = ruleId;
    }
    public Integer getRuleType(){
        return this.ruleType;
    }
    public void setRuleType( Integer ruleType ){
        this.ruleType = ruleType;
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