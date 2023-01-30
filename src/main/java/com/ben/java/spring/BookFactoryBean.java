package com.ben.java.spring;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/1/30
 */
public class BookFactoryBean implements FactoryBean<Book> {
    public static boolean isSingleton = true;

    @Override
    public Book getObject() throws Exception {
        Book book = new Book();
        book.setName("《非暴力沟通》");
        book.setAuthor("马歇尔·卢森堡");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return isSingleton;
    }

    public static void main(String[] args) {
        System.out.println("-------工厂singleton模式------");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("factorybean.xml");
        Book book1 = (Book) context.getBean("book");
        System.out.println("book1：" + book1);
        Book book2 = (Book) context.getBean("book");
        System.out.println("book2：" + book2);
        System.out.println("book1 == book2：" + (book1 == book2));

        System.out.println("-------工厂prototype模式------");
        BookFactoryBean.isSingleton = false;
        context = new ClassPathXmlApplicationContext("factorybean.xml");
        book1 = (Book) context.getBean("book");
        System.out.println("book1：" + book1);
        book2 = (Book) context.getBean("book");
        System.out.println("book2：" + book2);
        System.out.println("book1 == book2：" + (book1 == book2));

        System.out.println("--------获取FactoryBean自身对象-------");
        System.out.println("BookFactory:" + context.getBean("&book"));

    }
}

/**
 * 属性:  书名 + 作者
 */
class Book implements Serializable {
    private static final long serialVersionUID = -672687543464668808L;

    private String name;
    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


