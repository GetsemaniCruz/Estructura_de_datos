public class App {
    public static void main(String[] args) throws Exception {
        SingleLinkedList listaOriginal = new SingleLinkedList();

        listaOriginal.add(1);
        listaOriginal.add(2);
        listaOriginal.add(3);
        listaOriginal.add(4);
        listaOriginal.add(5);

        System.out.println("Lista original");
        listaOriginal.printList();
        System.out.println("---------------------------------------");

        SingleLinkedList[] resultado = listaOriginal.dividirParImpar();
        SingleLinkedList listaPar = resultado[0];
        SingleLinkedList listaImpar = resultado[1];

        System.out.println("Lista de pares");
        listaPar.printList();
        System.out.println("---------------------------------------");

        System.out.println("Lista de impares");
        listaImpar.printList();

    }
}
