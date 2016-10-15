package zt.op.zl.dto;
import java.util.List;

import zt.op.zl.object.OppInsdealout;
/** 
 * LS_指令管理_指令成交  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInsdealResponse {
    private Integer count; //记录条数
    private List<OppInsdealout> row; //获取指令成交列表出参

    public Integer getCount(){
        return this.count;
    }
    public void setCount( Integer count ){
        this.count = count;
    }
    public List<OppInsdealout> getRow(){
        return this.row;
    }
    public void setRow( List<OppInsdealout> row ){
        this.row = row;
    }

}