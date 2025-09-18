public class App {
    public static void main(String[] args) throws Exception {
        int n=0;
        while(n<=5){
            System.out.println(fibonacci(n));
            n++;
        }
    }

    public static int fibonacci(int n){
        if(n<=1) return n;
        return fibonacci(n-1)+fibonacci(n-2);
    }
}
