package com.ben.java.gof.structural_model.adapter.passport;

import lombok.Data;

/**
 * @author: ben.xia
 * @desc: 用建造者模式写
 * @date: 2023/5/1
 */
@Data
public class ResultMsg<T> {
    private String code;
    private String msg;
    private T data;
}
