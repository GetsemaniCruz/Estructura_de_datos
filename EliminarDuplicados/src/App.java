import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {4, 2, 9, 2, 4, 7, 1};

        bubbleSort.sort(arr);
        int[] eliminarDuplicadosArr = bubbleSort.removeDuplicates(arr);
        System.out.println("Arreglo sin duplicados ");
        System.out.println(Arrays.toString(eliminarDuplicadosArr));
    }
}
