package com.ben.java.core.utils;

import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * JDBC操作数据库的基本步骤：
 * <p>
 *     1）加载（注册）数据库驱动（到JVM）。
 *     2）建立（获取）数据库连接。
 *     3）创建（获取）数据库操作对象。
 *     4）定义操作的SQL语句。
 *     5）执行数据库操作。
 *     6）获取并操作结果集。
 *     7）关闭对象,回收数据库资源（关闭结果集-->关闭数据库操作对象-->关闭连接）。
 */
public class JdbcUtil {

    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;

    static {
        //获取配置文件的读入流
        Properties properties = PropertiesUtil.loadProperties("jdbc.properties");
        driver = properties.getProperty("jdbc.driver");
        url = properties.getProperty("jdbc.url");
        username = properties.getProperty("jdbc.user");
        password = properties.getProperty("jdbc.pwd");

        //加载驱动类
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询
     * @param sql
     * @return
     */
    public static int[] batchInsert(String sql) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int [] result = null;
        try {
            // 1、获取数据库连接对象
            conn = getConnection();
            // 2、准备预编译的 sql 语句
            //  sql = "select * from users where username=? and password =?";

            // 3、执行预编译 sql 语句
            stmt = conn.prepareStatement(sql);

            // 4、设置参数的值
            for(int i=0; i<10;i++){
                stmt.setString(1,"batch_"+i);
                stmt.setString(2,"batch_"+i);
                stmt.setInt(3,20+i);
                stmt.setDate(4,new Date(System.currentTimeMillis()));
                stmt.addBatch();
            }
            // 5、执行 sql 语句
            result = stmt.executeBatch();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 查询
     * @param sql
     * @return
     */
    public static String query(String sql) {
        String phone = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            // 1、获取数据库连接对象
            conn = getConnection();
            // 2、准备预编译的 sql 语句
            //  sql = "select * from users where username=? and password =?";
            // 3、执行预编译 sql 语句
            stmt = conn.prepareStatement(sql);
            // 即使把 username 和 password 的值也设置成和上面一样，也查询不到数据
            // username = "rosesdadsdadsa' OR 1=1 -- '";
            // password = "sdeweqwewqeqwewq";
            // 4、设置参数的值
            //stmt.setString(1, username);
            //stmt.setString(2, password);
            // 5、执行 sql 语句
            rs = stmt.executeQuery();
            if (rs.next()) {
                phone = rs.getString("");
            } else {
                phone = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release(conn, stmt, rs);
        }

        return phone;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }


    private static void release(Connection connection, Statement statement, ResultSet resultSet) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int[] batchInsert = JdbcUtil.batchInsert("insert into student(username,password,age,regdate) values(?,?,?,?)");
        Arrays.stream(batchInsert).forEach(System.out::println);
    }
};
