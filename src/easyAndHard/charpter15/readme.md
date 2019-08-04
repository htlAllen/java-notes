# I/O
> 流指的是**数据**序列，根据其流向不同，可以分为输入流和输出流。输入流指的是程序从指向源的输入流中读取数据，输出流指的是程序向输出流中写入数据把信息传送到目的地
### InputStream和OutputStream
- InputStream
    - InputStream是字节输入流，常用的方法为read()从输入流中读取一个字节数据,read(byte[] b)从输入流中读取指定长度字节数据

- OutputStream
    - InputStream是字节输出流，常用的方法为read()从输入流中写一个字节数据,write(byte[] b)从输出流中写指定长度字节数据

### Reader和Writer
略

> （Reader/Writer）和（InputStream/OutputStream）的区别：前者是字符级输入/输出流；后者是字节级的输入/输出流
### DataInputStream和DataOutputStream
### FileInputStream和FileOutputStream
### FileReader和FileWriter
### BufferedInputStream和BufferedOutputStream
### BufferedReader和BufferedWriter








# 问题
1. byte类型是什么意思呢？
答： byte类型整数在内存中占用一个字节，常见的char类型在内存中占用两个字节
2. 为什么在new FileOutputStream对象的时候会报出java.io.FileNotFoundException而使用try..catch..就不会