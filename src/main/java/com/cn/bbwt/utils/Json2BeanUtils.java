package com.cn.bbwt.utils;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;


//import net.sf.json.JSONObject;

/***
 *
 * @author binger
 *JsonObject 是由json转换过来，里面得属性跟一个实体类对应，
 *该工具类可以把json转换成实体类，没有得自动忽略
 */
public class Json2BeanUtils {

	/***
	 * JsonObject 转 bean
	 * @param object
	 * @param json
	 */
	public static void JsonObject2Bean(Object object, JSONObject json){
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			String name = field.getName();
			if(json.containsKey(name)){
				String value = json.getString(name);
				if(value!=null && "".equals(value.trim())){
					try {
						field.setAccessible(true);
						field.set(object, value);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
