public class QuickSort {

    public void quickSort(int[] arr){
        quickSort(arr, 0, arr.length -1);
    }

    public void quickSort(int[] arr, int low, int high){
        if(low < high){//caso base

            int pivot = partition(arr, low, high);//Realiza la particion del arreglo
            //lamados recursivos para los subarreglos

            //ordenar el lado izquierdo
            quickSort(arr, low, high-1);

            //ordenar el lado derecho
            quickSort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high){
        int pivot = arr[high];//seleccion de pivote(ultimo elemento)
        int i = low - 1;//establece la frontera de los elementos menores que el pivote

        for (int j = low; j < high; j++) {
            if(arr[j] < pivot){
                i++;//incrementa la frontera de los menores
                swap(arr, i ,j);//realiza el intercambio del elemento corriente a la primera posicion de la frontera
            }
        }
        //mover pivote a la posicion final de la frontera
        swap(arr, i+1, high);
        return i+1;//devuelve la posicion del pivote
    }

    private void swap(int[] arr, int i, int j) {//realiza el intercambio de posiciones de dos elementos en un arreglo
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
