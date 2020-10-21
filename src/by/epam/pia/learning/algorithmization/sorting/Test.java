package by.epam.pia.learning.algorithmization.sorting;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Test {

    private static final int RANGE = 1000;
    private static final int QUANTITY = 100_000;

     /* RANGE = 1000  QUANTITY = 200_000    То же только первым идет сортировка выбором
    Сортировка вставками:3962               Сортировка выбором:16160
    Сортировка вставками со свапом:6080     Сортировка вставками:3240
    Сортировка Шелла:7100
    Сортировка Шелла со свапом:20
    Сортировка выбором:17128                Сортировка вставками со свапом:5609
    Сортировка обменами со свапом:79830
    */

    /* RANGE = 100  QUANTITY = 200_000
    Сортировка вставками:3982
    Сортировка вставками со свапом:6040
    Сортировка Шелла:6940
    Сортировка Шелла со свапом:29
    Сортировка выбором:17300
    Сортировка обменами:79770

    */

    /* RANGE = 10  QUANTITY = 200_000
    Сортировка вставками:3684
    Сортировка вставками со свапом:5450
    Сортировка Шелла:6270
    Сортировка Шелла со свапом:10
    Сортировка выбором:16969
    Сортировка обменами:75601
    */

    /* RANGE = 1  QUANTITY = 200_000
    Сортировка вставками:5
    Сортировка вставками со свапом:0
    Сортировка Шелла:6
    Сортировка Шелла со свапом:11
    Сортировка выбором:4000
    Сортировка обменами:5
    */


    public static void main(String[] args) {
        int[] a = createArray();
        int[] b = a.clone();
        int[] c = a.clone();
        int[] d = a.clone();
        int[] e = a.clone();
        int[] f = a.clone();

        System.out.println("Массивы инициализированы. Let`s go!");

        long startTime;
        long stoptTime;

        startTime = getCurrentTime();
        sortInsert(b);
        stoptTime = getCurrentTime();
        System.out.println("Сортировка вставками:" + (stoptTime - startTime));

        startTime = getCurrentTime();
        sortInsertNice(c);
        stoptTime = getCurrentTime();
        System.out.println("Сортировка вставками со свапом:" + (stoptTime - startTime));

        startTime = getCurrentTime();
        sortShell(f);
        stoptTime = getCurrentTime();
        System.out.println("Сортировка Шелла:" + (stoptTime - startTime));

        //System.out.println(Arrays.toString(e));
        startTime = getCurrentTime();
        sortShellNice(e);
        stoptTime = getCurrentTime();
        System.out.println("Сортировка Шелла со свапом:" + (stoptTime - startTime));
        //System.out.println("Результат работы:");
        //System.out.println(Arrays.toString(e));

        startTime = getCurrentTime();
        sortChoise(a);
        stoptTime = getCurrentTime();
        System.out.println("Сортировка выбором:" + (stoptTime - startTime));

        startTime = getCurrentTime();
        sortSwap(d);
        stoptTime = getCurrentTime();
        System.out.println("Сортировка обменами:" + (stoptTime - startTime));


    }

    private static long getCurrentTime() {
        Date date = new Date();
        return date.getTime();
    }

    private static void sortShell (int[]a){
        for (int step = a.length / 2; step > 0; step /= 2) {
            for (int i = step; i < a.length; i+=step) {

                int value = a[i];
                int j = i - step;
                for (; j >= 0 && a[j] > value; j-=step) {
                    a[j + step] = a[j];
                }
                a[j + step] = value;
            }
        }
    }

    private static void sortShellNice (int[]a){

       for (int step = a.length / 2; step > 0; step /= 2) {
           for (int i = step; i < a.length; i++) {
               for (int j = i - step; j >= 0 && a[j] > a[j + step]; j -= step) {
                   swap(a, j, j + step);

               }
           }
       }
    }

    private static void sortInsert(int[] a) {
        for (int i = 1; i < a.length; i++) {

            int value = a[i];
            int j = i - 1;
            for (; j >= 0 && a[j] > value; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = value;
        }
    }

    private static void sortInsertNice(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    private static void sortChoise(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int indexMIN = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[indexMIN]) {
                    indexMIN = j;
                }
            }
            swap(a, i, indexMIN);

            //System.out.println("Результат работы:");
            //System.out.println(Arrays.toString(a));
        }
    }

    private static void sortSwap(int[] a) {
        boolean change = true;
        while (change) {
            change = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    change = true;
                }
            }
        }
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    private static int[] createArray() {
        Random random;
        random = new Random();
        int[] a;
        a = new int[QUANTITY];
        //System.out.print("Инициализация массива:");
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(RANGE);
            //  System.out.print(a[i] + ", ");
        }
        //System.out.println("\b\b");
        return a;
    }
}
