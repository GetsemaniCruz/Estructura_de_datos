public class App {
    public static void main(String[] args) throws Exception {
        ArrayQueue<Customer> cola = new ArrayQueue<>();

        cola.offer(new Customer(1, "Ana"));
        cola.offer(new Customer(2, "Luis"));
        cola.offer(new Customer(3, "Maya"));
        cola.offer(new Customer(4, "Diego"));
        cola.offer(new Customer(5, "Sofia"));

        int tamanoAntes = cola.getSize();
        System.out.println("Antes de invertir:");
        cola.print();
   
        cola.reverse();
        int tamanoDespues = cola.getSize();

        System.out.println("Después de invertir:");
        cola.print();
        System.out.println("Elementos antes = " + tamanoAntes);
        System.out.println("Elementos después = " + tamanoDespues);
    }
}
