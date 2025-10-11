import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {

        int[][] arrTest={
            {1},
            {6,3,1},
            {1,2,3,4},
            {0,5,3,0},
            {2,5,9},
           {2,4,8,9,10}
        };

        int[][] nuevoArr = new int[arrTest.length][];

        for (int i = 0; i < arrTest.length; i++) {
            nuevoArr[i] = new int[arrTest[i].length+1];
            System.arraycopy(arrTest[i], 0, nuevoArr[i], 0, arrTest[i].length);
            int ultimoNum = arrTest[i][arrTest[i].length-1];
            nuevoArr[i][nuevoArr[i].length-1] = ultimoNum + 1;
        }

        for (int i = 0; i < nuevoArr.length; i++) {
            System.out.println(Arrays.toString(nuevoArr[i]));
        }

    }
}


