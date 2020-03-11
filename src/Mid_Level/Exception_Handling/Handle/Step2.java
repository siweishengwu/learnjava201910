package Mid_Level.Exception_Handling.Handle;

import java.io.File;
import java.io.FileInputStream;

public class Step2 {
    public static void main(String[] args) {
        File f = new File("D:/1.exe");
        try{
            System.out.println("试图打开D:/1.exe");
            new FileInputStream(f);
            System.out.println("成功打开");
        }catch (Exception e){
            System.out.println("d:/1.exe不存在");
            e.printStackTrace();
        }
    }
}
