package com.ben.java.gof.creative_mode.builder.v1;


/**
 * jdk的StringBuilder
 * mybatis的CacheBuilder,SqlSessionFactoryBuilder
 */
public class BuilderClient {

    public static void main(String[] args) {

        Person person = PersonBuilder.builder()
                        .address("上海") // chain 调用
                        .name("张三")
                        .age(23)
                        .gender("男")
                        .hobby("骑行")
                        .build();
        System.out.println(person);
    }
}
