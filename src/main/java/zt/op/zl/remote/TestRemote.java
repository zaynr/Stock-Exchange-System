package zt.op.zl.remote;

import com.hundsun.jresplus.remoting.impl.annotation.Service;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceModule;

import zt.op.zl.object.InstructionDTO;

@ServiceModule
public interface TestRemote {
    @Service(functionId = "849901", desc = "测试新增")
	public void instructionAdd(InstructionDTO i);
}
