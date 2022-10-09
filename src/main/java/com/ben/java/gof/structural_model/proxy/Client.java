package com.ben.java.gof.structural_model.proxy;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ben-xia
 * @date 2021/04/25
 * @Description TODO
 **/
public class Client {
    public static void main(String[] args) throws SQLException {
        DataSource lazyDataSource = new LazyDataSource("jdbc:mysql://127.0.0.1:3306/springdb?useUnicode=true&characterEncoding=utf8", "root", "root");
        System.out.println("get lazy connection...");
        try (Connection conn1 = lazyDataSource.getConnection()) {
        }
        System.out.println("get lazy connection...");
        try (Connection conn2 = lazyDataSource.getConnection()) {
            try (PreparedStatement ps = conn2.prepareStatement("SELECT * FROM student")) { // 打开了真正的Connection
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        System.out.println(rs.getString("username"));
                    }
                }
            }
        }

//  PooledDataSource
//        PooledDataSource pooledDataSource = new PooledDataSource("jdbc:mysql://127.0.0.1:3306/springdb?useUnicode=true&characterEncoding=utf8", "root", "root");
//        pooledDataSource.getConnection();

        try {
            int len=-1;
            StringBuffer sb = new StringBuffer();
            byte[] b = new byte[1024];
            FileInputStream inputStream = new FileInputStream("");
            while ((len=inputStream.read(b))!=-1){
                sb.append(new String(b,0,b.length));
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
