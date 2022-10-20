package com.gxuwz.attend.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbUtil {
    private String url;
    private String driver;
    private String user;
    private String password;


    public DbUtil() {
        this.driver="com.mysql.cj.jdbc.Driver";
        this.url="jdbc:mysql://localhost:3306/xxdb?characterEncoding=utf8&serverTimezone=UTC";
        this.user="root";
        this.password="123456";
    }

    public Connection getConn() throws Exception {
        Connection conn = null;
        Class.forName(driver);
        conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    public void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public void close(Connection conn, Statement stmt) throws Exception {
        this.close(conn, stmt, null);
    }
}