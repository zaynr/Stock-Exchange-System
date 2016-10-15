package zt.op.zl.dto;
import java.util.List;

import zt.op.zl.object.OppInsentrustout;
/** 
 * LS_指令管理_指令委托  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInsentrustResponse {
    private Integer count; //记录条数
    private List<OppInsentrustout> row; //获取指令委托列表出参

    public Integer getCount(){
        return this.count;
    }
    public void setCount( Integer count ){
        this.count = count;
    }
    public List<OppInsentrustout> getRow(){
        return this.row;
    }
    public void setRow( List<OppInsentrustout> row ){
        this.row = row;
    }

}