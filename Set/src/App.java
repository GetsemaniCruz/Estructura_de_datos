import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        Set<String> set = new TreeSet<>();
                            //LinkedHashSet 
                            //HashSet es rapido pero no mantiene el orden
        set.add("Azul");
        set.add("Verde");
        set.add("Rojo");
        set.add("Amarillo");
        set.add("Rojo");//se omitio por duplicidad

        System.out.println(set);//impresion

        boolean existRed = set.contains("Rojo"); //existe por objeto
        System.out.println("¿Existe el color rojo? " + existRed);

        set.remove("Verde");//elimina el elemento
        int tam = set.size();//obtiene el tamaño

        for (String data : set) {//recorrido estandar
            System.out.println("Dato: " + data);
        }
        System.out.println("Tamaño actual: " + tam);
    }
}
