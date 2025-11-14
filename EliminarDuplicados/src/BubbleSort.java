import java.util.Arrays;

public class BubbleSort {

    public void sort(int[] arr){
        int n = arr.length;
        boolean swappet = false;
        System.out.println("Arreglo original ");
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1 -i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =temp;
                    swappet=true;
                }
            }
            if (!swappet) {
                break;
            }
        }
        System.out.println("Arreglo ordenado ");
        System.out.println(Arrays.toString(arr));
    }

    public int[] removeDuplicates(int[] arr) {
        int count=1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i]!= arr[i-1]) {
                count++;
            }
        }

        int[] result = new int[count];
        if (arr.length > 0) {
            result[0]=arr[0];
        }

        int index = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i]!= arr[i-1]) {
                result[index]=arr[i];
                index++;
            }
        }

        return result;
    } 

}
