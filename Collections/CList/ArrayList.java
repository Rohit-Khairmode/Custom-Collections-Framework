package Collections.CList;

public class ArrayList<T extends Object> {
    private Object[] data;
    private static int DEFAULT_SIZE =10;
    private int size=0;

    ArrayList(){
        data = new Object[DEFAULT_SIZE];
    }

    public void add(T num)
    {
        if(isFull())
            resize();
        data[size]=num;
        size++;
    }
    public int size(){
        return size;
    }
    public void insertAt(int index , T num)
    {
        if(size==0)
            throw new RuntimeException("Please first insert a element");
        if(index >= size || index <0)
        {
            throw new IndexOutOfBoundsException("Please insert a valid position");
        }
        size++;
        if(isFull())
            resize();
        for(int j=size;j>index;j--)
        {
            data[j]=data[j-1];
        }
        data[index]=num;
    }
    public T deleteAt(int index)
    {
        if(index > size-1 || index <0)
        {
            throw new IndexOutOfBoundsException("Please insert a valid position");
        }
        if(size==0)
            throw new RuntimeException("Please first enter element");
        for(int j=index;j<size;j++)
        {
            data[j]=data[j+1];
        }
       T temp =(T)data[size];
        data[size]=null;
        size--;
        return temp;
    }
    public boolean contains(Integer num)
    {
        for(int i=0;i< data.length;i++)
            if(num.equals(data[i]))return true;

        return false;
    }
    public boolean contains(Float num)
    {
        for(int i=0;i<=size;i++)
            if(num.equals(data[i]))return true;

        return false;
    }
    public boolean contains(Double num)
    {
        for(int i=0;i<=size;i++)
            if(num.equals(data[i]))return true;

        return false;
    }
    public boolean contains(Long num)
    {
        for(int i=0;i<=size;i++)
            if(num.equals(data[i]))return true;

        return false;
    }
    public boolean contains(String num)
    {
        for(int i=0;i< data.length;i++)
            if(num.equals(data[i]))return true;

        return false;
    }
    public int indexOf(Integer num)
    {
        for(int i=0;i< data.length;i++)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public int indexOf(Float num)
    {
        for(int i=0;i< data.length;i++)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public int indexOf(Double num)
    {
        for(int i=0;i< data.length;i++)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public int indexOf(Long num)
    {
        for(int i=0;i< data.length;i++)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public int indexOf(String num)
    {
        for(int i=0;i< data.length;i++)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public int lastIndexOf(Integer num)
    {
        for(int i=size;i>=0;i--)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public int lastIndexOf(Float num)
    {
        for(int i=size;i>=0;i--)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public int lastIndexOf(Double num)
    {
        for(int i=size;i>=0;i--)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public int lastIndexOf(Long num)
    {
        for(int i=size;i>=0;i--)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public int lastIndexOf(String num)
    {
        for(int i=size;i>=0;i--)
            if(num.equals(data[i]))return i;
        return -1;
    }
    public void reverse()
    {
        int s=0;
        int e=this.size-1;
        while(s<e)
        {
            swap(s,e,this.data);
            s++;
            e--;
        }
    }
    private void swap(int s,int e,Object[] data){
        Object temp = data[s];
        data[s]=data[e];
        data[e]=temp;
    }
    @Override
    public String toString(){
        if(size == 0)
            return "[]";
        String s = "[";
        for(int i=0;i< data.length;i++)
        {
            if(data[i]==null)
                break;
            s +=data[i] +", ";
        }
        s=s.substring(0,s.length()-2);
        s+="]";
        return s;
    }
    private void resize(){
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
    private boolean isFull(){return size == data.length-1;};

}
