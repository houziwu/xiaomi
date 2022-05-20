package Work;

import java.util.Objects;

/*****图书类*****/

public class Book {

    private String name;//书名
    private String id;//图书号
    private String author;//作者
    private double price;//价格
    private String url;//网址
    private String year;


    //全参构造
    public Book(String id, String name, String author, double price, String url, String year) {
        this.name = name;
        this.id = id;
        this.author = author;
        if(price >= 0){
            this.price = price;
        }else{
            this.price = 0;
        }
        this.url = url;
        this.year = year;
    }

    public Book() {

    }

    //比较判断方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name);
    }

    //未知
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    //toString
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", url='" + url + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0){
            this.price = price;
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}

