package Work;

import javax.swing.table.AbstractTableModel;
import java.util.*;

//表格模板类

public class TableModel extends AbstractTableModel {

    ArrayList<Object> colList = new ArrayList<>();
    ArrayList<Book> rowList = new ArrayList<>();
    DataBase dataBase;
    ArrayList<Book> SQLData;


    Object[] tableCol = new Object[]{"ID", "NAME", "AUTHOR", "PRICE", "URL", "YEAR"};

    //空参构造，demo数据
    public TableModel(DataBase dataBase) {
        this.dataBase = dataBase;
        SQLData = dataBase.getBookList();
        //导入字段
        colList.addAll(Arrays.asList(tableCol));
        //导入行数据
        rowList = new ArrayList<>(SQLData);


    }

    //查询构造
    public TableModel(String text, DataBase dataBase){
        this.dataBase = dataBase;
        SQLData = dataBase.getBookList();
        colList.addAll(Arrays.asList(tableCol));
        rowList.clear();

        //查询
        for (Book objects : SQLData) {
            if(text.equals(objects.getId()) || text.equals(objects.getName())){
                Book book = new Book(objects.getId(), objects.getName(), objects.getAuthor(), objects.getPrice(), objects.getUrl(), objects.getYear());
                rowList.add(book);
                return;
            }
        }


    }
    //排序
    public TableModel(boolean flag, DataBase dataBase){
        this.dataBase = dataBase;
        SQLData = dataBase.getBookList();
        rowList = new ArrayList<>(SQLData);

        if(flag){
            //升序
            rowList.sort(Comparator.comparingInt(o -> (int) o.getPrice()));
        }else {
            //降序
            rowList.sort((o1, o2) -> (int)o2.getPrice() - (int)o1.getPrice());
        }
        colList.addAll(Arrays.asList(tableCol));
    }

    //删除，插入和修改
    public TableModel(int choice, DataBase dataBase) {
        this.dataBase = dataBase;
        SQLData = dataBase.getBookList();
        switch (choice){
            case 1:
                try {
                    new ToolBook(1, dataBase, SQLData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    new ToolBook(2, dataBase, SQLData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    new ToolBook(3, dataBase, SQLData);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                //导入demo数据
            case 4:insertDemoData();
                break;
            default:
                break;
        }
        SQLData = dataBase.getBookList();
    }

    //导入demo数据
    public void insertDemoData(){
        if (SQLData.size() == 0){
            SQLData = dataBase.insertBook("001", "红楼梦", "曹雪芹", 88.88, "www.aaaaa.com", "1820");
            SQLData = dataBase.insertBook("002", "三国演义", "罗贯中", 77, "www.bbbbb.com", "1720");
            SQLData = dataBase.insertBook("003", "西游记", "吴承恩", 100, "www.ccccc.com", "1670");
            SQLData = dataBase.insertBook("004", "水浒传", "施耐庵", 66.66, "www.ddddd.com", "1784");
        }
        rowList = SQLData;
    }


    @Override
    public int getRowCount() {
        return rowList.size();
    }

    @Override
    public int getColumnCount() {
        return colList.size();
    }


    @Override
    public String getColumnName(int columnIndex) {
        return (String)colList.get(columnIndex);
    }

    //禁止直接在方格内修改数据
    @Override
    public boolean isCellEditable(int row,int col) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex == 0){
            return rowList.get(rowIndex).getId();
        }else if(columnIndex == 1){
            return rowList.get(rowIndex).getName();
        }else if(columnIndex == 2){
            return rowList.get(rowIndex).getAuthor();
        }
        else if(columnIndex == 3){
            return rowList.get(rowIndex).getPrice();
        }
        else if(columnIndex == 4){
            return rowList.get(rowIndex).getUrl();
        }
        return null;
    }

    public ArrayList<Object> getColList(){
        return colList;
    }


}
