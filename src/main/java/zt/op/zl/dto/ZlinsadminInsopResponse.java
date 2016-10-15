package zt.op.zl.dto;
import java.util.List;

import zt.op.zl.object.OppInsopout;
/** 
 * LS_指令管理_操作流水  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInsopResponse {
    private Integer count; //记录条数
    private List<OppInsopout> row; //获取指令操作流水出参

    public Integer getCount(){
        return this.count;
    }
    public void setCount( Integer count ){
        this.count = count;
    }
    public List<OppInsopout> getRow(){
        return this.row;
    }
    public void setRow( List<OppInsopout> row ){
        this.row = row;
    }

}