public class App {
    public static void main(String[] args) throws Exception {
        SingleLinkedList lista=new SingleLinkedList();

        lista.printList();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);

        System.out.println("--------------------------");
        lista.printList();
        lista.remove(3);
        System.out.println("---------------------------");
        lista.printList();
        System.out.println("---------------------------");
        int valor = 2;
        int veces = lista.contador(valor); 

        System.out.println("El valor a buscar es: "+valor);
        System.out.println("Se repite "+veces);



    }
}
