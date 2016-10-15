package zt.op.pub.entrust.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zt.op.common.dto.EntrustQueryDTO;
import zt.op.common.dto.EntrustQueryRequest;
import zt.op.common.dto.EntrustQueryResponse;
import zt.op.common.dto.StatusTranslateRequest;
import zt.op.common.dto.StatusTranslateResponse;
import zt.op.pub.entrust.service.EntrustServices;

@Controller
@RequestMapping("/pub/entrust")
public class EntrustQueryController {
	@Autowired
	private EntrustServices entrustService;

	@RequestMapping("/entrust-query")
	public void pageInit(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("siteName", "委托查询|O++交易系统");
	}

	@RequestMapping(value = "/query.json")
	@ResponseBody
	public Map<String, Object> entrustQuery(HttpServletRequest request) {
		EntrustQueryRequest queryRequest = new EntrustQueryRequest();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> codes = new HashMap<String, Object>();
		List<EntrustQueryDTO> res;
		Calendar now = Calendar.getInstance();
		String today = String.valueOf(now.get(Calendar.YEAR));
		if ((now.get(Calendar.MONTH) + 1) < 10) {
			today = today + "0" + String.valueOf((now.get(Calendar.MONTH) + 1))
					+ String.valueOf(now.get(Calendar.DAY_OF_MONTH));
		} else {
			today = today + String.valueOf((now.get(Calendar.MONTH) + 1))
					+ String.valueOf(now.get(Calendar.DAY_OF_MONTH));
		}
		if (today.equals(request.getParameter("endDate").replace("-", ""))) {
			queryRequest.setTableName("jy_tentrusts");
		} else {
			queryRequest.setTableName("his_jy_tentrusts");
		}
		queryRequest.setCapitalAccountId(request.getParameter("capitalAccountId"));
		queryRequest.setBeginDate(request.getParameter("startDate").replace("-", ""));
		queryRequest.setEndDate(request.getParameter("endDate").replace("-", ""));
		int pageIndex = Integer.valueOf(request.getParameter("pageIndex"));
		int pageSize = 10;
		queryRequest.setStartRow(String.valueOf(pageSize * pageIndex));
		queryRequest.setPageSize(String.valueOf(pageSize));
		EntrustQueryResponse response = entrustService.entrustQuery(queryRequest);
		res = response.getRows();

		if (res != null) {
			for (int i = 0; i < res.size(); i++) {
				codes.put(res.get(i).getReportCode(), i);
				res.get(i).setDealPercentage(String.format("%.2f", 100 * Double.valueOf(res.get(i).getBusinAmount())
						/ Double.valueOf(res.get(i).getEntrustAmount())) + "%");
				res.get(i).setEntrustPrice(String.format("%.2f", Double.valueOf(res.get(i).getEntrustPrice())));
				res.get(i).setEntrustAmount(
						String.format("%d", Math.round(Double.valueOf(res.get(i).getEntrustAmount()))));
				res.get(i).setEntrustAmount(
						String.format("%d", Math.round(Double.valueOf(res.get(i).getEntrustAmount()))));
				res.get(i)
						.setCancelAmount(String.format("%d", Math.round(Double.valueOf(res.get(i).getCancelAmount()))));
				res.get(i).setEntrustBalance(String.format("%.2f", Double.valueOf(res.get(i).getEntrustBalance())));
				res.get(i).setBusinAmount(String.format("%.2f", Double.valueOf(res.get(i).getBusinAmount())));
				StatusTranslateRequest req = new StatusTranslateRequest();
				StatusTranslateResponse rep;
				// 1:交易市场, 2:委托方向, 3:委托状态
				req.setDicNo("1");
				req.setSubDicNo(res.get(i).getMarketNo());
				rep = entrustService.statusTranslate(req);
				res.get(i).setMarketNo(rep.getSubDicName());
				req.setDicNo("2");
				req.setSubDicNo(res.get(i).getEntrustDirection());
				rep = entrustService.statusTranslate(req);
				res.get(i).setEntrustDirection(rep.getSubDicName());
				req.setDicNo("3");
				req.setSubDicNo(res.get(i).getEntrustStatus());
				rep = entrustService.statusTranslate(req);
				res.get(i).setEntrustStatus(rep.getSubDicName());
			}
			map.put("tableContent", res);
			map.put("reportCodes", codes.keySet());
			map.put("pageCount", (float) (response.getRowCount()) % pageSize == 0 ? response.getRowCount() / pageSize
					: (response.getRowCount() / pageSize + 1));
			map.put("resSize", response.getRowCount());
			map.put("pageSize", pageSize);
		} else {
			map.put("resSize", 0);
		}
		return map;
	}
}
