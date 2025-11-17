import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SelectionSortt sorting = new SelectionSortt();

        System.out.print("¿Cuántos números deseas ingresar? ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa el número "+(i + 1)+"\n");
            arr[i] = sc.nextInt();
        }
        int countP =0; 
        int countI =0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                countP++;
            else
                countI++;
        }

        int[] pares = new int[countP];
        int[] impares = new int[countI];

        int p = 0;
        int im = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                pares[p++] = arr[i];
            else
                impares[im++] = arr[i];
        }


        sorting.sort(pares);
        sorting.sort(impares);

        System.out.println("\nArreglo original: " + Arrays.toString(arr));
        System.out.println("Pares ordenados: " + Arrays.toString(pares));
        System.out.println("Impares ordenados: " + Arrays.toString(impares));
    }
}

