package Work;

//登录界面类
//bug：注册账号，修改密码后需要重新登陆才能登录，因为用户集合未刷新

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class Login extends JFrame {


    DataBase dataBase;
    ArrayList<User> userList;
    Timer timer;

    public Login(DataBase dataBase) throws Exception {

        this.dataBase = dataBase;
        this.userList = dataBase.getUserList();

        //先放置控件
        setComponent();
        //放入事件监听函数
        setActionListen();
        //最后布置页面（先布置页面会覆盖控件布置）
        loginFrame();

        timer = new Timer(0, E -> {
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
            timeLabel.setText(sBuffer.toString());
        });

        timer.start();
    }

    //页面属性设置
    public void loginFrame(){
        //设置窗口的参数
        setBounds(500,300,600,400);
        //禁用重新调整窗口大小的功能
        setResizable(false);
        //关闭窗口的右上角的叉的同时关闭程序
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置窗口上当前程序的名字
        setTitle("图书管理系统--登录页面");
        //清除默认的布局管理器
        getContentPane().setLayout(null);
        //设置窗口显示
        setVisible(true);
    }


    //定义控件
    JButton loginButton, restartButton, insertButton, changeButton;
    JLabel idLabel, pwdLabel, titleLabel, timeLabel;
    JTextField idText;
    JPasswordField pwdText;

    //控件集合
    ArrayList<JComponent> listComponent = new ArrayList<>();


    //页面控件布置
    public void setComponent(){

        //文本输入框(以及密码输入框)
        idText = new JTextField();
        pwdText = new JPasswordField();
        //设置位置（左上角坐标）与宽高
        idText.setBounds(200, 110, 200, 45);
        pwdText.setBounds(200, 175, 200, 45);
        //存入集合
        listComponent.add(idText);
        listComponent.add(pwdText);
        //放到页面上
        getContentPane().add(idText);
        getContentPane().add(pwdText);

        //标签
        idLabel = new JLabel("账号:");
        pwdLabel = new JLabel("密码:");
        titleLabel = new JLabel("图书管理系统");
        timeLabel = new JLabel();
        //设置坐标与宽高
        idLabel.setBounds(130, 110, 60, 45);
        pwdLabel.setBounds(130, 175, 60, 45);
        titleLabel.setBounds(225, 50, 200, 60);
        timeLabel.setBounds(5, 320, 305, 40);
        //存入集合
        listComponent.add(idLabel);
        listComponent.add(pwdLabel);
        listComponent.add(timeLabel);
        //titleLabel不存入集合单独设置
        titleLabel.setFont(new Font("黑体", Font.BOLD, 24));

        //放到页面上
        getContentPane().add(idLabel);
        getContentPane().add(pwdLabel);
        getContentPane().add(titleLabel);
        getContentPane().add(timeLabel);

        //按钮
        loginButton = new JButton("登录");
        restartButton = new JButton("重置");
        insertButton = new JButton("注册");
        changeButton = new JButton("改密");

        /*
        //事件监听
        loginButton.addActionListener(this);
        restartButton.addActionListener(this);
        insertButton.addActionListener(this);
        changeButton.addActionListener(this);
        */

        //设置大小
        loginButton.setBounds(210, 240, 80, 40);
        restartButton.setBounds(310, 240, 80, 40);
        insertButton.setBounds(405, 112, 80, 40);
        changeButton.setBounds(405, 177, 80, 40);
        //存入集合
        listComponent.add(loginButton);
        listComponent.add(restartButton);
        listComponent.add(insertButton);
        listComponent.add(changeButton);
        //放置于页面
        getContentPane().add(loginButton);
        getContentPane().add(restartButton);
        getContentPane().add(insertButton);
        getContentPane().add(changeButton);


        //整体设置字体
        for (JComponent jComponent : listComponent) {
            jComponent.setFont(new Font("宋体", Font.BOLD, 20));
        }
    }
    /*
    @Override
    public void actionPerformed(ActionEvent e) {

        //给回车键增加按钮监听事件（登录按钮）
        this.getRootPane().setDefaultButton(loginButton);

        if(e.getSource() == loginButton){
            boolean flag = false;

            for (User user : userList) {
                //找到账号
                if (user.getId().equals(idText.getText())) {
                    //密码符合
                    if (user.getPwd().equals(pwdText.getText())) {
                        //登录成功(后续注释掉)
                        //创建新页面
                        try {
                            new Menu(dataBase);
                        } catch (Exception E) {
                            E.printStackTrace();
                        }
                        //跳转页面后（创建新页面），关闭此页面
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(getContentPane(), "密码有误!");

                    }
                    flag = true;
                }
            }
            //账号不符
            if (!flag) {
                JOptionPane.showMessageDialog(getContentPane(), "账号有误!");

            }
        }else if(e.getSource() == restartButton){
            idText.setText("");
            pwdText.setText("");
        }else if(e.getSource() == insertButton){
            new Id(true, dataBase);
            this.userList = this.dataBase.getUserList();
        }else if(e.getSource() == changeButton){
            new Id(false, dataBase);
            this.userList = this.dataBase.getUserList();
        }
    }*/

    //事件监听
    public void setActionListen(){

        //给回车键增加按钮监听事件（登录按钮）
        this.getRootPane().setDefaultButton(loginButton);

        //登录按钮监听
        loginButton.addActionListener(e -> {

            boolean flag = false;

            for (User user : userList) {
                //找到账号
                if (user.getId().equals(idText.getText())) {
                    //密码符合
                    if (user.getPwd().equals(pwdText.getText())) {
                        //登录成功(后续注释掉)
                        //创建新页面
                        try {
                            new Menu(dataBase);
                        } catch (Exception E) {
                            E.printStackTrace();
                        }
                        //跳转页面后（创建新页面），关闭此页面
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(getContentPane(), "密码有误!");

                    }
                    flag = true;
                }
            }
            //账号不符
            if (!flag) {
                JOptionPane.showMessageDialog(getContentPane(), "账号有误!");

            }
        });


        //重置按钮监听
        restartButton.addActionListener(e -> {
            idText.setText("");
            pwdText.setText("");
        });

        //注册按钮
        insertButton.addActionListener(e -> {
            DataBase dataBase1 = dataBase;
            new Id(true, dataBase1);
        });

        //修改密码按钮
        changeButton.addActionListener(e -> {
            DataBase dataBase1 = dataBase;
            new Id(false, dataBase1);

        });

    }


}
