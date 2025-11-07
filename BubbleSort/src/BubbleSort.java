import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr){
        int n= arr.length;
        boolean swappet= false;

        //recorremos todos los elementos del arreglo
        for (int i = 0; i < n-1; i++) {
            //recorremos todos los elementos adyacentes -1-i (por los que ya fueron recorridos)
            for (int j = 0; j < n-1 -i; j++) {
                //pregunta si el elemento corriente es mayor que el siguiente
                if (arr[j] > arr[j+1]) {
                    //se realiza el intercambio
                    int temp = arr[j];
                    arr[j] = arr[j+1];//pasas el elemento siguiente al actual
                    arr[j+1] =temp;//asigna el siguiente elemento con el valor actual de temp
                    swappet=true;
                }
            }
            if (!swappet) {
                break;
            }
        }
        //impresion
        System.out.println("Arreglo ordenado ");
        System.out.println(Arrays.toString(arr));
    }

}
