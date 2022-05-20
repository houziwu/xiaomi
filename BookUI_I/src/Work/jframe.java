package Work;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//插入面板测试类

public class jframe extends JFrame {

    public static void main(String[] args) {
        new jframe().demo02();
    }

    JButton submitButton, cancelButton;
    JLabel idLabel, nameLabel, authorLabel, priceLabel, urlLabel, yearLabel;
    JTextField idText, nameText, authorText, priceText, urlText, yearText;


    JLabel  pwdLabel, firstPwdLabel, secondPwdLabel;
    JTextField  pwdText, firstPwdText, secondPwdText;

    ArrayList<JComponent> componentsList = new ArrayList<>();
    DataBase dataBase;
    ArrayList<User> userList;

    ArrayList<JComponent> list = new ArrayList<>();

    public void demo02(){
        //设置窗口的参数
        setBounds(500,300,400,300);
        //禁用重新调整窗口大小的功能
        setResizable(false);
        //关闭窗口的右上角

        //设置窗口上当前程序的名字
        setTitle("图书管理系统--注册账号");
        //清除默认的布局管理器
        getContentPane().setLayout(null);
        //设置窗口显示
        setVisible(true);

        idLabel = new JLabel("账号:");
        pwdLabel = new JLabel("密码:");
        firstPwdLabel = new JLabel("重复:");
        secondPwdLabel = new JLabel("重复:");

        componentsList.add(idLabel);
        componentsList.add(pwdLabel);
        componentsList.add(firstPwdLabel);
        componentsList.add(secondPwdLabel);

        idLabel.setBounds(20, 0, 80, 40);
        pwdLabel.setBounds(20, 40, 80, 40);
        firstPwdLabel.setBounds(20, 80, 80, 40);
        secondPwdLabel.setBounds(20, 120, 80, 40);

        add(idLabel);
        add(pwdLabel);
        add(firstPwdLabel);
        add(secondPwdLabel);

        idText = new JTextField();
        pwdText = new JTextField();
        firstPwdText = new JTextField();
        secondPwdText = new JTextField();

        componentsList.add(idText);
        componentsList.add(pwdText);
        componentsList.add(firstPwdText);
        componentsList.add(secondPwdText);

        idText.setBounds(85, 5, 240, 35);
        pwdText.setBounds(85, 45, 240, 35);
        firstPwdText.setBounds(85, 85, 240, 35);
        secondPwdText.setBounds(85, 125, 240, 35);

        add(idText);
        add(pwdText);
        add(firstPwdText);
        add(secondPwdText);


        submitButton = new JButton("确定");
        cancelButton = new JButton("取消");

        componentsList.add(submitButton);
        componentsList.add(cancelButton);

        submitButton.setBounds(100, 180, 80, 40);
        cancelButton.setBounds(200, 180, 80, 40);

        add(submitButton);
        add(cancelButton);


        for (JComponent jComponent : componentsList) {
            jComponent.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        }

    }

    public void demo01(){
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

        idLabel = new JLabel("        id:");
        nameLabel = new JLabel("  name:");
        authorLabel = new JLabel("author:");
        priceLabel = new JLabel("   price:");
        urlLabel = new JLabel("      url:");
        yearLabel = new JLabel("    year:");

        list.add(idLabel);
        list.add(nameLabel);
        list.add(authorLabel);
        list.add(priceLabel);
        list.add(urlLabel);
        list.add(yearLabel);

        idLabel.setBounds(15, 0, 90, 40);
        nameLabel.setBounds(15, 45, 90, 40);
        authorLabel.setBounds(15, 90, 90, 40);
        priceLabel.setBounds(15, 135, 90, 40);
        urlLabel.setBounds(15, 180, 90, 40);
        yearLabel.setBounds(15, 225, 90, 40);

        add(idLabel);
        add(nameLabel);
        add(authorLabel);
        add(priceLabel);
        add(urlLabel);
        add(yearLabel);

        /****/

        idText = new JTextField();
        nameText = new JTextField();
        authorText = new JTextField();
        priceText = new JTextField();
        urlText = new JTextField();
        yearText = new JTextField();



        list.add(idText);
        list.add(nameText);
        list.add(authorText);
        list.add(priceText);
        list.add(urlText);
        list.add(yearText);

        idText.setBounds(115, 10, 255, 40);
        nameText.setBounds(115, 55, 255, 40);
        authorText.setBounds(115, 100, 255, 40);
        priceText.setBounds(115, 145, 255, 40);
        urlText.setBounds(115, 190, 255, 40);
        yearText.setBounds(115, 235, 255, 40);

        add(idText);
        add(nameText);
        add(authorText);
        add(priceText);
        add(urlText);
        add(yearText);


        submitButton = new JButton("确定");
        cancelButton = new JButton("取消");

        submitButton.setBounds(120, 290, 100, 40);
        cancelButton.setBounds(240, 290, 100, 40);

        list.add(submitButton);
        list.add(cancelButton);

        add(submitButton);
        add(cancelButton);

        for (JComponent jComponent : list) {
            jComponent.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        }

    }


}
