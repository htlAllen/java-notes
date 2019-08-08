package easyAndHard.charpter18;
import java.lang.Thread;
import java.lang.Runnable;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadDemo {
    public static void main(String[] args){
        Thread1 t1 = new Thread1("allen");
        Thread1 t2 = new Thread1("smith");
        t1.start();
        t2.start();
        Thread t3 =new Thread(new MyThread("aaa"));
        Thread t4 = new Thread(new MyThread("bbb"));
        t3.start();
        t4.start();
    }
}
//
class Thread1 extends Thread{
    private String str;
    public Thread1(String x){
        str = x;
    }
    public void run(){
        for(int i=0; i < 100; i++){
            System.out.println("这是" + i + str);
        }
    }
}
class MyThread implements Runnable{
    private String x;
    public MyThread(String test){
        x = test;
    }
    public void run(){
        for(int i = 0; i < 50; i++){
            System.out.println("this is thread by Runnable class" + x + i);
        }

    }
}
