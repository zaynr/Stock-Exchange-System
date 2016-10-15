package zt.op.pub.login.service;

import com.hundsun.jresplus.remoting.impl.annotation.Service;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceModule;

import zt.op.common.dto.ResultDTO;
import zt.op.common.dto.TokenQueryRequest;

@ServiceModule
public interface LoginService {
	
	@Service(functionId = "810203",desc = "判断令牌是否存在")
	ResultDTO judgeToken(TokenQueryRequest req);
	
}
