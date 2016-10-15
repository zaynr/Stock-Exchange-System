package zt.op.zl.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hundsun.jresplus.exception.BaseException;

import zt.op.zl.cache.Cache;
import zt.op.zl.dto.ZlinsaddGetaccountsResponse;
import zt.op.zl.dto.ZlinsaddGetassetRequest;
import zt.op.zl.dto.ZlinsaddGetassetResponse;
import zt.op.zl.dto.ZlinsaddGetpositionRequest;
import zt.op.zl.dto.ZlinsaddGetpositionResponse;
import zt.op.zl.dto.ZlinsaddSingleinsAddRequest;
import zt.op.zl.dto.ZlinsaddSingleinsAddResponse;
import zt.op.zl.dto.ZlinsaddWarninscontinueRequest;
import zt.op.zl.object.OfkcompliancesetRisk_rows;
import zt.op.zl.remote.IInsaddService;

@Controller
@RequestMapping("/zl/add")
public class AddAction {
	
	@Autowired
	IInsaddService iInsaddService;
	
	@RequestMapping("/list")
	public void init(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("siteName", "指令下达|O++交易系统");
	}
	
	@RequestMapping(value = "/query.json")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request){
		Integer id = Integer.parseInt(request.getParameter("account"));
		
		ZlinsaddGetassetRequest assetReq = new ZlinsaddGetassetRequest();
		assetReq.setCapitalAccountId(id);
		ZlinsaddGetassetResponse assetRes = iInsaddService.getasset(assetReq);
		
		ZlinsaddGetpositionRequest stockReq = new ZlinsaddGetpositionRequest();
		stockReq.setCapitalAccountId(id);
		List<ZlinsaddGetpositionResponse> stockRes = iInsaddService.getposition(stockReq);
		
		Map<String,Integer> reports = Cache.reportselect(iInsaddService);
		
		List<ZlinsaddGetaccountsResponse> accounts = Cache.accounts(iInsaddService);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("asset", assetRes);
		map.put("stock", stockRes);
		map.put("reports", reports.keySet());
		map.put("accounts", accounts);
		return map;
	}
	
	@RequestMapping(value = "/add.json")
	@ResponseBody
	public Map<String, Object> add(HttpServletRequest request){
		Map<String,Integer> reports = Cache.reportselect(iInsaddService);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int id;
		double insPrice;
		double insAmount;
		double insBalance;
		int interCode;
		int entrustDirection;
		int tradeOperator;
		try {
			id = Integer.parseInt(request.getParameter("account"));
			insPrice = Double.parseDouble(request.getParameter("insPrice"));
			insAmount = Double.parseDouble(request.getParameter("insAmount"));
			insBalance = Double.parseDouble(request.getParameter("insBalance"));
			interCode = reports.get(request.getParameter("report"));
			entrustDirection = Integer.parseInt(request.getParameter("entrustDirection"));
			tradeOperator = Integer.parseInt(request.getParameter("tradeOperator"));
		} catch (NumberFormatException e) {
			map.put("error", "输入错误");
			return map;
		}
		String remark = request.getParameter("remark");
		
		ZlinsaddSingleinsAddRequest req = new ZlinsaddSingleinsAddRequest();
		req.setDirectOperator(id);
		req.setEntrustDirection(entrustDirection);
		req.setInsAmount(insAmount);
		req.setInsBalance(insBalance);
		req.setInsPrice(insPrice);
		req.setInterCode(interCode);
		req.setRemark(remark);
		req.setTradeOperator(tradeOperator);
		ZlinsaddSingleinsAddResponse res;
		try {
			res = iInsaddService.singleinsAdd(req);
		} catch (BaseException e) {
			map.put("error", e.getErrorProperties().get("error_info"));
			return map;
		}
		Integer risk = res.getRiskResult();
		List<OfkcompliancesetRisk_rows> riskDetail = res.getRiskRows();
		
		map.put("risk", risk);
		map.put("riskDetail", riskDetail);
		if(risk == 2){
			map.put("account", id);
			map.put("insPrice", insPrice);
			map.put("insAmount", insAmount);
			map.put("insBalance", insBalance);
			map.put("interCode", interCode);
			map.put("entrustDirection", entrustDirection);
			map.put("tradeOperator", tradeOperator);
			map.put("remark", remark);
			map.put("insId", res.getInsId());
			map.put("insStockId", res.getInsStockId());
			map.put("serialNo", res.getSerialNo());
		}
		return map;
	}
	
	@RequestMapping(value = "/continue.json")
	@ResponseBody
	public Map<String, Object> warnContinue(HttpServletRequest request){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		int id;
		double insPrice;
		double insAmount;
		double insBalance;
		int interCode;
		int entrustDirection;
		int tradeOperator;
		int insId;
		int insStockId;
		int serialNo;
		try {
			id = Integer.parseInt(request.getParameter("account"));
			insPrice = Double.parseDouble(request.getParameter("insPrice"));
			insAmount = Double.parseDouble(request.getParameter("insAmount"));
			insBalance = Double.parseDouble(request.getParameter("insBalance"));
			interCode = Integer.parseInt(request.getParameter("report"));
			entrustDirection = Integer.parseInt(request.getParameter("entrustDirection"));
			tradeOperator = Integer.parseInt(request.getParameter("tradeOperator"));
			insId = Integer.parseInt(request.getParameter("insId"));
			insStockId = Integer.parseInt(request.getParameter("insStockId"));
			serialNo = Integer.parseInt(request.getParameter("serialNo"));
		} catch (NumberFormatException e) {
			map.put("error", "输入错误");
			return map;
		}
		String remark = request.getParameter("remark");
		
		ZlinsaddWarninscontinueRequest req = new ZlinsaddWarninscontinueRequest();
		req.setDirectOperator(id);
		req.setEntrustDirection(entrustDirection);
		req.setInsAmount(insAmount);
		req.setInsBalance(insBalance);
		req.setInsPrice(insPrice);
		req.setInterCode(interCode);
		req.setRemark(remark);
		req.setTradeOperator(tradeOperator);
		req.setInsId(insId);
		req.setInsStockId(insStockId);
		req.setSerialNo(serialNo);
		
		System.out.println(interCode);
		try {
			iInsaddService.warninscontinue(req);
		} catch (BaseException e) {
			map.put("error", e.getErrorProperties().get("error_info"));
			return map;
		}
		
		return map;
	}
}
