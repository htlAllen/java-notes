package easyAndHard.charpter15;

// File生成文件对象，如创建，删除，获得路径等方法都是在File类中
import java.io.File;
// 以字节（byte）为对象的IO
import java.io.InputStream;
import java.io.OutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;

// 以字符（char)为对象的IO
import java.io.Reader;
import java.io.Writer;

import java.io.FileReader;
import java.io.FileWriter;


// 以输入输出流为对象，通过其写入缓存中，然后再通过自身的方法用缓存中的数据输出的设备中
import java.io.BufferedReader;
import java.io.BufferedWriter;

// 与文件相关的异常
import java.io.IOException;
import java.io.FileNotFoundException;

public class IODemo {
    public static void main(String[] args){
        File file = new File("D:\\aaaa.txt");
        String[] content = {"今天下雨", "明天下雨", "后天下雨"};
        try {
            FileWriter out = new FileWriter(file);
            BufferedWriter bout = new BufferedWriter(out);
            for(int i=0; i < content.length; i++){
                // 数据已经写入缓存，此时还并没有写入文件中
                bout.write(content[i]);
                bout.newLine();
                System.out.println("成功写入一行数据");
                // 将缓存中的数据，刷新到设备中，此时数据已经存放到硬盘中了
                bout.flush();
            }
            bout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
