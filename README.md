# 算法（第4版）

>[官方网站](http://algs4.cs.princeton.edu/home/)&ensp;[官方代码下载](http://algs4.cs.princeton.edu/code/algs4.jar)&ensp;[官方测试数据下载](http://algs4.cs.princeton.edu/code/algs4-data.zip)

### **代码改进**

**解决文件重定向问题**

- 在书中是通过文件重定向的方式进行算法测试的, 在IDEA中通过以下代码进行文件重定向

```java
import java.io.FileInputStream;
import java.io.FileNotFoundException;

try {
        FileInputStream input = new FileInputStream("./algs4data/tinyT.txt");
        System.setIn(input);
} catch (FileNotFoundException e) {
        e.printStackTrace();
}
```