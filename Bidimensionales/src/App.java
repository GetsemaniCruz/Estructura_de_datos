import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        //declarar e inicializar
        int[][] arrBiA = new int[4][4];

        int[][] arrBiB;
        arrBiB = new int[4][4];
        System.out.println(arrBiA[0][0]);

        //acceso
        arrBiA[0][3]=10;

        //imprimir
        for(int i = 0; i < arrBiB.length; i++){
            for(int j = 0; j < arrBiB.length; j++){ 
                System.out.println(arrBiB[i][j]);
            }
            System.out.println();
        }
        System.out.println(arrBiB[0][3]);
        //declaracion literal
        int[][] arrBiC = {
            { 1 , 2 , 3 , 4 },
            { 1 , 2 , 3 , 4 },
            { 1 , 2 , 3 , 4 },
            { 1 , 2 , 3 , 4 }
        };

        //imprimir con for each
        for(int[] fila : arrBiC){
            for(int valor : fila){
                System.out.println(valor);
            }
            System.out.println();
        }
        System.out.println(Arrays.deepToString(arrBiC));

        int[][] arrBiD = {
            { 1 , 2 , 3 },
            { 1 , 2 , 3 , 4 , 5 },
            { 1 },
            { 2 , 2 , 2 , 2 , 2 , 2 }
        };

        System.out.println(Arrays.toString(arrBiD[0]));
        for(int i = 0; i < arrBiD.length; i++){
            for(int j = 0; j < arrBiD[i].length; j++){ 
                System.out.println(arrBiD[i][j]);
            }
            System.out.println();
        }
        //copiar arreglos independientes
        int[] a = {1,2,3,4};
        int[] b = new int[4];
        System.out.println(Arrays.toString(b));
        System.arraycopy(a, 0, b, 0, 4);
        /*for (int i = 0; i < a.length; i++) {
            b[i]=a[i];
        }*/
        System.out.println(Arrays.toString(b));
        int[] c = Arrays.copyOf(a, 5);
        System.out.println(Arrays.toString(c));



    }
}
