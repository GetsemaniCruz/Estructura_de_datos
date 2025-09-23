import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> materias=new ArrayList<>();
        materias.add("Matemáticas");
        materias.add("Física");
        materias.add("Química");
        materias.add("Historia");
        materias.add("Programación");
        //Recorrer
        for(String materia : materias){
            System.out.println(materia);
        }

        String materiaBuscada = "Programación";
        System.out.println("Búsqueda: "+materiaBuscada);
        
        if (materias.contains(materiaBuscada)) {
            System.out.println("Materia encontrada");
        } else {
            System.out.println("Materia no encontrada");
        }
    }
}
