package com.ben.java.gof.structural_model.proxy.cglib;


import net.sf.cglib.core.DebuggingClassWriter;
import java.lang.reflect.Field;
import java.util.Properties;

public class MyClient {

    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        /** 开启 保存cglib生成的动态代理类类文件*/
        saveGeneratedCGlibProxyFiles(System.getProperty("user.dir"));

        // 创建目标对象
        SomeService target = new SomeService();

        // 使用工厂方法创建代理对象
        ProxyFactory factory = new ProxyFactory();
        SomeService proxy = (SomeService) factory.createProxy(target);
        System.out.println("proxy:" + proxy.getClass().getName());

        // 通过代理对象执行业务方法
        String res = proxy.doSome();
        System.out.println("通过代理对象执行目标方法的结果:" + res);

    }
    /**
     * 设置保存Cglib代理生成的类文件。
     *
     * @throws Exception
     */
    public static void saveGeneratedCGlibProxyFiles(String dir) throws Exception {
        Field field = System.class.getDeclaredField("props");
        field.setAccessible(true);
        Properties props = (Properties) field.get(null);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, dir);//dir为保存文件路径
        props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");
    }
}
