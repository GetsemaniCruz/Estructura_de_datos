public class App {
    public static void main(String[] args) throws Exception {
        DoubleLinkedList list = new DoubleLinkedList();
        list.printFordward();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.printFordward();

        System.out.println("------------Imprimir backward------------- ");
        list.printBackward();
        System.out.println("-----------Probar eliminaciones---------------");
        list.remove(1);
        list.printFordward();
        System.out.println("--------------------------");
        list.remove(4);
        list.printFordward();
        System.out.println("--------------------------");
        list.remove(7);
        list.printFordward();
    
    }
}
