package zt.op.zl.dto;
/** 
 * LS_指令管理_获取指令列表  请求参数的DTO
 * @author ares studio
 * 
 */ 

public class ZlinsadminInslistRequest {
    private Integer directOperator; //下达人

    public Integer getDirectOperator(){
        return this.directOperator;
    }
    public void setDirectOperator( Integer directOperator ){
        this.directOperator = directOperator;
    }

}