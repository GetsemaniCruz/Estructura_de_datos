import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        
        int[] temperaturas = {20, 15, 30, 10, 40, 22, 18};

        int[] original = new int[temperaturas.length];
        for (int i = 0; i < temperaturas.length; i++) {
            original[i]= temperaturas[i];
        }

        System.out.println("Arreglo original:");
        System.out.println(Arrays.toString(original));

        InsertionSort sorting = new InsertionSort();
        sorting.sort(temperaturas);

        int minimo =temperaturas[0];
        int maximo =temperaturas[temperaturas.length-1];
        int rango =maximo-minimo;

        int cantidadBajas = 3;
        if (temperaturas.length < 3) {
            cantidadBajas=temperaturas.length;
        }

        int[] bajas = new int[cantidadBajas];
        for (int i = 0; i < cantidadBajas; i++) {
            bajas[i]=temperaturas[i];
        }

        int cantidadAltas =3;
        if (temperaturas.length < 3) {
            cantidadAltas=temperaturas.length;
        }

        int[] altas = new int[cantidadAltas];
        int inicioAltas = temperaturas.length-cantidadAltas;

        int index = 0;
        for (int i = inicioAltas; i < temperaturas.length; i++) {
            altas[index] =temperaturas[i];
            index++;
        }

        System.out.println("\nArreglo ordenado:");
        System.out.println(Arrays.toString(temperaturas));

        System.out.println("\nTemperatura mínima: "+minimo);
        System.out.println("Temperatura máxima: "+maximo);
        System.out.println("Rango: "+rango);

        System.out.println("\nTemperaturas más bajas:");
        for (int i = 0; i < cantidadBajas; i++) {
            System.out.println(bajas[i]);
        }

        System.out.println("\nTemperaturas más altas:");
        for (int i = 0; i < cantidadAltas; i++) {
            System.out.println(altas[i]);
        }
    }
}
