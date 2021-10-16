package com.qujia.Spring.beanLife;

public class Orders {
    String oname;

    public Orders() {
        System.out.println("1无参构造Orders");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("2调用set方法设置值");
    }

    public void init_Method(){
        System.out.println("3调用初始化方法");//在bean中要配置init-Method标签
    }
    public void destroyMethod(){
        System.out.println("4调用销毁方法");//在bean中要配置destroy-Method标签
    }
}
