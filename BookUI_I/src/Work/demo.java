package Work;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.*;

//数据库测试类

public class demo extends JFrame {
    public static void main(String[] args) {
        /*//数据库地址
        String str = "jdbc:mysql://localhost:3306/bookUIData?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
        String id = "root";
        String password = "root";

        ArrayList<Book> SQLData = new DataBase(str, id, password).getBookList();

        for (Book sqlDatum : SQLData) {
            System.out.println(sqlDatum);
        }*/

        //Calendar c = Calendar.getInstance();
        //System.out.println(c);
        /*StringBuffer sBuffer = new StringBuffer();
//时分秒
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        sBuffer.append(hour).append(":").append(minute).append(":").append(second);
        System.out.println(sBuffer);*/

        new demo().init();



    }


    public void init(){
        //设置窗口的参数
        setBounds(500,300,400,400);
        //禁用重新调整窗口大小的功能
        setResizable(false);
        //关闭窗口的右上角的叉的同时关闭程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置窗口上当前程序的名字
        setTitle("图书管理系统--添加图书");
        //清除默认的布局管理器
        getContentPane().setLayout(null);
        //设置窗口显示
        setVisible(true);

        JLabel label = new JLabel("时间");

        label.setBounds(50, 50, 300, 200);
        label.setFont(new Font("黑体", Font.BOLD, 20));
        add(label);

        Timer timer = new Timer(1000, e -> {
            StringBuffer sBuffer = new StringBuffer();
//时分秒
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            //这样获取的月份是从0开始的
            int month = cal.get(Calendar.MONTH) + 1;
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);

            sBuffer.append(String.format("%04d", year)).append("年").append(month).append("月").append(day).append("日 ").append(String.format("%02d", hour)).append(":").append(String.format("%02d", minute)).append(":").append(String.format("%02d", second));
            label.setText(sBuffer.toString());
        });
        timer.start();


    }
}
