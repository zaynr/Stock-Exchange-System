package zt.op.zl.dto;
import java.util.List;

import zt.op.zl.object.OppInslistout;
/** 
 * LS_指令管理_获取指令列表  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInslistResponse {
    private Integer count; //记录条数
    private List<OppInslistout> row; //获取指令列表出参

    public Integer getCount(){
        return this.count;
    }
    public void setCount( Integer count ){
        this.count = count;
    }
    public List<OppInslistout> getRow(){
        return this.row;
    }
    public void setRow( List<OppInslistout> row ){
        this.row = row;
    }

}