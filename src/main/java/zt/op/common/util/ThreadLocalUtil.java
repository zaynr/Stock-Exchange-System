package zt.op.common.util;

import zt.op.common.dto.MsgInThreadDTO;

public class ThreadLocalUtil {

	private static ThreadLocal<MsgInThreadDTO> msgInThreadLocal = new ThreadLocal<MsgInThreadDTO>();

	public static void SetMsgInThread(MsgInThreadDTO MsgInThreadDTO) {
		msgInThreadLocal.set(MsgInThreadDTO);
	}

	public static MsgInThreadDTO getMsgInThreadDTO() {
		return msgInThreadLocal.get();
	}

	public static void removeOperator() {
		msgInThreadLocal.remove();
	}
}
