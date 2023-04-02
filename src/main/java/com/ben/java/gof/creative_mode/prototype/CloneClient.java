package com.ben.java.gof.creative_mode.prototype;

public class CloneClient {
    public static void main(String[] args) {
        PrototypeObject prototypeObject = new PrototypeObject();
        prototypeObject.setAddress("上海");
        ReferenceObject referenceObject = new ReferenceObject();
        referenceObject.setAge(23);
        referenceObject.setName("张三");
        prototypeObject.setAddress("上海");
        prototypeObject.setReferenceObject(referenceObject);
        PrototypeObject shallowCloneObject = null;

        try {
            shallowCloneObject = prototypeObject.clone(); // 为什么此处一定要重写方能调用方法?????
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        PrototypeObject deepCloneByJdkSerializeObject = prototypeObject.deepCloneByJdkSerialize(); //jdk序列化的深拷贝
        PrototypeObject cloneByJsonSerializeObject = prototypeObject.deepCloneByJsonSerialize();

        System.out.println("原型对象和浅拷贝对象的引用属性内存地址是否相同:\t" + (prototypeObject.getReferenceObject() == shallowCloneObject.getReferenceObject())); //true
        System.err.println("原型对象和jdk深拷贝对象的引用属性内存地址是否相同:\t" + (prototypeObject.getReferenceObject() == deepCloneByJdkSerializeObject.getReferenceObject())); //false
        System.err.println("原型对象和json深拷贝对象的引用属性内存地址是否相同:\t" + (prototypeObject.getReferenceObject() == cloneByJsonSerializeObject.getReferenceObject())); //false
        System.err.println("jdk深拷贝对象和json深拷贝对象的引用属性内存地址是否相同:\t" + (deepCloneByJdkSerializeObject.getReferenceObject() == cloneByJsonSerializeObject.getReferenceObject())); //false


    }
}
