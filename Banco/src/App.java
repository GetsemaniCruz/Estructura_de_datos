import java.util.ArrayDeque;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Queue<Cliente> queue = new ArrayDeque<>();
        Cliente c1=new Cliente(1,"Juanito");
        c1.addDocument("Doc 1 de Juanito");
        c1.addDocument("Doc 2 de Juanito");


        Cliente c2=new Cliente(2,"Marcos");
        c2.addDocument("Doc 1 de Marcos");
        c2.addDocument("Doc 2 de Marcos");

        Cliente c3=new Cliente(3,"Juanita");
        c3.addDocument("Doc 1 de Juanita");
        c3.addDocument("Doc 2 de Juanita");

        queue.offer(c1);
        queue.offer(c2);
        queue.offer(c3);

        Cliente clienteAtendido = queue.poll();
        System.out.println("Cliente en atencion: " + clienteAtendido.name);
        clienteAtendido.attend(); 
        System.out.println("Fila: "+ queue); 
        System.out.println("Siguiente: "+ queue.peek().name);

    }
}
