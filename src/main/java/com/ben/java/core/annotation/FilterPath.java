package com.ben.java.core.annotation;

import java.lang.annotation.*;

/***
 * JDK8新增的元注解: @Repeatable
 * @author Administrator
 *
 */
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(FilterPaths.class) // 参数指明接收的注解class
public @interface FilterPath {
	String value();
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface FilterPaths {
	FilterPath[] value();
}

// 使用案例
@FilterPath("/web/update")
@FilterPath("/web/add")
@FilterPath("/web/delete")
class AA {
}