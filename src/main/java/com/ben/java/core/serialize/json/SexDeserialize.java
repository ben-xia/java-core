package com.ben.java.core.serialize.json;


import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Type;

public class SexDeserialize implements ObjectDeserializer {

    public <T> T deserialze(DefaultJSONParser parser,  Type type,Object fieldName) {
        String sex = parser.parseObject(String.class);
        if ("男".equals(sex)) {
            return (T) Boolean.TRUE;
        } else {
            return (T) Boolean.FALSE;
        }
    }

    public int getFastMatchToken() {
        return JSONToken.UNDEFINED;
    }
}
