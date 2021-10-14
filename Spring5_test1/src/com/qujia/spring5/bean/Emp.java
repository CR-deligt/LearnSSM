package Spring5_test1.src.com.qujia.spring5.bean;
//员工类
public class Emp {
    private String ename;
    private String gender;
    private Dept dept;//表示员工所属部门，用对象类型进行表示

    public Dept getDept() {
        return dept;
    }//用于级联赋值第二种方法

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String add() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept+
                '}';
    }
}
