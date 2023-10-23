package com.ben.java.core.json.jackson;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;


public class JacksonClient {
    public static void main(String[] args) {

    }

    /**
     * JDK的SPI机制
     */
    @Test
    public void testSpi() {
        try {
            // 1、直接new的方式
            // JsonFactory factory = new JsonFactory();
            // 2、更具弹性的SPI方式(内部调用的也是反射)
            JsonFactory factory = null;
            ServiceLoader<JsonFactory> load = ServiceLoader.load(JsonFactory.class);
            Iterator<JsonFactory> it = load.iterator();
            if (it.hasNext()) { // 此处是if不是while，因为我只需要一个而已
                factory = it.next();
            }
            // 3.反射
            Class<?> clazz = Class.forName("com.taixin.jackson.MyJsonFactory");
            Object o = clazz.newInstance();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 专栏后面重点介绍的ObjectMapper，它就是ObjectCodec的（唯一）实现类，它的基础原理便来源于此
     */
    @Test
    public void testParse() {
        JsonFactory factory = new JsonFactory();
        try (// 此处InputStream来自于文件
             JsonParser jsonParser = factory.createParser(new File("D:\\project\\java\\src\\main\\resources\\person.json"));) {
            jsonParser.setCodec(new MyObjectCodec()); // 若使用readValueAs系列方法，必须指定解码器(绑定)

            Person person = jsonParser.readValueAs(Person.class);
            System.out.println(person);
            // 关闭IO流
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 控制台, 文件 -> 是不同的输出地址
     * @throws IOException
     */
    @Test
    public void testGenerator() throws IOException {
//        JsonFactory factory = new JsonFactory();
//        JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8);
//        try {
//            jsonGenerator.writeStartObject(); //开始写，也就是这个符号 {
//
//            jsonGenerator.writeStringField("name", "YourBatman");
//            jsonGenerator.writeNumberField("age", 18);
//
//            jsonGenerator.writeEndObject(); //结束写，也就是这个符号 }
//        } finally {
//            jsonGenerator.close();
//        }
        JsonFactory factory = new JsonFactory();
        // 因为JsonGenerator实现了AutoCloseable接口，因此可以使用try-with-resources优雅关闭资源（这也是推荐的使用方式）
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject(); //开始写，也就是这个符号 {

            jsonGenerator.writeStringField("name", "YourBatman");
            jsonGenerator.writeNumberField("age", 18);

            jsonGenerator.writeEndObject(); //结束写，也就是这个符号 }
        }
    }

    @Test
    public void testFlush() throws IOException {
        JsonFactory factory = new JsonFactory();
        JsonGenerator jg = factory.createGenerator(System.err, JsonEncoding.UTF8);

        jg.writeStartObject();
        jg.writeStringField("name", "A哥");
        jg.writeEndObject();

        // jg.flush();
        // jg.close();
    }

    /**
     * String「intern()方法的作用」这个老生常谈的话题了，解释为：当调用intern方法时，
     * 如果字符串池已经包含一个等于此String对象的字符串(内容相等)，则返回池中的字符串。
     * 否则，将此 String放进池子里
     */
    @Test
    public void test2() {
        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str4 = str1 + str2;
        String str5 = new String("ab");

        System.out.println(str5.equals(str3)); // true
        System.out.println(str5 == str3); // false

        // str5.intern()去常量池里找到了ab，所以直接返回常量池里的地址值了，因此是true
        System.out.println(str5.intern() == str3); // true
        System.out.println(str5.intern() == str4); // false
    }


    @Test
    public void test4() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        System.out.println("----------读简单类型----------");
        System.out.println(objectMapper.readValue("18", Integer.class));
        // 抛错：JsonParseException  单独的一个串，解析会抛错
        // System.out.println(objectMapper.readValue("YourBatman", String.class));

        System.out.println("----------读集合类型----------");
        System.out.println(objectMapper.readValue("[1,2,3]", List.class));
        /**
         * 「在解决此问题之前，我们得先对Java中的泛型擦除有所了解，至少知道如下两点结论：」
         *
         * Java 在编译时会在字节码里指令集之外的地方保留「部分」泛型信息
         * 泛型接口、类、方法定义上的所有泛型、成员变量声明处的泛型「都会」被保留类型信息，「其它地方」的泛型信息都会被擦除
         *
         *
         * 需要特别注意泛型擦除问题：「若反序列化成为一个集合类型（Collection or Map），泛型会被擦除」，
         * 此时你应该使用readValue(String content, TypeReference<T> valueTypeRef)方法代替。
         */
        List<Long> list = objectMapper.readValue("[1,2,3]", new TypeReference<List<Long>>() {
        });
        Long id = list.get(0);
        System.out.println(id);


        System.out.println(objectMapper.readValue("{\"zhName\":\"A哥\",\"enName\":\"YourBatman\"}", Map.class));

        System.out.println("----------读POJO----------");
        System.out.println(objectMapper.readValue("{\"name\":\"A哥\",\"age\":18}", Person.class));

    }

    /**
     * hutool 处理泛型
     */
    @Test
    public void test5(){
        List bean = JSONUtil.toBean("[1,2,3]", new cn.hutool.core.lang.TypeReference<List<Long>>() {
        }, Boolean.FALSE);
    }
}
