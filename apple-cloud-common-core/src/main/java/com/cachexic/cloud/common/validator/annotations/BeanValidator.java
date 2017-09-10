package com.cachexic.cloud.common.validator.annotations;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.apache.log4j.Logger;

/**
 * @Description: 校验类
 * @author: tangm
 * @date: 2016年2月19日 
 * @version: 1.0
 */
public class BeanValidator {

	static Logger logger = Logger.getLogger(BeanValidator.class);
	
	static ValidatorFactory factory = Validation.buildDefaultValidatorFactory(); 
	
	private BeanValidator(){
		
	}
	
	/**
	 * 校验
	 * @param t
	 * @param groups
	 * @return
	 */
	public static <T> ValidatorResult validateResult(T t,Class<?>... groups){
		Validator validator = factory.getValidator(); 
		Set<ConstraintViolation<T>> vs = validator.validate(t,groups);
		
		Map<String,String> errorMap = new HashMap<String, String>();
		
		for(ConstraintViolation<T> v:vs){
			Class<?> annClazz = v.getConstraintDescriptor().getAnnotation().annotationType();
			
			//key:msg  value:field
			errorMap.put(v.getMessage(), v.getPropertyPath().toString());
			logger.error("<br>::::hibernate validate ERROR:"+v.getRootBean().getClass().getName()+"."+v.getPropertyPath().toString()
					+" violate rule:@"+annClazz.getSimpleName()+",message:"+v.getMessage());
		}
		
		
		//合并相同字段，不同的错误信息
		Multimap<String, String> joinMap = ArrayListMultimap.create();
		Iterator<Map.Entry<String, String>> it = errorMap.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			//key value对调位置
			joinMap.put(value, key);
		}
		//遍历joinMap，存入list
		List<ValidatorBean> errors = Lists.newArrayList();
		Set<String> keySet = joinMap.keySet();
		for(String key:keySet){
			ValidatorBean bean = new ValidatorBean();
			bean.setFiled(key);
			Collection<String> collection = joinMap.get(key);
			String errMsg = "";
			for(String msg:collection){
				errMsg =errMsg + msg+"！";
			}
			bean.setErrorMsg(errMsg);
			
			errors.add(bean);
		}
		
		ValidatorResult vr = new ValidatorResult();
		vr.setFlag(errorMap.size()==0);
		vr.setErrorObjs(errors);
		return vr;
	}
	
	/**
	 * 返回boolean用于判断
	 * @param t
	 * @param groups
	 * @return
	 */
	public static <T> boolean isValidated(T t,Class<?>... groups){
		return validateResult(t,groups).getErrorObjs().size()==0;
	}
	

	
}
