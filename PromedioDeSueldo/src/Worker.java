public class Worker {
    int id;
    String nombre;
    double sueldo;

    public Worker(int id, String nombre, double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }


    @Override
    public String toString() {
        return id + ", " + nombre + ", " + sueldo;
    }

}
