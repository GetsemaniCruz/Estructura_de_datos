import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántas calificaciones deseas registrar?");

        
        int num_calificacion= sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[num_calificacion];
        int[] calificaciones = new int[num_calificacion];

        for (int i = 0; i < num_calificacion; i++) {
            System.out.println("Ingresa el nombre del alumno " + (i + 1) + ":");
            nombres[i] = sc.nextLine();

            System.out.println("Ingresa la calificación de " + nombres[i] + ":");
            calificaciones[i] = sc.nextInt();
            sc.nextLine();
        }
        SelectionSort sorting = new SelectionSort();
        sorting.sort(nombres, calificaciones);
        

        System.out.println("Calificaciones de alumnos");
        for (int i = 0; i < num_calificacion; i++) {
            System.out.println("Calificación: " + calificaciones[i]+ " -> Alumno: " + nombres[i] );
        }
        sc.close();
    }
}
