package com.ben.java.core.netio.heartbeat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * C/S架构的服务端对象
 * @author ben xia
 * @date   2018年8月18日下午1:52:46
 *
 */
public class Server {  
  
    /** 
     * 要处理客户端发来的对象，并返回一个对象，可实现该接口。 
     */  
    public interface ObjectAction{  
        Object doAction(Object rev);  
    }  
      
    public static final class DefaultObjectAction implements ObjectAction{  
        public Object doAction(Object rev) {  
            System.out.println("处理并返回："+rev);  
            return rev;  
        }  
    }  
      
    public static void main(String[] args) {  
        int port = 65432;  
        Server server = new Server(port);  
        server.start();  
    }  
      
    private int port;  
    private volatile boolean running=false;  
    private long receiveTimeDelay=3000;    //接收数据的上限时间是3S,即3S内没有接收到数据服务端就会断开与客户端的连接
    private ConcurrentHashMap<Class, ObjectAction> actionMapping = new ConcurrentHashMap<Class,ObjectAction>();  
    private Thread connWatchDog;  
      
    public Server(int port) {  
        this.port = port;  
    }  
  
    public void start(){  
        if(running)return;  
        running=true;  
        connWatchDog = new Thread(new ConnWatchDog());  
        connWatchDog.start();  
    }  
      
    @SuppressWarnings("deprecation")  
    public void stop(){  
        if(running)running=false;  
        if(connWatchDog!=null)connWatchDog.stop();  
    }  
      
    public void addActionMap(Class<Object> cls,ObjectAction action){  
        actionMapping.put(cls, action);  
    }  
      
    class ConnWatchDog implements Runnable{  
        public void run(){  
            try {  
                ServerSocket ss = new ServerSocket(port,5);  //新建了一个服务器Socket
                while(running){  
                    Socket s = ss.accept();   //侦听并接受到此套接字的连接
                    new Thread(new SocketAction(s)).start();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
                Server.this.stop();  
            }  
              
        }  
    }  
      
    class SocketAction implements Runnable{  
        Socket s;   
        boolean run=true;  
        long lastReceiveTime = System.currentTimeMillis();  
        public SocketAction(Socket s) {  
            this.s = s;  
        }  
        public void run() {  
            while(running && run){  
                if(System.currentTimeMillis()-lastReceiveTime>receiveTimeDelay){ 
                	System.out.println("------------------------------------------------");
                    overThis();  
                }else{  
                    try {  
                        InputStream in = s.getInputStream();  
                        if(in.available()>0){  
                            ObjectInputStream ois = new ObjectInputStream(in);  
                            Object obj = ois.readObject();  
                            lastReceiveTime = System.currentTimeMillis();  
                            System.out.println("接收：\t"+obj);  
                            ObjectAction oa = actionMapping.get(obj.getClass());  
                            oa = oa==null?new DefaultObjectAction():oa;  
                            Object out = oa.doAction(obj);  
                            if(out!=null){  
                                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());  
                                oos.writeObject(out);  
                                oos.flush();  
                            }  
                        }else{  
                            Thread.sleep(10);  
                        }  
                    } catch (Exception e) {  
                        e.printStackTrace(); 
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        overThis();  
                    }   
                }  
            }  
        }  
          
        private void overThis() {  
            if(run)run=false;  
            if(s!=null){  
                try {  
                    s.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
            System.out.println("关闭："+s.getRemoteSocketAddress());  
        }  
          
    }  
      
}  