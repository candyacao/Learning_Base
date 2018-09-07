package com.briup.day08;
/**
 *run as
 *1.先找main，因为main方法在Test类中
 *2.把Test这个类做类加载
 *3.Test类又继承自Base类
 *4.转而去加载Base类
 *在加载Base类的时候，发现里面有静态代码块，所以限制性Base中的静态代码块
 * @author CLY
 *
 */
public class Test extends Base{
	 
    static{
        System.out.println("test static");
    }
     
    public Test(){
        System.out.println("test constructor");
    }
     
    public static void main(String[] args) {
        new Test();
    }
}
 
class Base{
     
    static{
        System.out.println("base static");
    }
     
    public Base(){
        System.out.println("base constructor");
    }
}
