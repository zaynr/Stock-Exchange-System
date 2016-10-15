package zt.op.zl.remote;


import com.hundsun.jresplus.remoting.impl.annotation.Service;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceModule;

import zt.op.zl.dto.ZlinsadminInsCancelRequest;
import zt.op.zl.dto.ZlinsadminInsCancelResponse;
import zt.op.zl.dto.ZlinsadminInsdealRequest;
import zt.op.zl.dto.ZlinsadminInsdealResponse;
import zt.op.zl.dto.ZlinsadminInsdetailRequest;
import zt.op.zl.dto.ZlinsadminInsdetailResponse;
import zt.op.zl.dto.ZlinsadminInsentrustRequest;
import zt.op.zl.dto.ZlinsadminInsentrustResponse;
import zt.op.zl.dto.ZlinsadminInslistRequest;
import zt.op.zl.dto.ZlinsadminInslistResponse;
import zt.op.zl.dto.ZlinsadminInsopRequest;
import zt.op.zl.dto.ZlinsadminInsopResponse;
import zt.op.zl.dto.ZlinsadminInsriskRequest;
import zt.op.zl.dto.ZlinsadminInsriskResponse;
import zt.op.zl.dto.ZlinsadminInsstockRequest;
import zt.op.zl.dto.ZlinsadminInsstockResponse;

@ServiceModule
public interface IInsadminService {
	/**
	 * LS_指令管理_撤销指令
	 * @param InsCancelRequest
	 * @return InsCancelResponse
	 */
    @Service(functionId = "840202", desc = "LS_指令管理_撤销指令")
	public ZlinsadminInsCancelResponse insCancel(ZlinsadminInsCancelRequest req);
	/**
	 * LS_指令管理_指令成交
	 * @param InsdealRequest
	 * @return InsdealResponse
	 */
    @Service(functionId = "840207", desc = "LS_指令管理_指令成交")
	public ZlinsadminInsdealResponse insdeal(ZlinsadminInsdealRequest req);
	/**
	 * LS_指令管理_指令明细
	 * @param InsdetailRequest
	 * @return InsdetailResponse
	 */
    @Service(functionId = "840204", desc = "LS_指令管理_指令明细")
	public ZlinsadminInsdetailResponse insdetail(ZlinsadminInsdetailRequest req);
	/**
	 * LS_指令管理_指令委托
	 * @param InsentrustRequest
	 * @return InsentrustResponse
	 */
    @Service(functionId = "840206", desc = "LS_指令管理_指令委托")
	public ZlinsadminInsentrustResponse insentrust(ZlinsadminInsentrustRequest req);
	/**
	 * LS_指令管理_获取指令列表
	 * @param InslistRequest
	 * @return InslistResponse
	 */
    @Service(functionId = "840201", desc = "LS_指令管理_获取指令列表")
	public ZlinsadminInslistResponse inslist(ZlinsadminInslistRequest req);
	/**
	 * LS_指令管理_操作流水
	 * @param InsoCancelRequest
	 * @return InsoCancelResponse
	 */
    @Service(functionId = "840209", desc = "LS_指令管理_操作流水")
	public ZlinsadminInsopResponse insop(ZlinsadminInsopRequest req);
	/**
	 * LS_指令管理_触犯风控
	 * @param InsriskRequest
	 * @return InsriskResponse
	 */
    @Service(functionId = "840208", desc = "LS_指令管理_触犯风控")
	public ZlinsadminInsriskResponse insrisk(ZlinsadminInsriskRequest req);
	/**
	 * LS_指令管理_指令证券
	 * @param InsstockRequest
	 * @return InsstockResponse
	 */
    @Service(functionId = "840205", desc = "LS_指令管理_指令证券")
	public ZlinsadminInsstockResponse insstock(ZlinsadminInsstockRequest req);

}