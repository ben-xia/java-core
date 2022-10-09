package com.ben.java.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @DBTable有一个name()属性[name:元素],该注解主要用于数据库表与Bean类的映射
 * @author ben xia
 * @email keeping1990@126.com
 * @date 2018年10月1日下午1:52:18
 * @version
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
	public String name();
}
