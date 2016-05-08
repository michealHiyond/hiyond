package test.sort;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class MaoPao {
    
    public static void main(String[] args) {
        int[] score = { 69, 65, 75, 87, 89, 90, 100, 99, 0, -1, -2 };
        int[] arr = score.clone();
        System.out.println(Arrays.toString(sort(score)));
        getClass(score);
        System.out.println(Arrays.toString(arr));
        System.out.print(Arrays.toString(arr));
    }

   public static int[] sort(int[] array) {
        if (ArrayUtils.isEmpty(array)) {
            throw new IllegalArgumentException("参数array is null");
        }
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array.length - 1 - i; k++) {
                if (array[k] > array[k + 1]) {
                    int change = array[k + 1];
                    array[k + 1] = array[k];
                    array[k] = change;
                }
            }
        }
        return array;
    }
    
    public static void getClass(int[] array) {
        if (ArrayUtils.isEmpty(array)) {
            throw new IllegalArgumentException("参数array is null");
        }
        int zheng = 0;
        int fu = 0;
        int zero = 0;
        for (int arr : array) {
            if (arr == 0) {
                zero += 1;
            } else if (arr > 0) {
                zheng += 1;
            } else {
                fu += 1;
            }
        }
        System.out.print(">0:" + zheng);
        System.out.print("\t=0:" + zero);
        System.out.println("\t<0:" + fu);
    }
    
}
