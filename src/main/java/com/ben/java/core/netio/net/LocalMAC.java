package com.ben.java.core.netio.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Mac地址可用于局域网验证,提高安全性
 * @author ben xia
 * @date 2019年7月22日
 */
public class LocalMAC {
    /**
     * @param args
     * @throws UnknownHostException
     * @throws SocketException
     */
    public static void main(String[] args) throws UnknownHostException, SocketException {
        // TODO Auto-generated method stub

        //得到IP，输出PC-201309011313/122.206.73.83
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println(ia);
        getLocalMac(ia);
    }
    private static void getLocalMac(InetAddress ia) throws SocketException {
        // TODO Auto-generated method stub
        //获取网卡，获取地址    java.net.NetworkInterface用于表示网络接口，即网卡
        //NetworkInterface类提供了根据InetAddress对象获取与该对象表示的IP地址绑定的网卡
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        System.out.println("mac数组长度："+mac.length);
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<mac.length; i++) {
            if(i!=0) {
                sb.append("-");
            }
            //字节转换为整数
            //在实际编写代码之前还有一个地方需要注意，就是getHardwareAddress()返回的是字节数组，而众所周知JAVA中的所有的数值类型都是有符号的，
            // 那么返回的字节数组中有可能存在负数，这就需要将这些负数转换为正整数，然后将正整数在转换为十六进制数字即可
            int temp = mac[i]&0xff;
            String str = Integer.toHexString(temp);
            System.out.println("每8位:"+str);
            if(str.length()==1) {
                sb.append("0"+str);
            }else {
                sb.append(str);
            }
        }
        System.out.println("本机MAC地址:"+sb.toString().toUpperCase());
    }
}
