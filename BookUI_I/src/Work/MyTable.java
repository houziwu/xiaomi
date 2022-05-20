package Work;

//表格类，未完善，未使用，后需增加渲染
/*
import javax.swing.*;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

public class MyTable extends JTable {

    //TableModel tableModel = new TableModel();

    //表格类型
    public MyTable(TableModel tableModel) {
        //获取表头
        JTableHeader tableHead = this.getTableHeader();
        //设置表头字体
        tableHead.setFont(new Font(null,Font.BOLD,16));
        //设置表头字体颜色
        tableHead.setForeground(Color.RED);
        //设置table字体
        this.setFont(new Font(null,Font.PLAIN,14));
        //设置table字体颜色
        this.setForeground(Color.BLACK);
        //设置线条颜色
        this.setGridColor(Color.BLACK);
        //设置行高
        this.setRowHeight(50);
        //同时选择多行
        this.getSelectionModel().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        rend();
    }

    //渲染方式
    public void rend() {
        //ArrayList<Object> col = tableModel.getColList();

        for(int i=0;i<col.size();i++) {
            //定义表格列
            TableColumn cols = this.getColumn(col.get(i));
            if(i==0) {
                //第一列窄一些
                cols.setPreferredWidth(50);
                //设置最大宽度
                cols.setMaxWidth(50);
                //设置最小宽度
                cols.setMinWidth(50);
            }else if (i == 4){
                //第一列窄一些
                cols.setPreferredWidth(150);
                //设置最大宽度
                cols.setMaxWidth(150);
                //设置最小宽度
                cols.setMinWidth(150);
            }
            else {
                cols.setMinWidth(100);
                //设置宽度不可改变
                cols.setResizable(false);
            }

        }
    }

}
*/