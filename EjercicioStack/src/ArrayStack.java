public class ArrayStack<T> implements IStack<T>{

    private Object[] data;
    private int top;

    public ArrayStack(){
        this(10);
    }

    public ArrayStack(int initialCapacity){
        this.data = new Object[initialCapacity];
        this.top=0;
    }

    @Override
    public void push(T element) {
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

    }

    @Override
    public void clear() {
        for (int i = 0; i < this.top; i++) {
            data[i]=null;
        }
        this.top=0;
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

    public static boolean isPalindrome(String texto) {
        StringBuilder bldr = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char letra=texto.charAt(i);
            if (Character.isLetterOrDigit(letra)) {
                bldr.append(Character.toLowerCase(letra));
            }
        }
        String limpio = bldr.toString();

        if (limpio.isEmpty()) {
            return true;
        }

        ArrayStack<Character> pila = new ArrayStack<>(limpio.length());
        for (int i = 0; i < limpio.length(); i++) {
            pila.push(limpio.charAt(i));
        }

        for (int i = 0; i < limpio.length(); i++) {
            char original=limpio.charAt(i);
            char sacado=pila.pop();

            if (original !=sacado) {
                return false;
            }
        }

        return true;
    }

}
