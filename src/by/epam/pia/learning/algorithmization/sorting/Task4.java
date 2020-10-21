package by.epam.pia.learning.algorithmization.sorting;

//4. Реализуйте сортировку вставками.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task4 {

    private static final int RANGE = 100;

    public static void main(String[] args) {

        int n;
        int[] a;

        do {
            n = input("Введите количество элементов массива n(>1)=");
        } while (n < 2);

        a = createArray(n);

        //красивая реализация, но вместо присвоения своп (это 2 лишних присвоения) в каждой итерации
        /*for (int i = 1; i<a.length; i++ ){
            for (int j = i ; j > 0 && a[j-1] > a[j]; j--) {
                swap(a,j,j-1);
            }
        }*/

        for (int i = 1; i < a.length; i++) {

            int value = a[i];
            int j = i-1;
            for (; j >= 0 && a[j] > value; j--){
                a[j+1] = a[j];
            }
            a[j+1] = value;
        }

        System.out.println("Результат работы:");
        System.out.println(Arrays.toString(a));
    }

    /*private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }*/

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
