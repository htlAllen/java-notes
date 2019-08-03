package easyAndHard.charpter10;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.ArrayList;
public class Entry {
    public static void main(String[] args){
        // 向上转型
        Children x = new Children("allen");
        Parent y = new Children("allen");
        Parent m = new Children("smith");
        Parent q = new Parent("allen");
        x.Mandarin();  // 但是这两者仍然是调用的子类的方法
        y.Mandarin();  // 说明覆盖仍然有效
        x.Surf();
        Children n = (Children) y;  // 向下转型，变量y是父类类型，但指向的是子类对象
        n.Surf();
        if(x instanceof Parent); // true
        if(q instanceof Children); // false
        if(y instanceof Parent);// true
        if(y instanceof Children); // true
        if(m instanceof Parent);  // true
        // y.Surf(); 报错，y已经被蒙蔽（强制类型转化）了，虽然是Children对象，但是却看不见自己额外的方法（非覆盖方法）
        Cat c = new Cat();
        Dog d = new Dog();
        Animal.show(c);
        Animal.show(d);

    }
}
// 抽象类和接口的例子
class Cat extends Animal{
    public void speak(){
        System.out.println("cat is speak");
    }
}
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
    void speak(){
        System.out.println("animal speak");
    }
    void eat()                   // 正常方法
    {
        System.out.println("i am eat");
    }
    public static void show(Animal a){
        a.speak();
        if (a instanceof Dog){
            Dog d = (Dog) a;
            d.speak();
        }
        if (a instanceof  Cat){
            Cat c = (Cat) a;
            c.speak();
        }
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
// 重载的例子
class Overloader{
    void speak(String str){
        System.out.println(str);
    }
//    // 与上一个仅仅返回类型不同，不能构成重载的条件，因此会报错
//    int speak(String str){
//        System.out.println(str);
//        return 0;
//    }
    int speak(int x){
        System.out.println("yes");
        return 0;
    }

}