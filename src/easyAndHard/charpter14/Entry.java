package easyAndHard.charpter14;
// 基本接口
import java.util.*;

import javafx.util.Pair;

import javax.print.attribute.IntegerSyntax;
// 实现类，


public class Entry {
    public static void main(String[] args){
        LinkedList<Integer> x = new LinkedList<Integer>();
        LinkedList<Integer> y = new LinkedList<Integer>();
        Test t = new Test();
        System.out.println(t.size);  // 只声明了，实例化的时候有默认值
        y.offer(1);
        y.offer(2);
        y.offer(3);
        y.offer(4);
        x.push(1);
        x.push(2);
        x.push(3);
        x.push(4);
        System.out.println(x.pop());
        System.out.println(x.poll());
        }
}
class Test{
    public int size;
}