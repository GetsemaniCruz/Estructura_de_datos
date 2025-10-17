public class DoubleLinkedList {

    Node head;
    Node tail;

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
        Node current=head;
        while (current!=null && current.data!=data) {//recorrer hasta encontrar el valor
            //estandar del recorrido && pregunta si es el valor que se busca
            current=current.next;
        }
        if (current==null) {
            return;
        }
        if (current==head) {
            head=head.next;
            if (head!=null) {
                head.prev =null; 
            } else {
                tail=null;
            }
            return;
        }
        if (current.next==null) { 
            tail=current.prev;
            if (tail!=null) {
                tail.next=null;
            }
            current.prev=null;
            return; 
        }
        current.prev.next=current.next;
        current.next.prev=current.prev;
        current.next=null;
        current.prev=null;
        return;
        
    }

}