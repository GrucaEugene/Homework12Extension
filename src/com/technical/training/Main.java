package com.technical.training;

import java.util.Arrays;
import java.util.Scanner;

/*** Описать класс ArrayPrinter, содержащий 2 метода
 1) публичный метод print(int[] array) выводящий массив
 2) защищенный метод printElem(int elem) для вывода одного элемента (в базовом классе пуст)

 Определить минимум 2 наследника этого класса в которых перегрузить абстрактный метод
 Объявить в методе main 3 произвольных массива, предоставить пользователю возможность выбрать,
 какой из реализаций пользоваться для вывода и поочередно вывести эти массивы используя arrayPrinter

 Код выбора принтера должен быть примерно таким:
 if(choice == 1) arrayPrinter = new PrettyArrayPrinter();
 else arrayPrinter = new DefaultArrayPrinter()*/

class ArrayPrinter {

    public void print(int[] array, int index) {
        System.out.println("-----------Whole printed array------------");
        System.out.println(Arrays.toString(array));
        printElem(array, index);
    }

    protected void printElem(int[] array, int index) {
    }
}

class SamsungArrayPrinter extends ArrayPrinter {

    @Override
    protected void printElem(int[] array, int index) {
        System.out.println("------------Samsung Inc.--------------");
        System.out.println("Printed (index: "+index+") array element: " + array[index]);
        System.out.println("-------- All rights reserved----------");

    }
}

class CanonArrayPrinter extends ArrayPrinter {

    @Override
    protected void printElem(int[] array, int index) {
        System.out.println("--------------Canon Inc.--------------");
        System.out.println("Printed (index: "+index+") array element: " + array[index]);
        System.out.println("-------- All rights reserved----------");

    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayPrinter arrayPrinter = null;

        int[] arr1 = {12, 32, 34, 54, 56, 67, 87, 98, 99, 84, 34};
        int[] arr2 = {21, 23, 43, 45, 65, 76, 78, 89, 55, 48, 43};
        int[] arr3 = {32, 34, 54, 75, 43, 91, 24, 82, 44, 37, 29};

        int choice;
        do {
            System.out.println("-------------------------------");
            System.out.println("Chose Printer you want to use!:");
            System.out.println("-------------------------------");
            System.out.println("Samsung - Input 1");
            System.out.println("Canon - Input 2");
            System.out.println("-------------------------------");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> arrayPrinter = new SamsungArrayPrinter();
                case 2 -> arrayPrinter = new CanonArrayPrinter();
                default -> System.out.println("Error, try again");
            }
        } while (choice != 1 && choice != 2);

        arrayPrinter.print(arr1,1);
        arrayPrinter.print(arr2, 2);
        arrayPrinter.print(arr3, 3);


    }
}
