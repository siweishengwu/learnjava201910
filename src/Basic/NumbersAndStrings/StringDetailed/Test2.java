package Basic.NumbersAndStrings.StringDetailed;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        String ss[] =new String[8];
        for (int i = 0; i <ss.length ; i++) {
            String  randomString = randomString(5);
            ss[i] = randomString;
        }
        System.out.println("未排序:");
        System.out.println(Arrays.toString(ss));

        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j < ss.length - i -1; j++) {
                char firstChar1 = ss[j].charAt(0);
                char firstChar2 = ss[j+1].charAt(0);
                firstChar1 = Character.toLowerCase(firstChar1);
                firstChar2 = Character.toLowerCase(firstChar2);

                if (firstChar1 > firstChar2){
                    String temp = ss[j];
                    ss[j] = ss[j+1];
                    ss[j+1] = temp;
                }
            }
        }
        System.out.println("排序后的数组：");
        System.out.println(Arrays.toString(ss));
    }
    private static String randomString(int length){
        String pool = "";
        for (short i = '0'; i <= '9'; i++) {
            pool += (char)i;
        }
        for (short i = 'a'; i <= 'z'; i++) {
            pool += (char)i;
        }
        for (short i = 'A'; i <= 'Z'; i++) {
            pool += (char)i;
        }
        char cs[] = new char[length];
        for (int i = 0; i < cs.length ; i++) {
            int index = (int) (Math.random() * pool.length());
            cs[i] = pool.charAt(index);
        }
        String result = new String(cs);
        return result;
    }
}
