package zt.op.common.util;

/**
 * @Description 常量类，常用的常量存放到Contants
 * @company 恒生电子股份有限公司
 * @author huangjl09192
 * @date 2014年12月30日
 */
public class Constants{
	public static final String LAYOUT_WIDTH_UPDATE = "列宽度调整成功"; 
	public static final String LAYOUT_INDEX_UPDATE = "列位置调整成功"; 
	//public static final String ADD_SUCCESS_MESSAGE = "新增成功";
	//public static final String UPDATE_SUCCESS_MESSAGE = "修改成功";
	//public static final String DELETE_SUCCESS_MESSAGE = "删除成功";
	//public static final String ERROR_CODE = "错误号：";
	//public static final String ERROR_INFO = "错误信息：";
	public static final Integer SYSTEM_COMPANY_ID = 9998;
	public static final String SYSTEM_OPERATOR_CODE = "999800001"; //超级管理员
	public static final Integer DEFOULT_PAGE_SIZE = 100;
	public static final String FORCE_CHG_PASSWORD = "1"; //强制修改密码
	
	/*
	 *操作员维护 
	 */
	public static final String OPERATIONAL_CUSTOMER  = "1";//客户人员
	public static final String OPERATIONAL_PERSONNEL = "2";//运维人员
	
	/*
	 * 往来机构类型列表常量
	 */
	public static final String ORG_TYPE_BANK = "1";//银行
	public static final String ORG_TYPE_BROKER = "2";//券商
	public static final String ORG_TYPE_ISSUER = "3";//发行人
	public static final String ORG_TYPE_COUNTERPARTY = "4";//交易对手
	public static final String ORG_TYPE_ORIGINATOR = "5";//原始权益人
	public static final String ORG_TYPE_GUARANTEE = "6";//担保人
	public static final String ORG_TYPE_UNDERWRITING = "7";//承销机构
	public static final String ORG_TYPE_CUSTODIAN = "8";//托管机构
	public static final String ORG_TYPE_RATING = "9";//债券评级机构
	
	/*
	 * 导出
	 */
	public static final Short DEFOULT_FONT_ZIZE = 10;//前端12像素,10号字体
	public static final String DEFOULT_FONT_NAME = "微软雅黑";
	public static final String GRID_ALIGIN_RIGHT_FIELD_TYPE[] = {"F","A","N"}; //需要右对齐的字段类型

	
	/*
	 * 经纪商,营业部缺省名称
	 */
	public static final String 	DEFAULT_BROKERNAME = "缺省经纪商";//缺省经纪商名称
	public static final String 	DEFAULT_BRANCHNAME = "缺省营业部";//缺省经纪商名称
	public static final String 	DEFAULT_WU = "无";//无
	
	//资产类别
	public static final String 	ASSETTYPE_OPTION = "a";//期权资产
	
	//经纪商类别
	public static final String 	XHBROKER_TYPE = "1";//现货
	public static final String 	QHBROKER_TYPE = "2";//期货
	
	public static final Integer SROCK_TYPE = 1;//股票
	
	//交易市场类别
	//沪深
	public static final Integer DICT_MARKETNO_SH = 1;//上交所
	public static final Integer DICT_MARKETNO_SZ = 2;//深交所
	//期货
	public static final Integer DICT_MARKETNO_SQS = 3;//上期所
	public static final Integer DICT_MARKETNO_ZSS = 4;//郑商所
	public static final Integer DICT_MARKETNO_ZJS = 7;//中金所
	public static final Integer DICT_MARKETNO_DSS = 9;//大商所
	/**现货交易市场编号列表**/
	public static final String XH_MARKET_NO_LIST = "1,2,10,35";
	/**期货交易市场编号列表**/
	public static final String QH_MARKET_NO_LIST = "3,4,7,9" ;
	/**银行间交易市场编号列表**/
	public static final String YH_MARKET_NO_LIST = "5" ;
	
	//指数
	/**沪深300**/
	public static final String CSI300 = "000300";
    /**上证50**/
	public static final String SSE50 = "000016";
	/**中证300**/
	public static final String CSI500 = "000905";
	
	/**系统参数是否开启站点登录验证**/
	public static final Integer SYSPARAM_NO = 100010;

}
