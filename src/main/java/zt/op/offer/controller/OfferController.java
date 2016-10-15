package zt.op.offer.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zt.op.common.dto.AckDTO;
import zt.op.common.dto.AckResponseDTO;
import zt.op.common.dto.DealRequestDTO;
import zt.op.common.dto.DealResponseDTO;
import zt.op.common.dto.EntrustConfirmRequest;
import zt.op.common.dto.EntrustQueryResponse;
import zt.op.common.dto.EntrustStockCodeTransferRequestDTO;
import zt.op.common.dto.OfferEntrustQueryRequestDTO;
import zt.op.common.dto.OfferEntrustQueryResponseDTO;
import zt.op.common.dto.ZyjyDealhandleRequestDTO;
import zt.op.offer.service.OfferServices;
import zt.op.pub.entrust.service.EntrustServices;

@Controller
@RequestMapping("/offer")
public class OfferController implements ServletContextListener {
	@Autowired
	private OfferServices offerServices;

	@Autowired
	private EntrustServices entrustService;

	private EntrustQueryResponse entrustQueryResponse;

	@RequestMapping("/run")
	public void runOffer(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("siteName", "报盘|O++交易系统");
		new Thread(new AckEntrust()).start();
		new Thread(new DealQuery()).start();
	}

	private class AckEntrust implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			EntrustQueryResponse entrustQueryResponse = entrustService.getUnconfirmedEntrust();
			for (int i = 0; i < entrustQueryResponse.getRowCount(); i++) {
				AckDTO ackDTO = new AckDTO();
				AckResponseDTO responseDTO;
				EntrustConfirmRequest entrustConfirmRequest = new EntrustConfirmRequest();
				ackDTO.setSeatNo("24838");
				ackDTO.setFundAccount(entrustQueryResponse.getRows().get(i).getCapitalAccountId());
				ackDTO.setPassword("1");
				if (entrustQueryResponse.getRows().get(i).getMarketNo().equals("1")) {
					ackDTO.setStockAccount("D70000000" + entrustQueryResponse.getRows().get(i).getCapitalAccountId()
							.charAt(entrustQueryResponse.getRows().get(i).getCapitalAccountId().length() - 1));
				} else {
					ackDTO.setStockAccount("070000000" + entrustQueryResponse.getRows().get(i).getCapitalAccountId()
							.charAt(entrustQueryResponse.getRows().get(i).getCapitalAccountId().length() - 1));
				}
				ackDTO.setStockCode(entrustQueryResponse.getRows().get(i).getReportCode());
				ackDTO.setExchangeType(entrustQueryResponse.getRows().get(i).getMarketNo());
				ackDTO.setEntrustPrice(entrustQueryResponse.getRows().get(i).getEntrustPrice());
				ackDTO.setEntrustAmount(entrustQueryResponse.getRows().get(i).getEntrustAmount());
				ackDTO.setEntrustBs(entrustQueryResponse.getRows().get(i).getEntrustDirection());
				responseDTO = offerServices.entrustAck(ackDTO);

				entrustConfirmRequest.setEntrustSerialNo(entrustQueryResponse.getRows().get(i).getEntrustSerialNo());
				entrustConfirmRequest.setConfirmCodeno(responseDTO.getEntrustNo());
				entrustService.entrustConfirm(entrustConfirmRequest);
			}
		}
	}

	private class DealQuery implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			// 成交查询
			EntrustQueryResponse entrustQueryResponse = entrustService.entrustQueryAll();
			for (int i = 0; i < entrustQueryResponse.getRowCount(); i++) {
				DealRequestDTO dealRequestDTO = new DealRequestDTO();
				ZyjyDealhandleRequestDTO zyjyDealhandleRequestDTO = new ZyjyDealhandleRequestDTO();
				DealResponseDTO dealResponseDTO;

				dealRequestDTO.setFundAccount(entrustQueryResponse.getRows().get(i).getCapitalAccountId());
				dealRequestDTO.setRequestNum("1");
				dealRequestDTO.setSerialNo(entrustQueryResponse.getRows().get(i).getConfirmCodeno());
				dealRequestDTO.setPassword("1");
				dealResponseDTO = offerServices.entrustDealQuery(dealRequestDTO);
				if (dealResponseDTO != null) {
					// LS_自由交易_成交处理
					EntrustStockCodeTransferRequestDTO dto = new EntrustStockCodeTransferRequestDTO();
					zyjyDealhandleRequestDTO
							.setCapitalAccountId(entrustQueryResponse.getRows().get(i).getCapitalAccountId());
					zyjyDealhandleRequestDTO
							.setEntrustSerialNo(entrustQueryResponse.getRows().get(i).getEntrustSerialNo());
					zyjyDealhandleRequestDTO.setConfirmCodeno(entrustQueryResponse.getRows().get(i).getConfirmCodeno());
					dto.setReportCode(entrustQueryResponse.getRows().get(i).getReportCode());
					zyjyDealhandleRequestDTO.setInterCode(entrustService.stockCodeTransfer(dto).getInterCode());
					zyjyDealhandleRequestDTO
							.setEntrustDirection(entrustQueryResponse.getRows().get(i).getEntrustDirection());
					zyjyDealhandleRequestDTO.setDealAmount(dealResponseDTO.getBusinessAmount());
					zyjyDealhandleRequestDTO.setDealPrice(dealResponseDTO.getBusinessPrice());
					zyjyDealhandleRequestDTO.setDealTime(dealResponseDTO.getBusinessTime());
					zyjyDealhandleRequestDTO.setDealNo(dealResponseDTO.getReportNo());
					offerServices.dealHandler(zyjyDealhandleRequestDTO);
				}
			}
		}
	}

	@RequestMapping("/entrusts.json")
	@ResponseBody
	public Map<String, Object> getEntrusts(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<OfferEntrustQueryResponseDTO> res = new ArrayList<>();

		new Thread(new AckEntrust()).start();
		new Thread(new DealQuery()).start();

		entrustQueryResponse = entrustService.entrustQueryAll();
		// 委托查询
		for (int i = 0; i < entrustQueryResponse.getRowCount(); i++) {
			OfferEntrustQueryRequestDTO offerEntrustQueryRequestDTO = new OfferEntrustQueryRequestDTO();
			OfferEntrustQueryResponseDTO offerEntrustQueryResponseDTO;
			offerEntrustQueryRequestDTO.setFundAccount(entrustQueryResponse.getRows().get(i).getCapitalAccountId());
			offerEntrustQueryRequestDTO.setRequestNum("1");
			offerEntrustQueryRequestDTO.setQueryDirection("1");
			offerEntrustQueryRequestDTO.setSortDirection("0");
			offerEntrustQueryRequestDTO.setLocateEntrustNo(entrustQueryResponse.getRows().get(i).getConfirmCodeno());
			offerEntrustQueryRequestDTO.setPassword("1");
			offerEntrustQueryResponseDTO = offerServices.entrustQuery(offerEntrustQueryRequestDTO);
			if (offerEntrustQueryResponseDTO != null) {
				res.add(offerEntrustQueryResponseDTO);
			} else {
				System.out.println("null");
			}
		}

		// 撤单

		map.put("tableContent", res);
		map.put("pageSize", entrustQueryResponse.getRowCount());
		return map;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	private class runOffer implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			try {
				while (true) {
					URL url;
					url = new URL("http://localhost:8080/OplusplusWeb/offer/run.htm");
					// url = new URL("http://www.baidu.com");
					URLConnection urlcon = url.openConnection();
					urlcon.connect();// 获取输入流
					BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
					String line;
					StringBuilder sb = new StringBuilder();
					while ((line = br.readLine()) != null) {// 循环读取流
						sb.append(line);
					}
					Thread.sleep(4000);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		new Thread(new runOffer()).start();
	}

}
