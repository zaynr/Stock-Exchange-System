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
import zt.op.zl.remote.IInsaddService;
import zt.op.zl.remote.IInsadminService;

@Controller
@RequestMapping("/zl/admin")
public class AdminAction {

	@Autowired
	IInsadminService iInsadminService;
	
	@Autowired
	IInsaddService iInsaddService;
	
	@RequestMapping("/list")
	public void init(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("siteName", "指令管理|O++交易系统");
	}
	
	@RequestMapping(value = "/query.json")
	@ResponseBody
	public Map<String, Object> query(HttpServletRequest request){
		Integer id = Integer.parseInt(request.getParameter("account"));
		
		List<ZlinsaddGetaccountsResponse> accounts = Cache.accounts(iInsaddService);
		
		ZlinsadminInslistRequest listReq = new ZlinsadminInslistRequest();
		listReq.setDirectOperator(id);
		ZlinsadminInslistResponse listRes = iInsadminService.inslist(listReq);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accounts", accounts);
		map.put("list", listRes.getRow());
		return map;
	}
	
	@RequestMapping(value = "/cancel.json")
	@ResponseBody
	public Map<String, Object> cancel(HttpServletRequest request){
		Integer insId = Integer.parseInt(request.getParameter("insId"));
		Integer operatorNo = Integer.parseInt(request.getParameter("account"));
		
		ZlinsadminInsCancelRequest req = new ZlinsadminInsCancelRequest();
		req.setInsId(insId);
		req.setOperatorNo(operatorNo);
		req.setRemark("撤销");
		ZlinsadminInsCancelResponse res;

		Map<String, Object> map = new HashMap<String, Object>();
		try {
			res = iInsadminService.insCancel(req);
		} catch (BaseException e) {
			map.put("error", e.getErrorProperties().get("error_info"));
			return map;
		}
		map.put("insStatus", res.getInsStatus());
		return map;
	}
	
	@RequestMapping(value = "/detail.json")
	@ResponseBody
	public Map<String, Object> detail(HttpServletRequest request){
		Integer insId = Integer.parseInt(request.getParameter("insId"));
		
		List<ZlinsaddGetaccountsResponse> accounts = Cache.accounts(iInsaddService);
		
		ZlinsadminInsdetailRequest req = new ZlinsadminInsdetailRequest();
		req.setInsId(insId);
		ZlinsadminInsdetailResponse res = iInsadminService.insdetail(req);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accounts", accounts);
		map.put("detail", res);
		return map;
	}
	
	@RequestMapping(value = "/stock.json")
	@ResponseBody
	public Map<String, Object> stock(HttpServletRequest request){
		Integer insId = Integer.parseInt(request.getParameter("insId"));
		
		ZlinsadminInsstockRequest req = new ZlinsadminInsstockRequest();
		req.setInsId(insId);
		ZlinsadminInsstockResponse res = iInsadminService.insstock(req);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stock", res);
		return map;
	}
	
	@RequestMapping(value = "/entrust.json")
	@ResponseBody
	public Map<String, Object> entrust(HttpServletRequest request){
		Integer insId = Integer.parseInt(request.getParameter("insId"));
		
		ZlinsadminInsentrustRequest req = new ZlinsadminInsentrustRequest();
		req.setInsId(insId);
		ZlinsadminInsentrustResponse res = iInsadminService.insentrust(req);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entrust", res.getRow());
		return map;
	}
	
	@RequestMapping(value = "/deal.json")
	@ResponseBody
	public Map<String, Object> deal(HttpServletRequest request){
		Integer insId = Integer.parseInt(request.getParameter("insId"));
		
		ZlinsadminInsdealRequest req = new ZlinsadminInsdealRequest();
		req.setInsId(insId);
		ZlinsadminInsdealResponse res = iInsadminService.insdeal(req);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("deal", res.getRow());
		return map;
	}
	
	@RequestMapping(value = "/risk.json")
	@ResponseBody
	public Map<String, Object> risk(HttpServletRequest request){
		Integer insId = Integer.parseInt(request.getParameter("insId"));
		
		ZlinsadminInsriskRequest req = new ZlinsadminInsriskRequest();
		req.setInsId(insId);
		ZlinsadminInsriskResponse res = iInsadminService.insrisk(req);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("risk", res.getRow());
		return map;
	}
	
	@RequestMapping(value = "/op.json")
	@ResponseBody
	public Map<String, Object> op(HttpServletRequest request){
		Integer insId = Integer.parseInt(request.getParameter("insId"));

		List<ZlinsaddGetaccountsResponse> accounts = Cache.accounts(iInsaddService);
		
		ZlinsadminInsopRequest req = new ZlinsadminInsopRequest();
		req.setInsId(insId);
		ZlinsadminInsopResponse res = iInsadminService.insop(req);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("accounts", accounts);
		map.put("op", res.getRow());
		return map;
	}
}
