package Mid_Level.I_O.File_Obeject;

import java.io.File;
import java.io.IOException;

public class Step3 {
    public static void main(String[] args) throws IOException {

        File f = new File("d:/LOLFolder/skin/garen.ski");

        // 以字符串数组的形式，返回当前文件夹下的所有文件（不包括子文件及子文件夹）
        f.list();

        // 以文件数组的形式，返回当前文件夹下的所有文件（不包括子文件及文件夹）
        File[]fs = f.listFiles();

        // 以字符串形式返回获取所在文件夹
        f.getParent();

        // 以文件形式返回获取所在文件夹
        f.getParentFile();

        // 创建文件夹，如果父文件夹skin不存在，创建就无效
        f.mkdir();

        // 创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
        f.mkdirs();

        // 创建一个空文件，如果父文件夹skin不存在，就会抛出异常
        f.createNewFile();

        // 所以创建一个文件夹之前，通常都会创建父目录
        f.getParentFile().mkdirs();

        // 列出所有的盘符
        f.listRoots();

        // 删除文件
        f.delete();

        // jvm结束的时候，删除文件，常用于临时文件的删除
        f.deleteOnExit();
    }
}
