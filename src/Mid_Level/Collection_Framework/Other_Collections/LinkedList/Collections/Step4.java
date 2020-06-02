package Mid_Level.Collection_Framework.Other_Collections.LinkedList.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Step4 {
    public static void main(String[] args) {
        //初始化集合numbers
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        System.out.println("集合中的数据：");
        System.out.println(numbers);

        Collections.swap(numbers,0,5);
        System.out.println("交换0和5下标数据后，集合中的数据：");
        System.out.println(numbers);
    }
}
