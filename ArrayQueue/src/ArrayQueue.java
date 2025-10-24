public class ArrayQueue<T> implements IQueue {

    private Object[] data;
    private int rear;//indice de inserccion
    private int front;//indica el elemento al frente de la queue
    private int size;//numero de elementos de la queue
    private static final int INITIAL_CAPACITY=10;//constante para el tamaño inicial del array 

    public ArrayQueue(){
        this.data = new Object[INITIAL_CAPACITY];
        this.rear=0;
        this.front=0;
        this.size=0;
    }

    @Override
    public void offer(Object element) {
        //verificar la capacidad del array()
        expandCapacity();
        data[rear]= element;//pone el elemento en el indice asignado (rear)
        rear= (rear+1) % data.length; //recalcula rear pero evita que se desborde
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object poll() {
        if(isEmpty()){
            System.out.println("La Queue esta vacia");
            return null;
        }
        T result= (T) data[front];//juanito
        data[front]=null;//lo sacamos
        front=(front+1) % data.length;
        size--;
        return null;
    }

    @Override
    public Object peek() {
        if(isEmpty()){
            System.out.println("La queue esta vacia");
            return null;
        }
        return data[front];
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    private void expandCapacity(){
        Object[] newArr= new Object[data.length*2];//creacion de nuevo arreglo
        for (int i = 0; i < size; i++) {
            newArr[i] = data [(front+i) % data.length];//vaciado de la info comenzando desde front
        }
        //reiniciamos los valores del arreglo para poder seguirlo usando
        front=0;//pone al frente la primera posicion
        data= newArr;//asigna el nuevo arreglo al atributo data
        rear= size;//indice de la siguiente insercion
    }

    @Override
    public void print() {
        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[(front+i) % data.length]);
            if(i < size-1) sb.append("->");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public int getSize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }
}
