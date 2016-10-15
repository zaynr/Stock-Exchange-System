package zt.op.zl.dto;
import java.util.List;

import zt.op.zl.object.OfkcompliancesetRisk_rows;
/** 
 * LS_指令下达_单产品指令下达  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsaddSingleinsAddResponse {
    private Integer riskResult; //风控检查结果
    private List<OfkcompliancesetRisk_rows> riskRows; //风控返回内容
    private Integer insId; //指令序号
    private Integer insStockId; //指令证券序号
    private Integer serialNo; //流水号

    public Integer getRiskResult(){
        return this.riskResult;
    }
    public void setRiskResult( Integer riskResult ){
        this.riskResult = riskResult;
    }
    public List<OfkcompliancesetRisk_rows> getRiskRows(){
        return this.riskRows;
    }
    public void setRiskRows( List<OfkcompliancesetRisk_rows> riskRows ){
        this.riskRows = riskRows;
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