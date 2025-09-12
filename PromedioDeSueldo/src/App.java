import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Worker> workers = new ArrayList<>();

        workers.add(new Worker(1, "Adrian", 1000.1));
        workers.add(new Worker(2, "Susana", 900.1));
        workers.add(new Worker(3, "Marco", 196.1));
        workers.add(new Worker(4, "Laura", 208.1));
        workers.add(new Worker(5, "Karla", 800.1));
        workers.add(new Worker(6, "Daniel", 100.1));

        for (Worker empleado : workers) {
            System.out.println(empleado);
        }

        double suma = 0;
        for (Worker empleado : workers) {
            suma = suma + empleado.sueldo;
        }
        double promedio = suma / 6;
        System.out.println("Promedio de sueldos: " + promedio);

        workers.removeIf(empleado -> empleado.sueldo < 1000);
        for (Worker empleado : workers) {
            System.out.println(empleado);
        }

    }
}
