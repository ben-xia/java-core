package com.ben.java;


import com.ben.java.core.lambda.Person;
import com.ben.java.core.utils.PrintObjectHeader;

/**
 * @author ben-xia
 * @date 2020/03/28
 * @Description TODO
 **/
public class Main {

    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.home"));
//        stu stu = new stu();
//        stu.setName("aaa");
//
//        System.out.println(stu);
//        Lock lock = new ReentrantLock();
//        lock.lock();
//        lock.unlock();
        System.out.println(Runtime.getRuntime().availableProcessors());
        Person p = new Person("Tom", 8900, 23, "male", "New York");
        PrintObjectHeader. parseObjectHeader(PrintObjectHeader.getObjectHeader(p));
        synchronized (p){
            System.out.println("-------------------------------------------------------------------");
            PrintObjectHeader. parseObjectHeader(PrintObjectHeader.getObjectHeader(p));
        }

    }
}
class Common{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}

class stu extends Common{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"age\":")
                .append(age);
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append('}');
        return sb.toString();
    }
}

