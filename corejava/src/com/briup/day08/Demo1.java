package com.briup.day08;

public class Demo1 {
    static int value = 33;
 
    public static void main(String[] args) throws Exception{
        new Demo1().printValue();
    }
 
    private void printValue(){
        int value = 3;
        System.out.println(this.value);
    }
}