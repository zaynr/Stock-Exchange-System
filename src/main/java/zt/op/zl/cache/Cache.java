package zt.op.zl.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zt.op.zl.dto.ZlinsaddGetaccountsResponse;
import zt.op.zl.dto.ZlinsaddGetreportsResponse;
import zt.op.zl.remote.IInsaddService;

public class Cache {
	
	private static List<ZlinsaddGetreportsResponse> reports;
	private static List<ZlinsaddGetaccountsResponse> accounts;
	private static Map<String,Integer> reportSelect;
	
	public static List<ZlinsaddGetreportsResponse> reports(IInsaddService iInsaddService){
		if(reports==null) {
			reports = iInsaddService.getreports();
		}
		return reports;
	}
	
	public static Map<String,Integer> reportselect(IInsaddService iInsaddService){
		if(reports==null) {
			reports = iInsaddService.getreports();
		}
		if(reportSelect==null) {
			reportSelect = new HashMap<String,Integer>();
			for(ZlinsaddGetreportsResponse r:reports){
				int market = r.getMarketNo();
				String ms = "";
				if(market == 1)
					ms = "沪 ";
				else if(market == 2)
					ms = "深 ";
				reportSelect.put(ms+r.getReportCode()+" "+r.getStockName(), r.getInterCode());
			}
		}
		return reportSelect;
	}
	
	public static List<ZlinsaddGetaccountsResponse> accounts(IInsaddService iInsaddService){
		if(accounts==null) {
			accounts = iInsaddService.getaccounts();
		}
		return accounts;
	}
}
