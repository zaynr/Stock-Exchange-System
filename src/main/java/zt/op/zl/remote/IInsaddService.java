package zt.op.zl.remote;


import com.hundsun.jresplus.remoting.impl.annotation.Service;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceModule;

import zt.op.zl.dto.ZlinsaddGetaccountsResponse;
import zt.op.zl.dto.ZlinsaddGetreportsResponse;
import zt.op.zl.dto.ZlinsaddSingleinsAddRequest;
import zt.op.zl.dto.ZlinsaddSingleinsAddResponse;
import zt.op.zl.dto.ZlinsaddWarninscontinueRequest;
import zt.op.zl.dto.ZlinsaddGetassetRequest;
import zt.op.zl.dto.ZlinsaddGetassetResponse;
import zt.op.zl.dto.ZlinsaddGetpositionRequest;
import zt.op.zl.dto.ZlinsaddGetpositionResponse;

import java.util.List;

@ServiceModule
public interface IInsaddService {
	/**
	 * LS_指令下达_获取帐号列表
	 * @return GetaccountsResponse
	 */
    @Service(functionId = "840111", desc = "LS_指令下达_获取帐号列表")
	public List<ZlinsaddGetaccountsResponse> getaccounts();
	/**
	 * LS_指令下达_获取证券基本信息
	 * @return GetreportsResponse
	 */
    @Service(functionId = "840112", desc = "LS_指令下达_获取证券基本信息")
	public List<ZlinsaddGetreportsResponse> getreports();
	/**
	 * LS_指令下达_单产品指令下达
	 * @param SingleinsAddRequest
	 * @return SingleinsAddResponse
	 */
    @Service(functionId = "840101", desc = "LS_指令下达_单产品指令下达")
	public ZlinsaddSingleinsAddResponse singleinsAdd(ZlinsaddSingleinsAddRequest req);
	/**
	 * LS_指令下达_触警指令继续下达
	 * @param WarninscontinueRequest
	 */
    @Service(functionId = "840102", desc = "LS_指令下达_触警指令继续下达")
	public void warninscontinue(ZlinsaddWarninscontinueRequest req);
	/**
	 * LS_指令下达_获取资产信息
	 * @param GetassetRequest
	 * @return GetassetResponse
	 */
    @Service(functionId = "840113", desc = "LS_指令下达_获取资产信息")
	public ZlinsaddGetassetResponse getasset(ZlinsaddGetassetRequest req);
	/**
	 * LS_指令下达_获取持仓
	 * @param GetpositionRequest
	 * @return GetpositionResponse
	 */
    @Service(functionId = "840114", desc = "LS_指令下达_获取持仓")
	public List<ZlinsaddGetpositionResponse> getposition(ZlinsaddGetpositionRequest req);

}