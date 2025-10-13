public class App {
    public static void main(String[] args) {

        int[][] arrTest = {
            {1},
            {6,3,1},
            {1,2,3,4},
            {0,5,3,0},
            {2,5,9},
            {2,4,8,9,10}
        };

        int[][] nuevoArr = new int[arrTest.length][];

        for (int i = 0; i < arrTest.length; i++) {
            nuevoArr[i] = new int[arrTest[i].length + 1];
            for (int j = 0; j < arrTest[i].length; j++) {
                nuevoArr[i][j] = arrTest[i][j];
            }

            int ultimoNum = arrTest[i][arrTest[i].length - 1];
            nuevoArr[i][nuevoArr[i].length - 1] = ultimoNum + 1;
        }    
        for (int i = 0; i < nuevoArr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < nuevoArr[i].length; j++) {
                System.out.print(nuevoArr[i][j]);
                if (j < nuevoArr[i].length - 1) System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
