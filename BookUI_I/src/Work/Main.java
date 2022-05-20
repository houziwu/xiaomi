package Work;

//函数入口，调用登录界面函数

public class Main {



    public static void main(String[] args) throws Exception {

        //数据库地址
        String str = "jdbc:mysql://localhost:3306/bookUIData?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
        String id = "root";
        String password = "root";

        DataBase dataBase = new DataBase(str, id, password);

        new Login(dataBase);
    }



}
