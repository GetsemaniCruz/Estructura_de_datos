public class App {
    public static void main(String[] args) throws Exception {
        String palabra = "hola";
        System.out.println("La palabra es ");
        invertir(palabra,palabra.length()-1);
    }

    public static void invertir(String palabra,int letras){
        if(letras<0){
            return;
        }
        //charAt funciona como un indice 
        System.out.println(palabra.charAt(letras));
        invertir(palabra, letras-1);
    }
}
