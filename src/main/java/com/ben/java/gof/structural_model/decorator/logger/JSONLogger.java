package com.ben.java.gof.structural_model.decorator.logger;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;

import java.util.Arrays;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/5/2
 */
public class JSONLogger extends LoggerDecorator{
    public JSONLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void info(String s) {
        JSONObject jsonObject = newJsonObject();
        jsonObject.put("message", s);
        super.info(jsonObject.toJSONString());
    }

    @Override
    public void error(String s) {
        JSONObject jsonObject = newJsonObject();
        jsonObject.put("message", s);
        super.info(jsonObject.toJSONString());
    }

    public void error(Exception e) {
        JSONObject jsonObject = newJsonObject();
        jsonObject.put("exception",e.getClass().getName());
        String stackTrace = Arrays.toString(e.getStackTrace());
        jsonObject.put("stackTrace", stackTrace);
        super.info(jsonObject.toJSONString());
    }

    private JSONObject newJsonObject(){
        return new JSONObject();
    }
}
