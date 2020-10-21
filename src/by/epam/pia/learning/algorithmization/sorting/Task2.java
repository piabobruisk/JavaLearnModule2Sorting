package by.epam.pia.learning.algorithmization.sorting;

//2. Реализуйте сортировку выбором.

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    private static final int RANGE = 100;

    public static void main(String[] args) {

        int n;
        int[] a;

        do {
            n = input("Введите количество элементов массива n(>1)=");
        } while (n < 2);

        a = createArray(n);

        for (int i = 0; i<a.length; i++ ){
            int indexMIN = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[indexMIN]) {
                    indexMIN = j;
                }
            }
            swap(a,i,indexMIN);
        }

        System.out.println("Результат работы:");
        System.out.println(Arrays.toString(a));
    }

    private static void swap(int[] array, int ind1, int ind2) {
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
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
