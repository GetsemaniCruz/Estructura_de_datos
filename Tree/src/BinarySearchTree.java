public class BinarySearchTree {

    Node root;//raiz de nuestro arbol

    public void insert (int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive (Node current, int value){
        //caso base, cuando current sea null, en este punto vamos a crear el nodo
        if(current == null){
            return new Node(value);
        }
        //si el valor a insertar es menor al valor de current
        //entonces vamos a crear el nodo de lado izquierdo
        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
            //si el valor a insertar es mayor al valor de current
            //entonces vamos a crear el nodo de lado derecho
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        }
        //en caso de ser iguales no se hace nada
        return current;
        
    }

    public void printOrder(){
        System.out.println("Print in order:");
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node current){
        if(current != null){
            //recorrido izquierdo
            printInOrderRecursive(current.left);
            System.out.println(current.value + "");
            printInOrderRecursive(current.right);
        }
    }
    
}
