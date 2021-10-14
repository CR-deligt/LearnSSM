package Spring5_test1.src.com.qujia.spring5;
//用set方法注入属性
public class Book {
    //创建属性
    private String bname;
    private String bauthor;
    private String address;

    //set属性注入
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String TestBook() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
