public class SingleLinkedList {
    
    Node head; 

    public void eliminar() {

        if (head==null){
            return;
        }
        Node current=head;
        while (current!=null) {
            
            Node buscador=current;
            while (buscador.next!=null) {
                if (buscador.next.data==current.data){
                    buscador.next=buscador.next.next;
                } else{
                    buscador=buscador.next;
                }
            }
            current=current.next;
        }
    }

    public void add(int data) {
        Node newNode = new Node(data);
        if (head==null) {
            head=newNode;
            return;
        }
        Node temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next=newNode;
    }

    public void printList(){
        Node current=head;
        while (current!=null) {
            System.out.println(current.data);
            current=current.next;
        }
        System.out.println("null");
    }
}


