import java.util.Arrays;

public class InsertionSort {

    public void sort(int[] arr){

        int n = arr.length;
        for (int i = 1; i < n; i++) {//comenzamos desde el segundo elemento
            int temp = arr[i];//el primer elemento de la parte desordenada
            int j = i - 1;//comenzamos desde el ultimo elemento de la parte ordenada
            while(j >= 0 && arr[j] > temp){//Recorremos la parte ordenada(fin-inicio)
                arr[j + 1] = arr[j];//recorremos la derecha de los elementos mayores temporales
                j--;
            }
            arr[j + 1] = temp;//insertamos el elemento en su posicion correcta
        }
        System.out.println(Arrays.toString(arr));
    }


}
