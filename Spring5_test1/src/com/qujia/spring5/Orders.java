package Spring5_test1.src.com.qujia.spring5;
//用有参构造注入参数
public class Orders {
    private String oname;
    private   String address;

    //有参构造注入
    public Orders(String oname, String address) {
        this.oname = oname;
        this.address = address;
    }

    public String TestOrders() {
        return "Orders{" +
                "oname='" + oname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
