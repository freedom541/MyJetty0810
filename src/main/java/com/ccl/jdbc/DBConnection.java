package com.ccl.jdbc;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.sql.*;
import java.util.UUID;

/**
 * Created by ccl on 16/9/29.
 */
public class DBConnection {
    private String dbDriver = "com.mysql.jdbc.Driver";
    private String dbUrl = "jdbc:mysql://localhost:3306/test";//根据实际情况变化
    private String dbUser = "root";
    private String dbPass = "123456";

    public Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);//注意是三个参数
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int insert()
    {
        int i=0;
        String sql="insert into user(userId,addr,create_time) values(?,?,?)";
        Connection cnn=getConn();

        try{
            PreparedStatement preStmt =cnn.prepareStatement(sql);

            preStmt.setString(1, UUID.randomUUID().toString().substring(0,8));
            preStmt.setString(2, "afdsfasfasdfasdfsadf");//或者：preStmt.setInt(1,值);
            DateTime dateTime = new DateTime(DateTimeZone.UTC);
            System.out.println(dateTime);
            //Date date = new Date();
            //preStmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            preStmt.setTimestamp(3, new Timestamp(dateTime.getMillis()));
            i=preStmt.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return i;//返回影响的行数，1为执行成功
    }

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        System.out.println(dbConnection.insert());
    }
}


