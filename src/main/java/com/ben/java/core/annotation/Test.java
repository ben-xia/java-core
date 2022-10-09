package com.ben.java.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 由于@Test内部没有定义其他元素，所以@Test也称为标记注解（marker annotation）
 * @author ben xia
 * @email  keeping1990@126.com
 * @date   2018年10月1日上午11:22:54
 * @version
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

}
