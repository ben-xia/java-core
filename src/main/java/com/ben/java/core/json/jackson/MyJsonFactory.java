package com.taixin.jackson;

import com.fasterxml.jackson.core.JsonFactory;

public class MyJsonFactory extends JsonFactory {
    public MyJsonFactory() {
        System.out.println("我是自定义的MyJsonFactory");
    }
}
