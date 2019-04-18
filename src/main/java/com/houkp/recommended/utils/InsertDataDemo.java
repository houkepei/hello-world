package com.houkp.recommended.utils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InsertDataDemo {
    static Connection conn = null;

    public static void initConn() throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://rm-2zer1w1qt6k5nr163.mysql.rds.aliyuncs.com:3306/digitalunion?useUnicode=true&amp;characterEncoding=utf8";
        String user = "smdspcindb";
        String password = "m4ds#%@$WWS";

        try {
            // 动态加载mysql驱动
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动程序");
            conn = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void insert(Set set, String startDate, String endDate) {
        // 开时时间
        Long begin = System.currentTimeMillis();
        Integer setNum = set.size();
        try {
            initConn();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List list = new ArrayList(set);
        LocalDate localDate = LocalDate.now();
        Date sDate = Date.valueOf(startDate);
        Date eDate = Date.valueOf(endDate);

        System.out.println("开始插入数据...");
        // sql前缀
        final String strSql = "insert into  blacklist_ip (ip_blacklist, flag, end_time,  start_time, version) values (?, ?, ?, ?, ?)";

        try {
            // 设置事务为非自动提交
            conn.setAutoCommit(false);
            //预编译sql
            PreparedStatement preparedStatement = conn.prepareStatement(strSql);

            for (int i = 0; i < list.size(); i++) {
                preparedStatement.setString(1, String.valueOf(list.get(i)));
                preparedStatement.setInt(2, 1);
                preparedStatement.setDate(3, eDate);
                preparedStatement.setDate(4, sDate);
                preparedStatement.setString(5, localDate.toString());
                preparedStatement.addBatch();
                //每10w条数据插入一次
                if (i % 10000 == 0) {
                    // 执行操作
                    preparedStatement.executeBatch();
                    // 提交事务
                    conn.commit();
                    // 结束时间
                    Long end = System.currentTimeMillis();
                    System.out.println("成功插入10W条数据耗时: " + (end - begin) / 1000 + " 秒");
                }

            }
            // 执行操作
            preparedStatement.executeBatch();
            // 提交事务
            conn.commit();

            // 关闭连接
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        // 结束时间
        Long end = System.currentTimeMillis();
        System.out.println("成功插入" + set.size() + "条数据耗时: " + (end - begin) / 1000 + " 秒");

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        for (int j = 0; j < 100; j++) {
            if (j % 10 == 0) {
                System.out.println(j);
            }
        }


    }
}
