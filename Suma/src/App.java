import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Ingresa un numero ");
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        int resultado = suma(numero);
        System.out.println("El resultado es "+resultado);
        scanner.close();
    }

    public static int suma(int n){
        if(n==0){
            return 0;
        }
        return n + suma(n-1);
    }
}
