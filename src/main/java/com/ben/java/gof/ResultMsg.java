package com.ben.java.gof;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: ben.xia
 * @desc: 用建造者模式写
 * @date: 2023/5/1
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultMsg<T> {
    private String code;
    private String msg;
    private T data;
}
