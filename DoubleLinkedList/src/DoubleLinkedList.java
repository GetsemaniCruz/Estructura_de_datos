public class DoubleLinkedList {

    Node head;

    public void add(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node current=head;
        while (current.next!=null) {//pregunta si tiene referencia
            current=current.next;
        }
        current.next=newNode;
        newNode.prev=current;
    }

    public void printFordward(){
        Node current=head;
        while (current!=null) {//pregunta si tiene referencia
            System.out.println(current.data);
            current=current.next;
        }
        System.out.println(current);
    }

    public void printBackward(){
        Node current=head;
        while (current.next!=null) {//pregunta si tiene referencia
            current=current.next;
        }
        while (current!=null) {//pregunta si tiene referencia
            System.out.println(current.data);
            current=current.prev;
        }
        System.out.println(current);
    }

    public void remove(int data){
        if(head==null){//pregunta si la lista esta vacia
            return;
        }
        if(head.data==data){//valida que el dato este en head
            head=head.next;//elimina el primer nodo
            return;
        }else{
            System.out.println("valor no encontrado");
        }
        Node current=head;
        while (current.next!=null && current.next.data!=data) {//recorrer hasta encontrar el valor
            //estandar del recorrido && pregunta si es el valor que se busca
            current=current.next;
        }

        current.next=current.next.next;//asignamos el nodo siguiente al siguiente
    }


}
