package zt.op.zl.dto;
import java.util.List;

import zt.op.zl.object.OppInsriskout;
/** 
 * LS_指令管理_触犯风控  返回参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInsriskResponse {
    private Integer count; //记录条数
    private List<OppInsriskout> row; //获取指令风控列表出参

    public Integer getCount(){
        return this.count;
    }
    public void setCount( Integer count ){
        this.count = count;
    }
    public List<OppInsriskout> getRow(){
        return this.row;
    }
    public void setRow( List<OppInsriskout> row ){
        this.row = row;
    }

}