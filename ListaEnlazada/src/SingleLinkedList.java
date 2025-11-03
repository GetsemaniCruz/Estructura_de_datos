public class SingleLinkedList {

    Node head;

    public void add(int data){
        Node newNode = new Node(data);    
        if(head==null){
            head=newNode;
            return;
        }
        Node current=head;
        while (current.next != null) {
            current=current.next;
        }
        current.next=newNode;
    }

    public boolean contains(int data){
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
        if(head==null){
            return;
        }
        if(head.data==data){
            head=head.next;
            return;
        }
        Node current=head;
        while (current.next!=null && current.next.data!=data) {
            current=current.next;
        }

        current.next=current.next.next;
    }

    public void printList(){
        Node current=head;
        while (current!=null) {
            System.out.println(current.data);
            current=current.next;
        }
        System.out.println("null");
    }
 
    public int contador(int data) {
        int i=0;
        Node current=head; 
        while (current != null) {
            if (current.data == data) {
                i++;
            }
            current = current.next;
        }
        return i;
    }

    public SingleLinkedList[] dividirParImpar() {
        
        SingleLinkedList listaPar = new SingleLinkedList();
        SingleLinkedList listaImpar = new SingleLinkedList();

        Node ultimoPar=null;
        Node ultimoImpar=null;

        Node actual=this.head;
        this.head=null;

        while (actual != null) {
            Node siguiente=actual.next;
            actual.next=null;

            if (actual.data % 2== 0) {
                if (listaPar.head ==null) {
                    listaPar.head=actual;
                } else {
                    ultimoPar.next=actual;
                }
                ultimoPar=actual;
            } 
            else {
                if (listaImpar.head == null) {
                    listaImpar.head=actual;
                } else {
                    ultimoImpar.next=actual;
                }
                ultimoImpar=actual;
            }

            actual =siguiente;
        }

        return new SingleLinkedList[]{listaPar,listaImpar};
    }


}
