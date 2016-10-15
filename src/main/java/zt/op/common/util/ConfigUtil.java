package zt.op.common.util;

import java.util.Properties;

/**
 * @author qiujm
 * @date 2013年12月24日 上午11:15:47 
 * @Description: 操作配置文件类
 */
public class ConfigUtil {
	private static Properties _config;

	public static void setConfig(Properties config)
	{
		_config = config;
	}
	public static String getConfig(String key)
	{
		return _config.getProperty(key);
	}
}

