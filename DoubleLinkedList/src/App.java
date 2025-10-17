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
        list.printFordward();

        System.out.println("------------Imprimir backward------------- ");
        list.printBackward();
        System.out.println("--------------------------");
        list.printFordward();
        list.remove(3);
    }
}
