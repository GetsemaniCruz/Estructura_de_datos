public class SingleLinkedList {

    Node head;

    public void add(int data){
        Node newNode = new Node(data);//creacion del nuevo nodo    
        if(head==null){//verificacion de la lista vacia
            head=newNode;
            return;
        }
        Node current=head;
        while (current.next != null) {//recorrido de los nodos hasta encontrar el ultimo item
            current=current.next;
        }
        current.next=newNode;//inserta nuevo nodo al final de la lista
    }

    public boolean contains(int data){
        /*if(head==null){
            System.out.println("la lista esta vacia");
            return false;
        }*/
        Node current=head;
        while (current!=null) {
            if (current.data==data) {
                return true;
            }
            current=current.next;
        }
        return false;
    }

    public void remove(int data){
        if(head==null){//pregunta si la lista esta vacia
            return;
        }
        if(head.data==data){//valida que el dato este en head
            head=head.next;//elimina el primer nodo
            return;
        }
        Node current=head;
        while (current.next!=null && current.next.data!=data) {//recorrer hasta encontrar el valor
            //estandar del recorrido && pregunta si es el valor que se busca
            current=current.next;
        }

        current.next=current.next.next;//asignamos el nodo siguiente al siguiente
    }

    public void printList(){
        Node current=head;
        while (current!=null) {
            System.out.println(current.data);
            current=current.next;
        }
        System.out.println("null");
    }

    
    public int contador() { 
        int i=0;
        Node current=head;

        while (current!=null) {
            i++; 
            current=current.next;
        }
        return i;
    }


}
