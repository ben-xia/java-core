package com.ben.java.gof.creative_mode.prototype;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReferenceObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;
}
