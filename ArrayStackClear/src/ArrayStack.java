public class ArrayStack<T> implements IStack<T>{

    private Object[] data;
    private int top;

    //constructor 1
    public ArrayStack(){
        this(10);//invoca al constructor 2
    }

    //constructor 2
    public ArrayStack(int initialCapacity){
        this.data = new Object[initialCapacity];
        this.top=0;
    }

    @Override
    public void push(T element) {
        //nos vamos a aseguarar que aun tenga espacio en la memoria
        data[top++]= (T)element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if(isEmpty()){
            System.out.println("la pila esta vacia");
            return null;
        }
        T value=(T) data[--top];
        data[top]=null;
        return value;
    }

    @Override
    public T peek() {
       if(isEmpty()){
            System.out.println("la pila esta vacia");
            return null;
        }
        return (T) data[top];
        //return (T) data[top - 1];
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.top; i++) {
            data[i] = null;
        }
        this.top = 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top-1; i >=0; i--) {
            sb.append(data[i]);
            if(i !=0){
                sb.append("->");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

}
