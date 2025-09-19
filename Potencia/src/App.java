public class App {
    public static void main(String[] args) throws Exception {
        int base=2;
        int exponente=5;
        int resultado = potencia(base,exponente);
        System.out.println("la potencia de 2 a la 5 es "+resultado);

    }
    public static int potencia(int a,int b){
        if (b==0){
            return 1;
        }
    return a* potencia(a,b-1);
    }

}
