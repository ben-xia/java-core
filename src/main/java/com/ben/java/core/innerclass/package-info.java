/**
 * 内部类[******]:
 * 
 * 1.将一个类的定义放在另外一个类的定义内部,这就是内部类;
 * 2.内部类是一种非常有用的特性,因为它允许你把一些逻辑相关的类组织在一起(LinkedList,迭代器),并控制位于内部的类的可见性,但是内部类与组合是完全不同的概念;
 * 3.成员内部类实例可以访问到外部类实例的所有成员[包括私有的],而不需要任何的条件;
 * 4.成员内部类: 必须使用外部类对象去创建内部类对象: 内部类实例.new 外部类(),这样外部类实例和内部类实例就相关联了,两者就可以通信了,即可以共享数据了;
 * 5.非静态内部类实例自动拥有与其相关联的外部类的实例: 在内部类的使用方式是[外部类.this.成员]
 * 
 * 
 * java 普通内部类和静态内部类
 * 区别1：
 *   普通内部类实例化后的对象持有外部类的引用，在非静态类内部可以访问外部类的成员；
 *   静态内部类实例化不持有外部对象引用，不能访问外面的方法和成员；
 *
 *  从耦合度上来讲，普通内部类跟外部类耦合程度很高，
 *  静态内部类跟外部类耦合程度很低；
 *
 * 区别2：
 *    外部类静态方法中，无法创建普通内部类对象，可以创建静态内部类对象；
 *    可以把普通内部类和静态内部类近似为普通成员与静态成员，静态方法不可以访问普通成员；
 * 
 * 
 * 匿名内部类: 指的是没有类名的内部类
 *          优点:少定义一个类,缺点:内部类无法重复使用;
 *
 * 局部内部类: 等同于局部变量
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
/**
 * @author Administrator
 *
 */
package com.ben.java.core.innerclass;