import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        
        Map<Integer, String> map = new TreeMap<>();
        map.put(1,"Mouse");
        map.put(2,"Teclado");
        map.put(3,"Monitor");
        map.put(1, "Mouse Gamer");

        System.out.println(map);

        String data= map.get(1);
        System.out.println(data);
        boolean exist = map.containsValue("teclado");
        System.out.println("Hay un teclado? " + exist);
        map.remove(1);//eliminar por key

        for (Map.Entry<Integer, String> row : map.entrySet()) {
            System.out.println("La key es: " + row.getKey() + " su value es: " + row.getValue());
        }
        boolean existKey = map.containsKey(1);//verificar si existe por key
        System.out.println(existKey);
    }
}
