import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántos números deseas ingresar? ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] original = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa el número "+(i + 1)+"\n");
            arr[i] =sc.nextInt();
            original[i] =arr[i];
        } 

        System.out.println("\nArreglo original:");
        for (int i = 0; i < n; i++) {
            System.out.print(original[i]+",");
        }
        System.out.println();

        BubbleSort sorting = new BubbleSort();
        sorting.sort(arr);

        int minimo =arr[0];
        int maximo =arr[n-1];
        int diferencia =maximo-minimo;

        System.out.println("\nArreglo ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+",");
        }

        System.out.println("\n\nValor mínimo: "+minimo);
        System.out.println("Valor máximo: "+maximo);
        System.out.println("Diferencia: "+diferencia);
    }
}
