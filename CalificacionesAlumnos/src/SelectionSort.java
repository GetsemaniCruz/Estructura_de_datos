import java.util.Scanner;

public class SelectionSort {

    public void sort(String[] nombres, int[] calificaciones) {
        int n = calificaciones.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdex = i;
            for (int j = i + 1; j < n; j++) {
                if (calificaciones[j] < calificaciones[minIdex]) {
                    minIdex = j;
                }
            }
            
            int tempCal = calificaciones[minIdex];
            calificaciones[minIdex] = calificaciones[i];
            calificaciones[i] = tempCal;

            String tempName = nombres[minIdex];
            nombres[minIdex] = nombres[i];
            nombres[i] = tempName;
        }
    }
    

}
