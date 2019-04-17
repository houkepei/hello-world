package com.houkp.recommended.utils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InsertDataDemo {
    static Connection conn = null;

    public static void initConn() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://localhost:3306/test?"
                + "user=root&password=1234&useUnicode=true&characterEncoding=UTF8&useSSL=false&serverTimezone=UTC";

        try {
            // 动态加载mysql驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String randomStr(int size) {
        //定义一个空字符串
        String result = "";
        for (int i = 0; i < size; ++i) {
            //生成一个97~122之间的int类型整数
            int intVal = (int) (Math.random() * 26 + 97);
            //强制转换（char）intVal 将对应的数值转换为对应的字符，并将字符进行拼接
            result = result + (char) intVal;
        }
        //输出字符串
        return result;
    }


    public static void insert(Set set, String startDate, String endDate) {
        List list = new ArrayList(set);
        LocalDate localDate = LocalDate.now();
        Date date = Date.valueOf(localDate);
        // 开时时间
        Long begin = System.currentTimeMillis();
        System.out.println("开始插入数据...");
        // sql前缀
        final String strSql = "insert into  blacklist_ip (ip_blacklist, flag, end_time,  start_time, version) values (?, ?, ?, ?, ?)";

        try {
            // 设置事务为非自动提交
//            conn.setAutoCommit(false);
            //预编译sql
            PreparedStatement preparedStatement = conn.prepareStatement(strSql);
            for (Object o : list) {

            }
            for (int i = 1; i <= ; i+=100000) {
                preparedStatement.setString(1, String.valueOf(i));
                preparedStatement.setInt(2, 1);
                preparedStatement.setDate(3, date);
                preparedStatement.setDate(4,  date);
                preparedStatement.setString(5, String.valueOf(i));
                preparedStatement.addBatch();
            }

            // 执行操作
            preparedStatement.executeBatch();
            // 提交事务
//            conn.commit();

            // 关闭连接
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 结束时间
        Long end = System.currentTimeMillis();
        System.out.println("成功插入10W条数据耗时: " + (end - begin) / 1000 + " 秒");
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        initConn();
        insert(1000000);

    }
}
