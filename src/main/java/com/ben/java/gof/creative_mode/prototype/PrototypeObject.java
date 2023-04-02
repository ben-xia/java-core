package com.ben.java.gof.creative_mode.prototype;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.*;

@Data
public class PrototypeObject implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private String address;
    private ReferenceObject referenceObject;

    /**
     * JDK自带的浅克隆(浅克隆底层实现就是我们日常使用的set,get)
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected PrototypeObject clone() throws CloneNotSupportedException {
        return (PrototypeObject) super.clone();
    }

    /**
     * jdk深克隆(深克隆底层使用了类加载机制,重新加载了class文件 + 序列化数据[保存了属性资源的状态], 通过反射生成了一个新的对象)
     * @return
     */
    public PrototypeObject deepCloneByJdkSerialize(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  // 此处为什么还能拿到数据?????
            ObjectInputStream ois = new ObjectInputStream(bis);
            PrototypeObject prototypeObject = (PrototypeObject) ois.readObject();
            return prototypeObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * json深克隆
     * @return
     */
    public PrototypeObject deepCloneByJsonSerialize(){
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(JSON.toJSONString(this));

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  // 此处为什么还能拿到数据
            ObjectInputStream ois = new ObjectInputStream(bis);
            String prototypeString = (String) ois.readObject();
            PrototypeObject prototypeObject = JSON.parseObject(prototypeString, PrototypeObject.class);
            return prototypeObject;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
