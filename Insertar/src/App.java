public class App {
    public static void main(String[] args) throws Exception {
        int[][] arrNormal = {
            {1},           // impar -> agrega 0
            {6,3,1},       // impar -> agrega 0
            {1,2,3,4},     // par   -> agrega (1+4)=5
            {0,5,3,0},     // par   -> agrega (0+0)=0
            {2,5,9},       // impar -> agrega 0
            {2,4,8,9,10}   // impar -> agrega 0
        };

        int[][] arrNu = new int[arrNormal.length][];
        
        for (int i = 0; i < arrNormal.length; i++) {
            arrNu[i] = new int[arrNormal[i].length +1];
            for (int j = 0; j < arrNormal[i].length; j++) {
                arrNu[i][j] = arrNormal[i][j];
            }

            if(arrNormal[i].length % 2 == 0){
                int primero = arrNormal[i][0];
                int ultimo = arrNormal[i][arrNormal[i].length -1];
                arrNu[i][arrNu[i].length -1]=primero+ultimo;
                } else {
                arrNu[i][arrNu[i].length -1]= 0;
            }
        }

        for (int i = 0; i < arrNu.length; i++) {
            for (int j = 0; j < arrNu[i].length; j++) {
                System.out.print(arrNu[i][j]);
                if (j < arrNu[i].length -1) System.out.print(" ");;
            }
            System.out.println(" "); 
        }
       
    }
}
