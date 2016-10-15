package zt.op.common.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import zt.op.common.dto.MsgInThreadDTO;
import zt.op.common.util.ConfigUtil;
import zt.op.common.util.Constants;
import zt.op.common.util.JsonUtils;
import zt.op.common.util.ThreadLocalUtil;

import com.hundsun.jres.cep.filter.Handler;
import com.hundsun.jres.interfaces.share.dataset.DatasetColumnType;
import com.hundsun.jres.interfaces.share.dataset.IDataset;
import com.hundsun.jres.interfaces.share.dataset.IDatasets;
import com.hundsun.jres.interfaces.share.event.IEvent;
import com.hundsun.jresplus.exception.BaseException;
import com.hundsun.jresplus.remoting.util.DatasetUtil;

/**
 * 
 * @Description T2过滤器,在该类中增加子系统号,路由公司等信息
 * @company 恒生电子股份有限公司
 * @author qiujm
 * @date 2015年3月27日
 */
public class T2ServicesFilter extends Handler {

	private final static Logger logger = LoggerFactory
			.getLogger(T2ServicesFilter.class);
	/**
	 * 子系统号
	 */
	private final static String TAG_SUB_SYSTEM_NO = "4";
	/**
	 * 功能号
	 */
	private final static String TAG_FUNCTION_ID = "5";
	/**
	 * 路由公司
	 */
	private final static String TAG_COMP_ID = "71";
	/**
	 * 功能号前两位和子系统号对应关系
	 */
	private static Map<String, Integer> _subsysNo;//SUBSYS_NO;
	/**
	 * 不需要传userToken信息的功能号,主要是订阅和登录等特殊功能
	 */
	private static List<String> _noRightFun;//NO_RIGHT_FUN;
	/**
	 * 拼装日志时需要忽略的字段,主要是base_dto和base_query里的字段
	 */
	private static List<String> _ignoreColumn;//IGNORE_COLUMN;
	/**
	 * 需要加密的字段
	 */
	private static List<String> _encryptColumn;//ENCRYPT_COLUMN;
	
	private static boolean _isInit = false;
	
	/**
	 * 记录请求开始时间
	 */
	//private static Map<String,Long> _opTime;

	static {
		_subsysNo = new HashMap<String, Integer>();
		_noRightFun = new ArrayList<String>();
		_ignoreColumn = new ArrayList<String>();
		_encryptColumn = new ArrayList<String>();
		//_opTime = new HashMap<String, Long>();

		_subsysNo.put("88", 1);
		_subsysNo.put("10", 1);
		_subsysNo.put("62", 3303);
		

		_noRightFun.add("888888");
		//_noRightFun.add("9205021");// 获取操作员信息
		_noRightFun.add("620777");
		_noRightFun.add("620778");
		_noRightFun.add("100007");// usertoken验证
		_noRightFun.add("100001");
		_noRightFun.add("100162");
		_noRightFun.add("9200045");

		_ignoreColumn.add("login_company");
		_ignoreColumn.add("login_operator");
		_ignoreColumn.add("login_operator_name");
		_ignoreColumn.add("page_no");
		_ignoreColumn.add("menu_id_op");
		_ignoreColumn.add("user_token");

		_ignoreColumn.add("operator_name");
		_ignoreColumn.add("operate_date");
		_ignoreColumn.add("operate_time");
		_ignoreColumn.add("mac");
		_ignoreColumn.add("volserial_no");
		_ignoreColumn.add("computer_name");
		_ignoreColumn.add("login_ip");
		_ignoreColumn.add("subsys_no");
		_ignoreColumn.add("menu_right_id_op");
		_ignoreColumn.add("operator_class");
		_ignoreColumn.add("operator_content");
		_ignoreColumn.add("cancel_flag");
		_ignoreColumn.add("client_type");
		_ignoreColumn.add("check_operator");
		_ignoreColumn.add("time_stamp");
		_ignoreColumn.add("operated_company_id");
		_ignoreColumn.add("operator_detailinfo");
		_ignoreColumn.add("ws_cpu");
		_ignoreColumn.add("remark_long");
		_ignoreColumn.add("func_id");

		_encryptColumn.add("auth_password");
		_encryptColumn.add("capital_password");
		_encryptColumn.add("capital_password_qh");
		_encryptColumn.add("operator_pwd");
		_encryptColumn.add("new_password");
	}
	
	private void initSubsysNo(){
		if(!_isInit){
			_subsysNo.put("91", Integer.parseInt(ConfigUtil.getConfig("PUB_SUBSYS_NO")));
			_subsysNo.put("92", Integer.parseInt(ConfigUtil.getConfig("YH_SUBSYS_NO")));
			_subsysNo.put("93", Integer.parseInt(ConfigUtil.getConfig("ZL_SUBSYS_NO")));
			_subsysNo.put("94", Integer.parseInt(ConfigUtil.getConfig("JY_SUBSYS_NO")));
			_subsysNo.put("95", Integer.parseInt(ConfigUtil.getConfig("BAT_SUBSYS_NO")));
			_subsysNo.put("96", Integer.parseInt(ConfigUtil.getConfig("FK_SUBSYS_NO")));
			_subsysNo.put("97", Integer.parseInt(ConfigUtil.getConfig("CX_SUBSYS_NO")));
			_isInit=true;
		}
	}
	
	

	@Override
	protected ReturnCode handlerInPipeline(IEvent event) {
		String funId = event.getAttributeValue(TAG_FUNCTION_ID);

		if(!funId.startsWith("62")){
			initSubsysNo();
		}
		MsgInThreadDTO msgInThreadDTO = ThreadLocalUtil.getMsgInThreadDTO();
		if (msgInThreadDTO != null) {
			msgInThreadDTO.setFunId(funId);
			ThreadLocalUtil.SetMsgInThread(msgInThreadDTO);
		}

		logger.info("funId:" + funId);//+",tid="+String.valueOf(Thread.currentThread().getId()));
		IDatasets datasets = event.getEventDatas();
		IDataset dataset = datasets.getDataset(0);

		int columnCount = dataset.getColumnCount();
		Map<String, Character> columnMap = new HashMap<String, Character>();

		for (int j = 1; j <= columnCount; j++) {
			columnMap.put(dataset.getColumnName(j), dataset.getColumnType(j));
		}

		int subsysNo = 0;
		subsysNo = getSubSysNo(funId);

		if (subsysNo == 0) {
			BaseException b = new BaseException("-100");
			b.setErrorMessage("功能号不在范围内");
			throw b;
		}
		
		if(dataset.getString("businsys_no")==null ||dataset.getString("businsys_no")==""){
			dataset.addColumn("businsys_no", DatasetColumnType.DS_INT);
		}
		
		if (!funId.startsWith("620") && !funId.equals("888888")) {

			if (funId.startsWith("100")) {
				dataset.updateString("businsys_no",
						ConfigUtil.getConfig("BUSINSYS_NO"));
			} else if (!funId.startsWith("91")) {
				int tagCompId = 0;
				// 设置路由公司id
				if (msgInThreadDTO.getCompanyId() != null
						&& !msgInThreadDTO.getCompanyId().equals("")) {
					tagCompId = Integer.parseInt(msgInThreadDTO.getCompanyId());
					
				} else {
					tagCompId = msgInThreadDTO.getLoginCompany();
				}
				
				event.setIntegerAttributeValue(TAG_COMP_ID, tagCompId);
				
				//9200045这个登录不做功能号替换
				if(tagCompId==Constants.SYSTEM_COMPANY_ID && !funId.equals("9200045")){
					subsysNo= Integer.parseInt(ConfigUtil.getConfig("PUB_SUBSYS_NO"));
				}
			}
		}
		
		event.setIntegerAttributeValue(TAG_SUB_SYSTEM_NO, subsysNo);

		if (!_noRightFun.contains(funId)) {

			//云公共和用户公共下的功能号，需要系统带上以下信息，其他功能号的入参都应该继承BaseQuery或BaseDTO
			if(funId.startsWith("9100") || funId.startsWith("9200")){
				if (!columnMap.containsKey("login_operator")) {
					dataset.addColumn("login_operator", DatasetColumnType.DS_INT);
				}
				if (!columnMap.containsKey("login_company")) {
					dataset.addColumn("login_company", DatasetColumnType.DS_INT);
				}
				if (!columnMap.containsKey("menu_id_op")) {
					dataset.addColumn("menu_id_op", DatasetColumnType.DS_INT);
				}
				if (!columnMap.containsKey("user_token")) {
					dataset.addColumn("user_token", DatasetColumnType.DS_STRING);
				}
				if (dataset.getRowCount() == 0) {
					dataset.appendRow();
				}
				dataset.updateInt("login_operator", msgInThreadDTO.getLoginOperator());
				dataset.updateInt("login_company", msgInThreadDTO.getLoginCompany());
				dataset.updateInt("menu_id_op", msgInThreadDTO.getMenuIdOp());
				dataset.updateString("user_token", msgInThreadDTO.getUserToken());

			} else if (funId.startsWith("10")) {
				if (!columnMap.containsKey("user_token")) {
					dataset.addColumn("user_token", DatasetColumnType.DS_STRING);
				}
				dataset.updateString("user_token", msgInThreadDTO.getUserToken());
			}
			else{
				if (!columnMap.containsKey("login_operator")) {
					BaseException b = new BaseException("-100");
					b.setErrorMessage("入参必须继承BaseQuery或BaseDTO其中一个");
					throw b;
				}
				
				dataset.updateInt("login_operator",msgInThreadDTO.getLoginOperator());
				dataset.updateInt("login_company", msgInThreadDTO.getLoginCompany());
				dataset.updateInt("menu_id_op", msgInThreadDTO.getMenuIdOp());
				dataset.updateString("user_token", msgInThreadDTO.getUserToken());
			}

			if (columnMap.containsKey("login_ip")) {
				// Date date = new Date();
				// SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				dataset.updateString("login_operator_name",
						msgInThreadDTO.getLoginOperatorName());
				dataset.updateString("login_ip", msgInThreadDTO.getLoginIp());
				dataset.updateString("mac", msgInThreadDTO.getMac());
				dataset.updateString("volserial_no",
						msgInThreadDTO.getVolserialNo());
				dataset.updateString("computer_name",
						msgInThreadDTO.getComputerName());
				dataset.updateString("ws_cpu", msgInThreadDTO.getWsCpu());
				dataset.updateInt("subsys_no", subsysNo);
				dataset.updateString("operator_class", "2");
				dataset.updateString("client_type", "2");
				dataset.updateString("func_id", funId);
				if (msgInThreadDTO.getCompanyId() != null
						&& !msgInThreadDTO.getCompanyId().equals("")) {
					dataset.updateInt("operated_company_id",
							Integer.parseInt(msgInThreadDTO.getCompanyId()));
				}
			}
		}

		/*if(!(funId.startsWith("88")||funId.startsWith("62"))){
			String key = String.valueOf(Thread.currentThread().getId())+"-"+funId;
			_opTime.put(key, System.currentTimeMillis());
		}*/
		return ReturnCode.PASS;
	}

	private int getSubSysNo(String fundId) {
		String key = fundId.substring(0, 2);
		if (_subsysNo.containsKey(key)) {
			return _subsysNo.get(key).intValue();
		}

		return 0;
	}

	//这里原先解析操作详情，现在这里不做处理，在aop这边做处理
	/*private Map<String, Object> logList = null;

	private String generateLog(IDataset dataset,Map<String, Character> columnMap) {
		// 遍历单个结果集记录，遍历前首先将指针置到开始
		dataset.beforeFirst();
		String key = "";
		char columnType = ' ';

		while (dataset.hasNext()) {
			dataset.next();

			for (Map.Entry<String, Character> entry : columnMap.entrySet()) {
				key = entry.getKey();

				if (_ignoreColumn.contains(key)) {
					continue;
				}

				columnType = entry.getValue();

				if (columnType == DatasetColumnType.DS_BYTE_ARRAY) {
					byte[] b = dataset.getByteArray(key);

					if (b.length > 0) {
						IDataset childDataset = DatasetUtil.unpack(b, null);
						logList.put(key, generateChildLog(childDataset));
					}
				} else {
					if (dataset.getValue(key) != null
							&& !String.valueOf(dataset.getValue(key))
									.equals("")) {
						if (_encryptColumn.contains(key)) {
							logList.put(key, "******");
						} else {
							logList.put(key, dataset.getValue(key));
						}
					}
				}
			}
		}
		dataset.beforeFirst();
		if (dataset.hasNext()) {
			dataset.next();
		}
		return "";
	}*/

	/*private List<Map<String, Object>> generateChildLog(IDataset dataset) {
		// 遍历单个结果集记录，遍历前首先将指针置到开始
		dataset.beforeFirst();
		String key = "";
		char columnType = ' ';
		List<Map<String, Object>> childList = new ArrayList<Map<String, Object>>();

		Map<String, Character> columnMap = new HashMap<String, Character>();
		int columnCount = dataset.getColumnCount();

		for (int j = 1; j <= columnCount; j++) {
			columnMap.put(dataset.getColumnName(j), dataset.getColumnType(j));
		}

		while (dataset.hasNext()) {
			dataset.next();
			Map<String, Object> map = new HashMap<String, Object>();

			for (Map.Entry<String, Character> entry : columnMap.entrySet()) {
				key = entry.getKey();

				if (_ignoreColumn.contains(key)) {
					continue;
				}

				columnType = entry.getValue();

				if (columnType == DatasetColumnType.DS_BYTE_ARRAY) {
					byte[] b = dataset.getByteArray(key);

					if (b.length > 0) {
						IDataset childDataset = DatasetUtil.unpack(b, null);

						map.put(key, generateChildLog(childDataset));
					}
				} else {
					if (dataset.getValue(key) != null
							&& !String.valueOf(dataset.getValue(key))
									.equals("")) {
						if (_encryptColumn.contains(key)) {
							map.put(key, "******");
						} else {
							map.put(key, dataset.getValue(key));
						}
					}
				}
			}

			childList.add(map);
		}

		return childList;
	}*/

	@Override
	protected ReturnCode handlerOutPipeline(IEvent event) {
		if (event.getErrorNo() != "0" && event.getErrorInfo() != null && !event.getErrorInfo().equals("")) {
			String tagcompanyId = "";
			if(event.getAttributeValue(TAG_COMP_ID)!=null){
				tagcompanyId = ", error_company_id="+ event.getAttributeValue(TAG_COMP_ID);
			}
			if(event.getErrorInfo().toString().contains("error_subsys_id") || event.getErrorInfo().toString().contains("error_company_id")){
				event.setStringAttributeValue("20", event.getErrorInfo());
			}else{
				event.setStringAttributeValue("20", event.getErrorInfo() + "<br />"+"功能号="
						+ event.getAttributeValue(TAG_FUNCTION_ID) +tagcompanyId +  ", error_subsys_id=" + event.getAttributeValue(TAG_SUB_SYSTEM_NO));
			}
			
		}

		String funId = event.getAttributeValue(TAG_FUNCTION_ID);
		logger.info("funId:" + funId+",tid="+String.valueOf(Thread.currentThread().getId()));
		if(!(funId.startsWith("88")||funId.startsWith("62"))){
			//logger.info(String.valueOf(Thread.currentThread().getId()));
			//String key = String.valueOf(Thread.currentThread().getId())+"-"+funId;
			//long startTime= _opTime.get(key);
			//long endTime = System.currentTimeMillis();
			//logger.info("功能号"+funId+"消耗时间:"+(endTime-startTime));
		}
		
		return ReturnCode.PASS;
	}

}
