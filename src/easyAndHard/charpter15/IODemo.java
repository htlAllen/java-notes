package easyAndHard.charpter15;
import java.io.File;


import java.io.FileReader;

import java.io.FileWriter;

public class IODemo {
    public static void main(String[] args){
        File file = new File("D:\\delete\\test.txt");
        System.out.println(file.exists());
        file.delete();
        System.out.println(file.exists());
    }
}
