package test.sort;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class Algotithm {

    /**
     * 获取Random
     *
     * @return
     */
    public static Random getRandom() {
        return new Random();
    }

    /**
     * 生成一个int类型的数组
     *
     * @param length      数组的长度
     * @param randomRange 随机生成每一个元素，元素必须小于randomRange且大于1
     * @return
     */
    public static int[] getRandomArray(int length, int randomRange) {
        if (length < 0) {
            throw new IllegalArgumentException("the length must be positive");
        }
        if (randomRange < 1) {
            throw new IllegalArgumentException("the randomRange must >= 1");
        }
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = getRandom().nextInt(randomRange);
        }
        return array;
    }

    /**
     * 定义一个int型的一维数组，包含10个元素， 分别赋一些随机整数，然后求出所有元素的最大值， 最小值，平均值，和值，并输出出来
     */
    @Test
    public void test1() {
        int[] array = getRandomArray(10, 100);
        System.out.println(array.length);

        System.out.println(Arrays.toString(array));

        // 最大值
        int max = array[0];
        // 最小值
        int min = array[0];
        // 求和
        int sum = 0;

        for (int arr : array) {
            if (max < arr) {
                max = arr;
            }
            if (min > arr) {
                min = arr;
            }
            sum += arr;
        }

        System.out.println("max:" + max);
        System.out.println("min:" + min);
        System.out.println("sum:" + sum);
        System.out.println("avg:" + ((double) sum / array.length));

    }

    /**
     * 冒泡算法，从小到大排列，打印出大于小于等于0的元素个数
     */
    @Test
    public void test2() {
        int[] array = getRandomArray(10, 100);
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k < array.length - i - 1; k++) {
                if (array[k] > array[k + 1]) {
                    int change = array[k];
                    array[k] = array[k + 1];
                    array[k + 1] = change;
                }
            }
        }
        System.out.println(Arrays.toString(array));
        int positiveNum = 0;
        int nagitiveNum = 0;
        int zeroNum = 0;
        for (int arr : array) {
            if (arr == 0) {
                zeroNum += 1;
            } else if (arr > 0) {
                positiveNum += 1;
            } else {
                nagitiveNum += 1;
            }
        }
        System.out.print(">0:" + positiveNum);
        System.out.print("\t=0:" + nagitiveNum);
        System.out.println("\t<0:" + zeroNum);
    }

    /**
     * 定义一个int型的一维数组，包含10个元素，分别赋值为1~10， 然后将数组中的元素都向前移一个位置，
     * 即，a[0]=a[1],a[1]=a[2],最后一个元素的值是原来第一个元素的值，然后输出这个数组。
     */
    @Test
    public void test3() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(array));

        int change = array[0];
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = change;
        System.out.println(Arrays.toString(array));
    }

    /**
     * 定义一个int型的一维数组，包含40个元素，用来存储每个学员的成绩，循环产生40个0~100之间的随机整数，
     * 将它们存储到一维数组中，然后统计成绩低于平均分的学员的人数，并输出出来。
     */
    @Test
    public void test4() {
        int[] array = getRandomArray(40, 100);
        System.out.println(Arrays.toString(array));

        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double avg = sum / array.length;
        System.out.println("avg:" + avg);
        for (int i : array) {
            if (i < avg) {
                System.out.print(i + ",");
            }
        }
    }

    /**
     * 编写程序，将一个数组中的元素倒排过来。例如原数组为1，2，3，4，5；则倒排后数组中的值为5，4，3，2，1。
     */
    @Test
    public void test5() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length / 2; i++) {
            int change = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = change;
        }

        System.out.println(Arrays.toString(array));
    }

    /**
     * 要求定义一个int型数组a,包含100个元素,保存100个随机的4位数。再定义一个
     * int型数组b，包含10个元素。统计a数组中的元素对10求余等于0的个数，保存
     * 到b[0]中；对10求余等于1的个数，保存到b[1]中，依此类推。
     */
    @Test
    public void test6() {

//        int[] a = new int[100];
//        
//        for (int i = 0; i < a.length; i++) {
//            a[i] = (int) (Math.random()*100);
//        }

        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(a));

        int[] b = new int[10];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] % 10 == j) {
                    b[j] += 1;
                }
            }
        }

        System.out.println(Arrays.toString(b));
    }

    /**
     * 判断一个数是不是素数
     *
     * @param n
     * @return
     */
    public static boolean isPrimeNubmer(int n) {
        if (n <= 3) {
            return n > 1;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
