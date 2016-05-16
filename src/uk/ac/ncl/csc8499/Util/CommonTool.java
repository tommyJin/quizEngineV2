package uk.ac.ncl.csc8499.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tommy on 2016/5/16.
 */
public class CommonTool {
    public static List<Integer> getIndex(int number, int size){
        List<Integer> index = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < number; i++) {
            int tmp = r.nextInt(size);
            while (index.contains(tmp)){
                tmp = r.nextInt(size);
            }
            index.add(tmp);
        }
        return index;
    }
}
