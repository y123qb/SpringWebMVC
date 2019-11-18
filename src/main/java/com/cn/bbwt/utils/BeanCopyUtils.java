package com.cn.bbwt.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.alibaba.fastjson.annotation.JSONField;
/***
 * copy类的值，类似于BeanUtil
 * @author binger
 *
 */
public class BeanCopyUtils {

	public static void copyProperties(Object source, Object target) {
		try {
			//获得目标类的全部字段变量
			Field[] fields = target.getClass().getDeclaredFields();
			for (Field field : fields) {
				//serialVersionUID不是我们需要的，扔了
				if("serialVersionUID".equals(field.getName())){
					continue;
				}
				//获得这个变量的基本信息（此处我们需要的是方法包括get和set）
				PropertyDescriptor targetPd = new PropertyDescriptor(field.getName(), target.getClass());
				//获得set方法
				Method writeMethod = targetPd.getWriteMethod();
				if(writeMethod!=null){
					/*因为目标类和源类在变量上不一样（此处主要针对是相同变量名大小写不一样）而目标类上的注解名跟源类一样，所以我们
					取目标类的注解名字来找源类相同的字段的get方法取值
					*/
					//获得目标字段上的注解，项目中的注解使用的@JSONField
					JSONField annotation = field.getAnnotation(JSONField.class);
					if(annotation!=null){
						String name = annotation.name().toUpperCase();
							//根据名字查找源类的字段，获得字段的基本信息
							//通过源类字段的get方法，取值
							Method readMethod =null;
							try {
								PropertyDescriptor sourcePd = new PropertyDescriptor(name, source.getClass());
								readMethod = sourcePd.getReadMethod();
							} catch (Exception e) {
								continue;
							}
							if(readMethod!=null){
								//利用反射获取源类字段的值，
								Object value = readMethod.invoke(source);
								if("--".equals(value)){
									value="";
								}
								//利用反射给目标字段赋值
								writeMethod.invoke(target, value);
							}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
