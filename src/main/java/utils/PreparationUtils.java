package utils;


import java.util.Random;

public class PreparationUtils {
    public static int getRandomIntegerBetweenRange(int min, int max){
        Random random = new Random();
        int x = random.nextInt(min, max);
        return x;
    }
}
