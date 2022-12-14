package com.ben.java.core.netio.rmi;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 客户端实现(Stub:树桩)
 * @author ben-xia
 * @date 2019/6/19
 */

public class Person_Stub implements Person {
    private Socket socket;

    public Person_Stub() throws Throwable {
        // connect to skeleton
        socket = new Socket("127.0.0.1", 9000);
    }

    public int getAge() throws Throwable {
        // pass method name to skeleton
        ObjectOutputStream outStream =
                new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("age");
        outStream.flush();
        ObjectInputStream inStream =
                new ObjectInputStream(socket.getInputStream());
        return inStream.readInt();
    }

    public String getName() throws Throwable {
        // pass method name to skeleton
        ObjectOutputStream outStream =
                new ObjectOutputStream(socket.getOutputStream());
        outStream.writeObject("name");
        outStream.flush();
        ObjectInputStream inStream =
                new ObjectInputStream(socket.getInputStream());
        return (String) inStream.readObject();
    }
}
