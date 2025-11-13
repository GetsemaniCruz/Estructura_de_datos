import java.util.Arrays;

public class SelectionSort {

    public void sort(int[] arr){
        
        int n = arr.length;

    for (int i = 0; i < n - 1; i++) {
        int minIndex = i; //seleccionamos el primero como el menor

        for (int j = i + 1; j < n; j++) { //iniciamos desde la parte no ordenada
            if (arr[j] < arr[minIndex]) {
                minIndex = j;//indice menor de la parte no odernada
            }
        }
        //intercambiamos el menor con el primero de la parte no ordenada
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
    System.out.println(java.util.Arrays.toString(arr));
    }

}
