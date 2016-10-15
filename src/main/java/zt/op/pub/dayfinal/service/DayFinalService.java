package zt.op.pub.dayfinal.service;

import com.hundsun.jresplus.remoting.impl.annotation.Service;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceModule;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceParam;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceResult;

@ServiceModule
public interface DayFinalService {
	@Service(functionId = "801400", desc = "日终")
	public void dayFinalArchive();

}
