package Spring5_test1.src.com.qujia.spring5;


public class User {

    private String userName;

    public User() {
    }//无参构造

    public User(String userName) {
        this.userName = userName;
    }

    public void add(){
        System.out.println("add");
    }

}
