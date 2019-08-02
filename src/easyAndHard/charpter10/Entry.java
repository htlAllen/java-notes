package easyAndHard.charpter10;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.ArrayList;
public class Entry {
    public static void main(String[] args){
        Children x = new Children("allen");
        Parent y = new Children("allen");
        Parent m = new Children("smith");
        x.Mandarin();  // 但是这两者仍然是调用的子类的方法
        y.Mandarin();  // 说明覆盖仍然有效
        x.Surf();
        // y.Surf(); 报错，y已经被蒙蔽（强制类型转化）了，虽然是Children对象，但是却看不见自己额外的方法（非覆盖方法）
    }
}
// 抽象类和接口的例子
class Dog extends Animal implements Sleep{
    public void speak(){
        System.out.println("dog is speak");
    }

    public void sleep(){
        System.out.println("dog is sleep");
    }
}
abstract class Animal{
    private String name="haha";  // 可以定义变量
    abstract void speak();       // 抽象方法，abstract关键字，没有方法体
    void eat()                   // 正常方法
    {
        System.out.println("i am eat");
    }
}
interface Sleep{
    void sleep();               // 抽象方法，abstract关键字省略，只能有抽象方法
}
// 类型转换的例子
class Parent{
    private String name;
    Parent(String name){
        name = name;
    }
    void Mandarin(){
        System.out.println("我说的是普通话");
    }
}
class Children extends Parent{
    private String name;
    public Children(String name) {
        super(name);
        name = name;
    }
    void Mandarin(){
        System.out.println("我说的是流星语");
    }

    void Surf(){
        System.out.println("我们这个年代可以上网冲浪");
    }
}