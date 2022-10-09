package com.ben.java.core.netio.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class ProxyTest02 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.3lai8.com");
        // /创建代理服务器
        InetSocketAddress addr = new InetSocketAddress("192.168.0.254", 8080);
        // Proxy proxy = new Proxy(Proxy.Type.SOCKS, addr); // Socket 代理
        Proxy proxy = new Proxy(Proxy.Type.HTTP, addr); // http 代理
        Authenticator.setDefault(new MyAuthenticator("username", "password"));// 设置代理的用户和密码
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);// 设置代理访问
        InputStreamReader in = new InputStreamReader(connection.getInputStream());
        BufferedReader reader = new BufferedReader(in);
        while (true) {
            String s = reader.readLine();
            if (s != null) {
                System.out.println(s);
            }
        }
    }

    static class MyAuthenticator extends Authenticator {
        private String user = "";
        private String password = "";

        public MyAuthenticator(String user, String password) {
            this.user = user;
            this.password = password;
        }

        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password.toCharArray());
        }
    }
}
