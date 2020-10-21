package by.epam.pia.learning.algorithmization.sorting;

//1. Заданы два одномерных массива с различным количеством элементов и натуральное число k.
//Объединить их в один массив, включив второй массив между k-м и (k+1) - м
//элементами первого, при этом не используя дополнительный массив.

import java.awt.font.NumericShaper;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {

    private static final int RANGE = 100;

    public static void main(String[] args) {

        int k;

        int n;
        int firstIndex;
        int[] firstArray;

        int m;
        int secondIndex;
        int[] secondArray;

        int[] result;

        do {
            n = input("Введите количество элементов первого массива n(>1)=");
        } while (n < 2);

        firstArray = createArray(n);

        do {
            m = input("Введите количество элементов второго массива m(>0)=");
        } while (m < 1);

        secondArray = createArray(m);

        do {
            k = input("Введите натуральное число к(1..." + (n - 1) + ")=");
        } while (k < 1 || k > n - 1);

        result = new int[n+m];
        firstIndex=0;
        secondIndex=0;

        for (int i = 0; i<result.length; i++ ){
            if (i<k || i>(m+k-1)){
                result[i]=firstArray[firstIndex++];
            }else {
                result[i]=secondArray[secondIndex++];
            }
        }
        System.out.println("Результат работы:");
        System.out.println(Arrays.toString(result));
    }

    private static int[] createArray(int n) {
        Random random;
        random = new Random();
        int[] a;
        a = new int[n];
        System.out.print("Инициализация массива:");
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(RANGE);
            System.out.print(a[i] + ", ");
        }
        System.out.println("\b\b");
        return a;
    }

    private static int input(String prompt) {

        Scanner scanner;
        scanner = new Scanner(System.in);

        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.nextLine();
        }
        return scanner.nextInt();
    }
}
