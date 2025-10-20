public class App {
    public static void main(String[] args) throws Exception {

        SingleLinkedList list = new SingleLinkedList();
        
        list.add(5);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(3);
        list.add(9);
        
        System.out.println("-------------------------------");
        list.printList();
        
        list.eliminar();
        
        System.out.println("------------------------------");
        list.printList();
    }
}
    


