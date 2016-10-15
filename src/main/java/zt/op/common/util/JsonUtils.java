package zt.op.common.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JsonUtils{
	public static String objectToJson(Object obj) {
		if (obj == null) {
			return null;
		} else if (obj instanceof String) {
			StringBuilder sb = new StringBuilder();
			sb.append("\"");
			sb.append((String) obj);
			sb.append("\"");
			return sb.toString();
		} else if (obj instanceof Character) {
			StringBuilder sb = new StringBuilder();
			sb.append("'");
			sb.append(obj.toString());
			sb.append("'");
			return sb.toString();
		} else if (obj instanceof Integer || obj instanceof Long
				|| obj instanceof Double || obj instanceof Float
				|| obj instanceof Byte || obj instanceof Short || obj instanceof Boolean) {
			return obj.toString();
		} else if (obj instanceof BigDecimal) {
			BigDecimal bd = (BigDecimal) obj;
			return bd.toString();
		} else if (obj instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			return sdf.format((Date) obj);
		} else if (obj instanceof Set) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (Iterator it = ((Set) obj).iterator(); it.hasNext();) {
				Object ob = it.next();
				sb.append(objectToJson(ob));
				if (it.hasNext()) {
					sb.append(",");
				}
			}
			sb.append("]");
			return sb.toString();
		} else if (obj instanceof List) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (Iterator it = ((List) obj).iterator(); it.hasNext();) {
				Object ob = it.next();
				sb.append(objectToJson(ob));
				if (it.hasNext()) {
					sb.append(",");
				}
			}
			sb.append("]");
			return sb.toString();
		} else if (obj.getClass().isArray()) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (int i = 0; i < Array.getLength(obj); i++) {
				sb.append(objectToJson(Array.get(obj, i)));
				if (i < Array.getLength(obj) - 1) {
					sb.append(",");
				}
			}
			sb.append("]");
			return sb.toString();
		} else if (obj instanceof Map) {
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			for (Iterator it = ((Map) obj).keySet().iterator(); it.hasNext();) {
				Object key = it.next();
				String keyStr = key.toString();
				sb.append("\"");
				sb.append(keyStr);
				sb.append("\"");
				sb.append(":");
				sb.append(objectToJson(((Map) obj).get(key)));
				if (it.hasNext()) {
					sb.append(",");
				}
			}
			sb.append("}");
			return sb.toString();
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			Class clazz = obj.getClass();
			Field[] fields = clazz.getDeclaredFields();
			List<String> strList = new ArrayList<String>();
			for (int i = 0; i < fields.length; i++) {
				String fieldName = fields[i].getName();
				Object value = null;
				String ufName = fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1);
				try {
					Method met = obj.getClass().getMethod("get" + ufName);
					value = met.invoke(obj);
				} catch (Exception e) {
					try {
						Method met = obj.getClass().getMethod("is" + ufName);
						value = met.invoke(obj);
					} catch (Exception ex) {
						continue;
					}
				}
				String sr = "\"" + fieldName + "\":" + objectToJson(value);
				strList.add(sr);
			}
			for (int i = 0; i < strList.size(); i++) {
				sb.append(strList.get(i));
				if (i < strList.size() - 1) {
					sb.append(",");
				}
			}
			sb.append("}");
			return sb.toString();
		}
	}
}
