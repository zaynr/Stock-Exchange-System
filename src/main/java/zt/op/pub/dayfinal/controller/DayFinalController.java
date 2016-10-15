package zt.op.pub.dayfinal.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.datatype.DatatypeDocumentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zt.op.pub.dayfinal.service.DayFinalService;

@Controller
@RequestMapping("/pub/final")
public class DayFinalController {
	@Autowired
	DayFinalService dayFinalService;
	
	@RequestMapping("/final")
	public void pageInit(ModelMap modelMap, HttpServletRequest request){
		modelMap.put("siteName", "日终|O++交易系统");
	}

	@RequestMapping("/final.json")
	@ResponseBody
	public Map<String, Object> startFinal(HttpServletRequest request){
		Map<String, Object> map = new HashMap<>();
		dayFinalService.dayFinalArchive();
		return map;
	}
}
