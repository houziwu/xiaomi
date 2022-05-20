package Work;

import java.sql.*;
import java.util.ArrayList;

//数据库类

public class DataBase {
    private String path;//数据库地址及设置

    private String id;//数据库账号

    private  String password;//数据库密码

    public Connection con;//连接对象

    public Statement state;//执行对象

    public DataBase(String path, String id, String password) {

        //1.导入jar包，在项目内创建libs目录，将jar包复制到libs目录下
        //在idea内右键libs目录选择 Add As Library

        //注册数据库驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        this.path = path;
        this.id = id;
        this.password = password;

        dataBase();

        /*
        String[] strBase = {
                "CREATE DATABASE if not exists AtmData DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;",
                "use AtmData",
                "CREATE TABLE if not exists 'user' (id varchar(20), password varchar(20), money double, vip varchar(5));",
                "CREATE TABLE if not exists 'message' (id INT AUTO_INCREMENT, PRIMARY KEY (id), userId varchar(20), type varchar(30), time varchar(30), info varchar(255));"
               };

        */

    }


    //创建连接对象和执行对象
    private void dataBase() {
        //获取连接对象
        try {
            this.con = DriverManager.getConnection( this.path, this.id, this.password);
            //获取执行对象
            this.state = this.con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取书本集合
    public ArrayList<Book> getBookList(){
        try {
            ResultSet resultSet = this.state.executeQuery("SELECT * FROM Book");
            ArrayList<Book> bookList = new ArrayList<>();
            while(resultSet.next()){
                Book book = new Book(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("author"), Double.parseDouble(resultSet.getString("price")), resultSet.getString("url"), resultSet.getString("year"));
                bookList.add(book);
            }
            return bookList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //插入书本
    public ArrayList<Book> insertBook(String id, String name, String author, double price, String url, String year){

        try {
            this.state.execute("INSERT INTO book VALUE ('" + id + "', '" + name + "', '" +  author + "', " + price + ", '" + url + "', '" + year + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getBookList();
    }

    /*UPDATE book SET id = '005',NAME = 'xxx' WHERE id = '006'*/
    //修改书本
    public ArrayList<Book> changeBook(String id, String name, String author, double price, String url, String year){

        //id不可以改变
        try {
            this.state.execute("UPDATE book SET NAME = '" + name + "', author = '" + author + "', price = " + price + ", url = '" + url + "', year = '" + year +"' WHERE id = '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getBookList();
    }

    /*DELETE FROM book WHERE id = '005' OR NAME = 'aaa'*/
    //删除书本
    public ArrayList<Book> deleteBook(String id){

        //id不可以改变
        try {
            this.state.execute("DELETE FROM book WHERE id = '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getBookList();
    }

    //获取用户集合
    public ArrayList<User> getUserList(){
        try {
            ResultSet resultSet = this.state.executeQuery("SELECT * FROM user");
            ArrayList<User> userList = new ArrayList<>();
            while(resultSet.next()){
                User user = new User(resultSet.getString("id"), resultSet.getString("pwd"));
                userList.add(user);
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //插入用户
    public ArrayList<User> insertUser(String id, String pwd){

        try {
            this.state.execute("INSERT INTO user VALUE ('" + id + "', '" + pwd + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getUserList();
    }

    //修改用户
    public ArrayList<User> changeUser(String id, String pwd){

        //id不可以改变
        try {
            this.state.execute("UPDATE user SET pwd = '" + pwd + "' WHERE id = '" + id + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getUserList();
    }

}
