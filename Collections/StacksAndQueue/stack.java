package Collections.StacksAndQueue;

public class stack<T> {
    private Object[] arr;
    private int size=0;

    public stack(){
        this.arr = new Object[10];
    }

    public void push(T val)
    {
        if(this.isFull())
        {
            resize();
        }
        arr[size++]=val;
    }
    public T pop(){
        T val = (T) arr[size-1];
        size--;
        return val;
    }
    public T peek(){
        return  (T)arr[size-1];
    }
    public int search(Object o)
    {
        for(int i=0; i< arr.length; i++)
        {
            if(o.equals(arr[i]))return i;
        }
        return -1;
    }
    private void resize(){
        Object[] temp = new Object[2 * arr.length];
        for(int i=0;i< arr.length;i++)
        {
            temp[i]=arr[i];
        }
        this.arr=temp;
    }
    private boolean isFull(){
        return size == arr.length;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public String toString(){
        for(int i=0;i< size;i++)
        {
            if(i == size-1){
                System.out.print(arr[i]+" -> " +"TOP");
                continue;
            }
            System.out.print(arr[i] + " -> ");
        }
        return "";
    }
}
