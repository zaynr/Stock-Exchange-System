package zt.op.offer.service;

import com.hundsun.jresplus.remoting.impl.annotation.Service;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceModule;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceParam;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceResult;

import zt.op.common.dto.AckDTO;
import zt.op.common.dto.AckResponseDTO;
import zt.op.common.dto.DealRequestDTO;
import zt.op.common.dto.DealResponseDTO;
import zt.op.common.dto.OfferEntrustQueryRequestDTO;
import zt.op.common.dto.OfferEntrustQueryResponseDTO;
import zt.op.common.dto.OfferEntrustWithdrawRequestDTO;
import zt.op.common.dto.OfferEntrustWithdrawResponseDTO;
import zt.op.common.dto.ZyjyDealhandleRequestDTO;

@ServiceModule
public interface OfferServices {
	@Service(functionId = "302", desc = "前置机, 委托确认")
	public AckResponseDTO entrustAck(AckDTO dto);
	
	@Service(functionId = "304", desc = "前置机, 委托撤单")
	public OfferEntrustWithdrawResponseDTO entrustWithdraw(OfferEntrustWithdrawRequestDTO dto);
	
	@Service(functionId = "401", desc = "前置机, 委托查询")
	public OfferEntrustQueryResponseDTO entrustQuery(OfferEntrustQueryRequestDTO dto);
	
	@Service(functionId = "402", desc = "前置机, 成交查询")
	public DealResponseDTO entrustDealQuery(DealRequestDTO dto);
	
	@Service(functionId = "830243", desc = "LS_自由交易_成交处理")
	public DealResponseDTO dealHandler(ZyjyDealhandleRequestDTO dto);
}
