package zt.op.pub.entrust.service;

import com.hundsun.jresplus.remoting.impl.annotation.Service;
import com.hundsun.jresplus.remoting.impl.annotation.ServiceModule;

import zt.op.common.dto.EntrustConfirmRequest;
import zt.op.common.dto.EntrustQueryRequest;
import zt.op.common.dto.EntrustQueryResponse;
import zt.op.common.dto.EntrustStockCodeTransferRequestDTO;
import zt.op.common.dto.EntrustStockCodeTransferResponseDTO;
import zt.op.common.dto.OfferDealEntrustRequestDTO;
import zt.op.common.dto.StatusTranslateRequest;
import zt.op.common.dto.StatusTranslateResponse;

@ServiceModule
public interface EntrustServices {
	@Service(functionId = "810300", desc = "entrust query")
	public EntrustQueryResponse entrustQuery(EntrustQueryRequest queryRequest);

	@Service(functionId = "810302", desc = "status translate")
	public StatusTranslateResponse statusTranslate(StatusTranslateRequest request);

	@Service(functionId = "810303", desc = "confirm entrust")
	public void entrustConfirm(EntrustConfirmRequest request);

	@Service(functionId = "810304", desc = "deal entrust")
	public void entrustDeal(OfferDealEntrustRequestDTO request);

	@Service(functionId = "810306", desc = "stock code transfer")
	public EntrustStockCodeTransferResponseDTO stockCodeTransfer(EntrustStockCodeTransferRequestDTO dto);

	@Service(functionId = "810307", desc = "deal entrust")
	public EntrustQueryResponse getUnconfirmedEntrust();

	@Service(functionId = "810308", desc = "entrust query all")
	public EntrustQueryResponse entrustQueryAll();
}
