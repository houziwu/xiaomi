package Work;

//主界面类

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

public class Menu extends JFrame implements ActionListener {

    //组件
    JTextField searchText;//查询文本框
    JLabel TimeLabel;//时间显示标签
    JButton searchButton, demoButton, insertButton,//查询按钮，导入按钮，插入按钮
            moneySortUpButton, moneySortDownButton, sortButton,//升序按钮，降序按钮，刷新（顺序）按钮
            deleteButton, changeButton;//删除按钮，修改按钮
    JTable bookTable;
    JScrollPane scrollPane;
    DataBase dataBase;
    TableModel tableModel;

    ArrayList<JComponent> list = new ArrayList<>();
    //定时器，用于刷新页面时间
    Timer timer;


    //构造方法
    public Menu(DataBase dataBase) throws Exception {
        this.dataBase = dataBase;
        this.tableModel= new TableModel(dataBase);
        //控件布置
        setComponent();
        //直接给控件添加事件监听，无需在此调用监听函数

        //页面布置
        menuFrame();

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
            TimeLabel.setText(sBuffer.toString());
        });

        timer.start();
    }

    //图形界面设置
    public void menuFrame(){
        //设置大小
        setBounds(200, 100, 1200, 800);
        //设置关闭
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置不可调节大小
        setResizable(false);
        //设置名称
        setTitle("图书管理系统--表格");
        //清除默认布局
        getContentPane().setLayout(null);
        //设置显示
        setVisible(true);
    }

    //组件布置
    public void setComponent(){
        bookTable = new JTable(tableModel);

        //表头字体设置
        bookTable.getTableHeader().setFont(new Font("黑体", Font.BOLD, 20));
        bookTable.getTableHeader().setForeground(Color.RED);
        //表格字体设置
        bookTable.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        bookTable.setForeground(Color.BLACK);
        //线条设置
        bookTable.setGridColor(Color.BLACK);
        //表格宽度设置
        bookTable.setRowHeight(50);
        //表格大小设置
        bookTable.setBounds(200, 80, 800, 600);
        //多行选择设置
        bookTable.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        //表头进制移动设置
        bookTable .getTableHeader().setReorderingAllowed(false);

        scrollPane = new JScrollPane(bookTable);
        scrollPane.setBounds(150, 80, 900, 600);

        add(scrollPane);


        searchButton = new JButton("查询");
        demoButton = new JButton("导入");
        insertButton = new JButton("插入");
        moneySortUpButton = new JButton("升序");
        moneySortDownButton = new JButton("降序");
        sortButton = new JButton("刷新");
        deleteButton = new JButton("删除");
        changeButton = new JButton("修改");

        searchText = new JTextField("输入id或者name查询");
        TimeLabel = new JLabel();

        searchButton.setBounds(720, 20, 90, 40);
        demoButton.setBounds(400, 20, 90, 40);
        insertButton.setBounds(305, 700, 90, 40);
        changeButton.setBounds(410, 700, 90, 40);
        deleteButton.setBounds(515, 700, 90, 40);
        moneySortUpButton.setBounds(620, 700, 90, 40);
        moneySortDownButton.setBounds(725, 700, 90, 40);
        sortButton.setBounds(830, 700, 90, 40);

        list.add(searchButton);
        list.add(deleteButton);
        list.add(demoButton);
        list.add(insertButton);
        list.add(changeButton);
        list.add(moneySortDownButton);
        list.add(moneySortUpButton);
        list.add(sortButton);


        searchButton.addActionListener(this);
        demoButton.addActionListener(this);
        moneySortUpButton.addActionListener(this);
        moneySortDownButton.addActionListener(this);
        sortButton.addActionListener(this);
        insertButton.addActionListener(this);
        deleteButton.addActionListener(this);
        changeButton.addActionListener(this);


        searchText.setBounds(505, 20, 200, 40);
        TimeLabel.setBounds(5, 720, 305, 40);

        list.add(searchText);
        list.add(TimeLabel);

        add(searchButton);
        add(demoButton);
        add(insertButton);
        add(moneySortUpButton);
        add(moneySortDownButton);
        add(sortButton);
        add(deleteButton);
        add(changeButton);

        add(searchText);
        add(TimeLabel);

        for (JComponent jComponent : list) {
            jComponent.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        }

    }

    //事件监听
    @Override
    public void actionPerformed(ActionEvent e) {


        //给回车键增加按钮监听事件（查询按钮）
        //这种方法需要点击一次查询按钮后才会生效
        this.getRootPane().setDefaultButton(searchButton);

        //查询按钮
        if(e.getSource() == searchButton){
            tableModel = new TableModel(searchText.getText(), this.dataBase);
            bookTable.setModel(tableModel);
        }else if (e.getSource() == moneySortUpButton){
            tableModel = new TableModel(true, this.dataBase);
            bookTable.setModel(tableModel);
        }else if (e.getSource() == moneySortDownButton){
            tableModel = new TableModel(false, this.dataBase);
            bookTable.setModel(tableModel);
        }else if (e.getSource() == sortButton){
            tableModel = new TableModel(this.dataBase);
            bookTable.setModel(tableModel);
        }else if(e.getSource() == demoButton){
            tableModel = new TableModel(4, this.dataBase);
            JOptionPane.showMessageDialog(getContentPane(), "数据为空时才可以导入demo数据！");
        }else if(e.getSource() == insertButton){
            tableModel = new TableModel(1, this.dataBase);
        }else if(e.getSource() == deleteButton){
            tableModel = new TableModel(3, this.dataBase);
        }else if(e.getSource() == changeButton){
            tableModel = new TableModel(2, this.dataBase);
        }
    }

}
