package com.ben.java.core.serialize.json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    @JSONField(name = "Name")
    private String name;
    @JSONField(name = "Age")
    private int age;
    @JSONField(name = "Bir", format = "yyyy-MM-dd")
    private Date bir;
    //其中serializeUsing与deserializeUsing可以用于对字段的序列化与反序列化进行定制化。
    @JSONField(serializeUsing = SexSerializer.class, deserializeUsing = SexDeserialize.class)
    private Boolean sex;
}
