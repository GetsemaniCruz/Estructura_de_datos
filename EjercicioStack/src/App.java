public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Palabras");

        String frase1 = "Anita lava la tina";
        boolean esP1 = ArrayStack.isPalindrome(frase1);
        System.out.println("\n" + frase1 +" -> "+ esP1);

        String frase2 = "Hola";
        boolean esP2 = ArrayStack.isPalindrome(frase2);
        System.out.println("\n" + frase2 +" -> "+ esP2);

    }
}
