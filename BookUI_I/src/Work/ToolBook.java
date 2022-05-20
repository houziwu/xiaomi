package Work;

//书本删除，插入和修改类

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ToolBook extends JFrame {
    JButton submitButton, cancelButton;
    JLabel idLabel, nameLabel, authorLabel, priceLabel, urlLabel, yearLabel;
    JTextField idText, nameText, authorText, priceText, urlText, yearText;

    ArrayList<JComponent> list = new ArrayList<>();

    DataBase dataBase;
    ArrayList<Book> bookList;

    //根据choice选择模式
    public ToolBook(int choice, DataBase dataBase, ArrayList<Book> bookList) throws Exception {

        this.dataBase = dataBase;
        this.bookList = bookList;

        switch (choice){
            case 1:insertFrame();
                break;
            case 2:changeFrame();
                break;
            case 3:deleteFrame();
                break;

            default:
                break;
        }
    }

    //插入书本
    public void insertFrame(){

        //设置窗口的参数
        setBounds(500,300,400,400);
        //禁用重新调整窗口大小的功能
        setResizable(false);
        //关闭窗口的右上角

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

        //回车
        this.getRootPane().setDefaultButton(submitButton);

        submitButton.addActionListener(e -> {
            //六项内容不为空
            if (!idText.getText().equals("") && !nameText.getText().equals("")
                    && !authorText.getText().equals("") && !priceText.getText().equals("")
                    && !urlText.getText().equals("") && !yearText.getText().equals("")){
                //id不可以重复
                for (Book book : bookList) {
                    if(book.getId().equals(idText.getText())){
                        JOptionPane.showMessageDialog(getContentPane(), "id重复!");
                        dispose();
                        return;
                    }
                }
                //插入书本
                dataBase.insertBook(idText.getText(), nameText.getText(), authorText.getText(),
                        Double.parseDouble(priceText.getText()), urlLabel.getText(), yearLabel.getText());
                JOptionPane.showMessageDialog(getContentPane(), "添加成功!");
                //关闭页面
                dispose();
            }else {
                JOptionPane.showMessageDialog(getContentPane(), "信息不能为空!");
            }
        });
        //取消操作
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "已经取消!");
                dispose();
            }
        });

    }

    //删除书本
    public void deleteFrame(){

        //设置窗口的参数
        setBounds(500,300,400,200);
        //禁用重新调整窗口大小的功能
        setResizable(false);
        //关闭窗口的右上角的叉

        //设置窗口上当前程序的名字
        setTitle("图书管理系统--删除图书");
        //清除默认的布局管理器
        getContentPane().setLayout(null);
        //设置窗口显示
        setVisible(true);

        idLabel = new JLabel("id:");
        list.add(idLabel);
        idLabel.setBounds(35, 10, 90, 40);
        add(idLabel);

        idText = new JTextField("id为找寻标准");
        list.add(idText);
        idText.setBounds(75, 10, 285, 40);
        add(idText);

        submitButton = new JButton("确定");
        cancelButton = new JButton("取消");

        submitButton.setBounds(80, 90, 100, 40);
        cancelButton.setBounds(200, 90, 100, 40);

        list.add(submitButton);
        list.add(cancelButton);

        add(submitButton);
        add(cancelButton);

        for (JComponent jComponent : list) {
            jComponent.setFont(new Font("微软雅黑", Font.PLAIN, 24));
        }

        //回车
        this.getRootPane().setDefaultButton(submitButton);

        submitButton.addActionListener(e -> {
            //ID不为空
            if (!idText.getText().equals("")){

                for (Book book : bookList) {
                    //找到才删除
                    if(book.getId().equals(idText.getText())){

                        dataBase.deleteBook(book.getId());
                        JOptionPane.showMessageDialog(getContentPane(), "删除成功!");
                        dispose();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(getContentPane(), "找不到id!");

            }else {
                JOptionPane.showMessageDialog(getContentPane(), "id不能为空!");
            }
        });

        //取消操作
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "已经取消!");
                dispose();
            }
        });



    }

    //修改书本
    public void changeFrame(){
        //设置窗口的参数
        setBounds(500,300,400,400);
        //禁用重新调整窗口大小的功能
        setResizable(false);
        //关闭窗口的右上角

        //设置窗口上当前程序的名字
        setTitle("图书管理系统--修改图书");
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

        idText = new JTextField("不可改，id为找寻标准");
        nameText = new JTextField("为空则不改(删除此句)");
        authorText = new JTextField("为空则不改(删除此句)");
        priceText = new JTextField("为空则不改(删除此句)");
        urlText = new JTextField("为空则不改(删除此句)");
        yearText = new JTextField("为空则不改(删除此句)");



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

        //回车
        this.getRootPane().setDefaultButton(submitButton);

        submitButton.addActionListener(e -> {
            //ID不为空
            if (!idText.getText().equals("")){

                for (Book book : bookList) {
                    //找到ID后修改
                    if(book.getId().equals(idText.getText())){
                        //ID不可以改
                        String name = book.getName();
                        String author = book.getAuthor();
                        double price = book.getPrice();
                        String url = book.getUrl();
                        String year = book.getYear();
                        //文本框为空的属性不修改
                        if(!nameText.getText().equals("")){
                            name = nameText.getText();
                        }
                        if(!authorText.getText().equals("")){
                            author = authorText.getText();
                        }
                        if(!priceText.getText().equals("")){
                            price = Double.parseDouble(priceText.getText());
                        }
                        if(!urlText.getText().equals("")){
                            url = urlText.getText();
                        }
                        if(!yearText.getText().equals("")){
                            year = yearText.getText();
                        }

                        dataBase.changeBook(book.getId(), name, author, price, url, year);
                        JOptionPane.showMessageDialog(getContentPane(), "修改成功!");
                        dispose();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(getContentPane(), "找不到id!");

            }else {
                JOptionPane.showMessageDialog(getContentPane(), "id不能为空!");
            }
        });

        //取消操作
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(getContentPane(), "已经取消!");
                dispose();
            }
        });

    }


}
