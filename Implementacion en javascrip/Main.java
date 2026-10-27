
import java.util.Arrays;

public class Main {

    // ==========================================
    // METODO 1: ORDENAMIENTO DE BURBUJA
    // Complejidad promedio y peor caso: O(n^2)
    // ==========================================
    public static void burbuja(int[] datos) {

        for (int i = 0; i < datos.length - 1; i++) {

            for (int j = 0; j < datos.length - 1 - i; j++) {

                if (datos[j] > datos[j + 1]) {

                    int aux = datos[j];
                    datos[j] = datos[j + 1];
                    datos[j + 1] = aux;

                }
            }
        }
    }
    // FIN DEL METODO BURBUJA


    // ==========================================
    // METODO 2: ORDENAMIENTO POR INSERCION
    // Mejor caso: O(n)
    // Promedio y peor caso: O(n^2)
    // ==========================================
    public static void insercion(int[] datos) {

        for (int i = 1; i < datos.length; i++) {

            int actual = datos[i];
            int j = i - 1;

            while (j >= 0 && datos[j] > actual) {

                datos[j + 1] = datos[j];
                j--;

            }

            datos[j + 1] = actual;
        }
    }
    // FIN DEL METODO INSERCION


    // ==========================================
    // METODO 3: ORDENAMIENTO RAPIDO (QUICKSORT)
    // Promedio: O(n log n)
    // Peor caso: O(n^2)
    // ==========================================
    public static void quickSort(int[] datos, int inicio, int fin) {

        if (inicio < fin) {

            int pivote = datos[fin];
            int i = inicio - 1;

            for (int j = inicio; j < fin; j++) {

                if (datos[j] <= pivote) {

                    i++;

                    int aux = datos[i];
                    datos[i] = datos[j];
                    datos[j] = aux;

                }
            }

            int aux = datos[i + 1];
            datos[i + 1] = datos[fin];
            datos[fin] = aux;

            int posicion = i + 1;

            // Ordenar la parte izquierda
            quickSort(datos, inicio, posicion - 1);

            // Ordenar la parte derecha
            quickSort(datos, posicion + 1, fin);

        }
    }
    // FIN DEL METODO QUICKSORT


    // ==========================================
    // METODO 4: BUSQUEDA LINEAL
    // Complejidad promedio y peor caso: O(n)
    // ==========================================
    public static int busquedaLineal(int[] datos, int valor) {

        for (int i = 0; i < datos.length; i++) {

            if (datos[i] == valor) {
                return i;
            }

        }

        return -1;
    }
    // FIN DEL METODO BUSQUEDA LINEAL


    // ==========================================
    // METODO 5: BUSQUEDA BINARIA
    // Requiere datos ordenados.
    // Promedio y peor caso: O(log n)
    // ==========================================
    public static int busquedaBinaria(int[] datos, int valor) {

        int inicio = 0;
        int fin = datos.length - 1;

        while (inicio <= fin) {

            int medio = inicio + (fin - inicio) / 2;

            if (datos[medio] == valor) {
                return medio;
            }

            if (datos[medio] < valor) {

                inicio = medio + 1;

            } else {

                fin = medio - 1;

            }
        }

        return -1;
    }
    // FIN DEL METODO BUSQUEDA BINARIA


    // ==========================================
    // METODO 6: ANALISIS BIG-O
    // Muestra la complejidad de cada algoritmo.
    // ==========================================
    public static void analizarComplejidad() {

        System.out.println("\n--- ANALISIS DE COMPLEJIDAD BIG-O ---");
        System.out.println("Burbuja: O(n^2) promedio y peor caso");
        System.out.println("Insercion: O(n^2) promedio y peor caso");
        System.out.println("QuickSort: O(n log n) promedio");
        System.out.println("QuickSort: O(n^2) peor caso");
        System.out.println("Busqueda lineal: O(n) peor caso");
        System.out.println("Busqueda binaria: O(log n) peor caso");

    }
    // FIN DEL METODO ANALISIS BIG-O


    // ==========================================
    // METODO PRINCIPAL: MAIN
    // Ejecuta todos los algoritmos anteriores.
    // ==========================================
    public static void main(String[] args) {

        int[] original = {8, 3, 6, 1, 9, 2, 5};
        int valorBuscado = 6;

        // Crear copias para probar cada ordenamiento
        int[] arregloBurbuja = original.clone();
        int[] arregloInsercion = original.clone();
        int[] arregloQuickSort = original.clone();

        // ------------------------------------------
        // EJECUCION DEL ORDENAMIENTO DE BURBUJA
        // ------------------------------------------
        System.out.println("ARREGLO ORIGINAL:");
        System.out.println(Arrays.toString(original));

        burbuja(arregloBurbuja);

        System.out.println("\nORDENAMIENTO DE BURBUJA:");
        System.out.println(Arrays.toString(arregloBurbuja));

        // ------------------------------------------
        // EJECUCION DEL ORDENAMIENTO POR INSERCION
        // ------------------------------------------
        insercion(arregloInsercion);

        System.out.println("\nORDENAMIENTO POR INSERCION:");
        System.out.println(Arrays.toString(arregloInsercion));

        // ------------------------------------------
        // EJECUCION DE QUICKSORT
        // ------------------------------------------
        quickSort(arregloQuickSort, 0, arregloQuickSort.length - 1);

        System.out.println("\nORDENAMIENTO QUICKSORT:");
        System.out.println(Arrays.toString(arregloQuickSort));

        // ------------------------------------------
        // EJECUCION DE LA BUSQUEDA LINEAL
        // ------------------------------------------
        int resultadoLineal =
                busquedaLineal(original, valorBuscado);

        System.out.println("\nBUSQUEDA LINEAL:");

        if (resultadoLineal != -1) {
            System.out.println("Valor encontrado en la posicion: "
                    + resultadoLineal);
        } else {
            System.out.println("Valor no encontrado.");
        }

        // ------------------------------------------
        // EJECUCION DE LA BUSQUEDA BINARIA
        // Se utiliza el arreglo ordenado.
        // ------------------------------------------
        int resultadoBinario =
                busquedaBinaria(arregloQuickSort, valorBuscado);

        System.out.println("\nBUSQUEDA BINARIA:");

        if (resultadoBinario != -1) {
            System.out.println("Valor encontrado en la posicion: "
                    + resultadoBinario);
        } else {
            System.out.println("Valor no encontrado.");
        }

        // ------------------------------------------
        // EJECUCION DEL ANALISIS BIG-O
        // ------------------------------------------
        analizarComplejidad();

    }
    // FIN DEL METODO MAIN

}
// FIN DE LA CLASE MAIN
