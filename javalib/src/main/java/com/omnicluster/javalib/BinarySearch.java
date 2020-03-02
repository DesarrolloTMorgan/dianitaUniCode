package com.omnicluster.javalib;

import java.util.Scanner;

/** Creado por: Diana Rivera 29/02/2020 */
public class BinarySearch {

    /**
     * Método de búsqueda binaria
     *
     * @param arr arreglo en donde buscar el elemento
     * @param l indice inicial de la lista
     * @param r indice del final de la lista
     * @param x elemento a buscar
     * @return regresa el índice donde se encontró el elemento * o -1 si no se encuentra en la lista
     */
    private static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            //Si el elemento se encuentra en la mitad de la lista devuelve ese indice
            if (arr[mid] == x) return mid;

            //Sí el elemento es menor que el valor que está en la mitad
            //debe de encontrarse en el arreglo restante izquiedo
            if (arr[mid] > x) return binarySearch(arr, l, mid - 1, x);

            //Sí no es así el elemento debe de encontrarse en el arreglo restante derecho
            return binarySearch(arr, mid + 1, r, x);
        }

        //si no se retorna nada quiere decir que el elemento buscado no se enuentra en el arreglo
        return -1;
    }

    /**
     * Método de búsqueda binaria
     *
     * @param arr arreglo en donde buscar el elemento
     * @param l indice inicial de la lista
     * @param r indice del final de la lista
     * @param x elemento a buscar
     * @return regresa el índice donde se encontró el elemento * o -1 si no se encuentra en la lista
     */
    private static int binarySearch(String[] arr, int l, int r, String x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            //Si el elemento se encuentra en la mitad de la lista devuelve ese indice
            if (arr[mid].equals(x)) return mid;

            //Sí el elemento es menor que el valor que está en la mitad
            //debe de encontrarse en el arreglo restante izquiedo
            if (arr[mid].compareTo(x) > 0) return binarySearch(arr, l, mid - 1, x);

            //Sí no es así el elemento debe de encontrarse en el arreglo restante derecho
            return binarySearch(arr, mid + 1, r, x);
        }

        //si no se retorna nada quiere decir que el elemento buscado no se enuentra en el arreglo
        return -1;
    }

    /**
     * Método para insertar el valor no encontrado en la lista
     * Inserta el valor en el indice correspondiente
     *
     * @param arr lista a la que se le debe ingresar un elemento
     * @param newValue nuevo valor a insertar
     * @return devuelve un nuevo array de longitud n+1 con el elemento insertado
     * */
    private static int[] insertInArray(int[] arr, int newValue) {
        int[] newArr = new int[arr.length + 1];

        int i;
        for (i = arr.length - 1; (i >= 0 && arr[i] > newValue); i--) newArr[i + 1] = arr[i];

        newArr[i + 1] = newValue;

        for (int j = i; j >= 0; j--) newArr[j] = arr[j];

        return newArr;
    }

    /**
     * Método para insertar el valor no encontrado en la lista
     * Inserta el valor en el indice correspondiente
     *
     * @param arr lista a la que se le debe ingresar un elemento
     * @param newValue nuevo valor a insertar
     * @return devuelve un nuevo array de longitud n+1 con el elemento insertado
     * */
    private static String[] insertInArray(String[] arr, String newValue) {
        String[] newArr = new String[arr.length + 1];

        int i;
        for (i = arr.length - 1; (i >= 0 && arr[i].compareTo(newValue) > 0); i--){
            newArr[i + 1] = arr[i];
        }

        newArr[i + 1] = newValue;

        for (int j = i; j >= 0; j--) {
            newArr[j] = arr[j];
        }

        return newArr;
    }

    /**
     * Función de ayuda para imprimir un array de enteros
     *
     * @param arr arreglo de int
     */
    private static void printArray(int[] arr) {
        System.out.println("Nuevo arreglo con el elemento 's' insertado: \n");
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

    private static void menu(){
        System.out.println("Seleccione la opcion que desee: \n");
        System.out.println("Presione 1 para buscar un elemento ENTERO en un arreglo, " +
                "persione 2 para buscar un elemento STRIRNG en un arreglo, " +
                "presione 3 para salir");
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();


        switch (selection) {
            case 1:
            {
                System.out.println("Ingrese el elemento a buscar");
                int[] arr = {2, 3, 4, 10, 40};
                int s = scanner.nextInt();
                int result = binarySearch(arr, 0, arr.length - 1, s);
                if (result == -1) {
                    System.out.println(
                            "El valor dado en 's' no se encuentra en la lista 'L'"
                                    + " se procede a aniadirlo en el lugar correcto");
                    printArray(insertInArray(arr, s));
                } else {
                    System.out.println(
                            "Valor 's' encontrado en el indice: " + result + " de la lista L[i]");
                }
                break;
            }
            case 2:
            {
                String[] strArr = {"Diana", "Rafa", "Rodrigo", "Tona"};
                System.out.println("Ingrese el string a buscar");
                String s = scanner.next();
                int resultado = binarySearch(strArr, 0, strArr.length - 1, s);
                if (resultado == -1) {
                    System.out.println(
                            "El valor dado en 's' no se encuentra en la lista 'L'"
                                    + " se procede a aniadirlo en el lugar correcto");
                    printArray(insertInArray(strArr, s));
                } else {
                    System.out.println(
                            "Valor 's' encontrado en el indice: " + resultado + " de la lista L[i]");
                }
                menu();
                break;
            }
            case 3:
            {
                System.out.println("Adios");
                break;
            }
            default:
            {
                menu();
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40};
        int s = 11;
        int result = binarySearch(arr, 0, args.length - 1, s);
        if (result == -1) {
            System.out.println(
                    "El valor dado en 's' no se encuentra en la lista 'L'"
                            + " se procede a aniadirlo en el lugar correcto");
            printArray(insertInArray(arr, s));
        } else {
            System.out.println(
                    "Valor 's' encontrado en el indice: " + result + " de la lista L[i]");
        }

        menu();

        //        Scanner scanner = new Scanner(System.in);
        //        int i = scanner.nextInt();
    }
}
