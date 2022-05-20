package Work;

//账号注册或者修改密码

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Id extends JFrame {
    JButton submitButton, cancelButton;
    JLabel idLabel, pwdLabel, firstPwdLabel, secondPwdLabel;
    JTextField idText, pwdText, firstPwdText, secondPwdText;

    ArrayList<JComponent> componentsList = new ArrayList<>();
    DataBase dataBase;
    ArrayList<User> userList;

    public Id(boolean flag, DataBase dataBase) {

        this.dataBase = dataBase;
        this.userList = dataBase.getUserList();

        if(flag){
            insertUser();
        }else {
            changeUser();
        }
    }

    public void insertUser(){

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


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = true;
                if(idText.getText().equals("") || pwdText.getText().equals("")){
                    flag = false;
                    JOptionPane.showMessageDialog(getContentPane(), "账号密码不能为空!");
                }
                if(flag){
                    for (User user : userList) {
                        if(user.getId().equals(idText.getText())){
                            flag = false;
                            JOptionPane.showMessageDialog(getContentPane(), "id重复!");
                        }
                    }
                }

                if (flag){
                    if(pwdText.getText().equals(firstPwdText.getText()) && pwdText.getText().equals(secondPwdText.getText())){
                        dataBase.insertUser(idText.getText(), pwdText.getText());
                        JOptionPane.showMessageDialog(getContentPane(), "注册成功!");
                        dispose();
                        JOptionPane.showMessageDialog(getContentPane(), "注册成功后，请重启程序!");
                    } else {
                        JOptionPane.showMessageDialog(getContentPane(), "三次密码不一致!");

                    }
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "已经取消!");
                dispose();
            }
        });
    }

    public void changeUser(){
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
        pwdLabel = new JLabel("原密:");
        firstPwdLabel = new JLabel("新密:");
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


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean flag = false;
                for (User user : userList) {
                    if(user.getId().equals(idText.getText())){
                        if(user.getPwd().equals(pwdText.getText())){

                            if(firstPwdText.getText().equals(secondPwdText.getText())){
                                dataBase.changeUser(user.getId(), firstPwdText.getText());
                                JOptionPane.showMessageDialog(getContentPane(), "修改成功!");
                                dispose();
                                JOptionPane.showMessageDialog(getContentPane(), "修改密码后，请重启程序!");

                            }else {
                                JOptionPane.showMessageDialog(getContentPane(), "两次密码不一致!");
                            }
                        }else {
                            JOptionPane.showMessageDialog(getContentPane(), "密码错误!");
                        }
                        flag = true;
                    }
                }

                if (!flag){
                    JOptionPane.showMessageDialog(getContentPane(), "账号不存在!");
                }

            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "已经取消!");
                dispose();
            }
        });
    }

}
