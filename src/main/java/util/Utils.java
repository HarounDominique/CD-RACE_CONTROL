package util;

import java.util.Random;

public class Utils {
    public static Random r = new Random();
    public static int getRandomNumberInRange(int min, int max){
        max++;
        return r.nextInt(max-min)+min;
    }
}
