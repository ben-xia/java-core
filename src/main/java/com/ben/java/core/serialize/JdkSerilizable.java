package com.ben.java.core.serialize;

import java.io.*;

/**
 * @author: ben.xia
 * @desc:
 * @date: 2023/2/25
 */
public class JdkSerilizable {

    public static void main(String[] args) {
        try {
            // 序列化
            File file = new File("person.text");
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            Person p1 = new Person("Peter", 27);
            Person p2 = new Person("Jack", 23);
            //   一个对象一个对象序列化
            outputStream.writeObject(p1);
            outputStream.writeObject(p2);
            outputStream.close();

            // 反序列化
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            //   一个对象一个对象反序列化
            Person p3 = (Person) inputStream.readObject();
            Person p4 = (Person) inputStream.readObject();
            System.out.println(p3);
            System.out.println(p4);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
