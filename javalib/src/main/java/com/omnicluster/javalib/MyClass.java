package com.omnicluster.javalib;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Creado por: Diana Rivera 29/02/2020
 * */
public class MyClass {

    /**
     * Método para ordenar un array usando el método de inserción
     *
     * @param arr array de int[] a ordenar
     */
    private void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            // Key es el elemento a evaluar donde séra insertado
            // Con el método de la insersción se presume que el primer elemento
            // del arreglo está ordenado
            int key = arr[i];
            int j = i - 1; // la variable J se utiliza para mantener

            /*
             * Se mueven los elementos del array desde
             * arr[0] hasta arr[i-1] que son mayores que
             * la llave, se mueven una posición adelante de su posición
             * actual
             * */
            while (j >= 0
                    && arr[j] > key) { // Aquí comparamos si el valor actual a insertar es menor
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Método para ordenar un array usando el método de inserción
     *
     * @param arr array de String[] a ordenar
     */
    private void insertionSort(String[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            // Key es el elemento a evaluar donde séra insertado
            // Con el método de la insersción se presume que el primer elemento
            // del arreglo está ordenado
            String key = arr[i];
            int j = i - 1; // la variable J se utiliza para mantener

            /*
             * Se mueven los elementos del array desde
             * arr[0] hasta arr[i-1] que son mayores que
             * la llave, se mueven una posición adelante de su posición
             * actual
             * */
            while (j >= 0 && arr[j].compareTo(key) > 0) { // Aquí comparamos si el valor actual es
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * Función de ayuda para imprimir un array de enteros
     *
     * @param arr arreglo de int
     */
    private static void printArray(int[] arr) {
        System.out.println("Tu arreglo ordenado es: \n");
        for (int value : arr) System.out.print(value + " ");
        System.out.println();
    }

    /**
     * Función de ayuda para imprimir un array de Strings
     *
     * @param arr arreglo de String
     */
    private static void printArray(String[] arr) {
        System.out.println("Tu arreglo ordenado es: \n");
        for (String s : arr) System.out.print(s + ", ");
        System.out.println();
    }

    /**
     * Función del menú del programa
     *
     * @param scanner {Scanner} recibe el receptor de entrada de consola
     */
    private static void menu(Scanner scanner) {
        MyClass ob = new MyClass();
        System.out.println(
                "Presione 1 para ordenar un array de enteros, "
                        + "2 para ordenar un array de Strings "
                        + "o presione 3 para salir");
        int selection = scanner.nextInt();

        switch (selection) {
            case 1:
                {
                    try {
                        System.out.println("Ingrese el total de elementos del array");
                        int n = scanner.nextInt();
                        if (n > 1) {
                            System.out.println("Ingrese los valores del array");
                            int[] userArray = new int[n];
                            for (int i = 0; i < n; i++) {
                                userArray[i] = scanner.nextInt();
                            }
                            System.out.println("Tu arreglo ordenado es: \n");
                            ob.insertionSort(userArray);
                            printArray(userArray);
                        } else {
                            System.out.println("El arreglo a ordenar debe tener mas de 1 elemento");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(
                                "El valor ingresado no corresponde al tipo de valor a ingresar");
                    }
                    menu(scanner);
                    break;
                }
            case 2:
                {
                    System.out.println("Ingrese el total de elementos del array");
                    try {
                        int n = scanner.nextInt();
                        if (n > 1) {
                            System.out.println("Ingrese los valores del array");
                            String[] userArray = new String[n];
                            for (int i = 0; i < n; i++) {
                                userArray[i] = scanner.next();
                            }
                            ob.insertionSort(userArray);
                            printArray(userArray);
                        } else {
                            System.out.println("El arreglo a ordenar debe tener mas de 1 elemento");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println(
                                "El valor ingresado no corresponde al tipo de valor a ingresar");
                    }
                    menu(scanner);
                    break;
                }
            case 3:
                System.out.println("Adios");
                break;
            default:
                System.out.println("Comando desconocido");
                menu(scanner);
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al programa de ordenamiento de arreglos por insercion");
        System.out.println(
                "Menu del programa, por favor ingrese la letra "
                        + "del programa que le gustaria probar");
        menu(scanner);

        //        int[] arr = {12, 11, 13, 5, 6};
        //        String[] arr2 = {"Tona", "Diana", "Rodrigo", "Rafa", "Kristian", "Maiki"};
        //        ob.insertionSort(arr);
        //        printArray(arr);
        //        ob.insertionSort(arr2);
        //        printArray(arr2);
    }
}
