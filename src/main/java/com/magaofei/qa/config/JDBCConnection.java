package com.magaofei.qa.config;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCConnection {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/django_interface";

    // 数据库的用户名与密码，需要根据自己的设置
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static List<Object> getResult(String sql) {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT id, name, url FROM websites";

            ResultSet rs = stmt.executeQuery(sql);

            List<Object> result = new ArrayList<Object>();
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");


//                System.out.print("ID: " + id);

                result.add(id);
//                int id  = rs.getInt("id");
//                String name = rs.getString("name");
//                String url = rs.getString("url");

                // 输出数据
//                System.out.print("ID: " + id);
//                System.out.print(", 站点名称: " + name);
//                System.out.print(", 站点 URL: " + url);
//                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
            return result;
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(conn!=null) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        return new ArrayList<>();

    }


    public static void main(String[] args) {
        List result = JDBCConnection.getResult("select * from analysis_request_response_log limit 2");
        System.out.println(result);
    }
}
