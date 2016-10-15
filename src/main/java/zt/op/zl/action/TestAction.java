package zt.op.zl.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import zt.op.zl.object.InstructionDTO;
import zt.op.zl.remote.TestRemote;

@Controller
@RequestMapping("/zl/test")
public class TestAction {
	
	@Autowired
	TestRemote testRemote;
	
	@RequestMapping("/list")
	public void test() {
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String addSubmit(@RequestParam("data") String data, ModelMap model) {
		InstructionDTO i = new InstructionDTO();
		i.setInsId(data.hashCode());
		i.setBusinessDate(12345678);
		i.setDirectOperator(2);
		i.setInsStatus("2");
		i.setInsUpdateTime(23456);
		i.setTradeOperator(3);
		i.setRemark("中文");
		
		testRemote.instructionAdd(i);
		return "/zl/test/post";
	}

}

