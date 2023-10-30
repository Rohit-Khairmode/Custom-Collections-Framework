package Collections.CList;

public class LinkedList<T>{
    private Node<T> head;
    private int size;

    public LinkedList(){
    }
    public LinkedList(T val){
        Node<T> node = new Node<>();
        node.val= val;
        this.head=node;
        size++;
    }
    public int size(){
        return size;
    }
    public void add(T val)
    {
        Node<T> node = new Node<>();
        node.val = val;
        Node<T> temp =this.head;
        if(size == 0)
            this.head=node;
        else {
            while(temp.next != null)
                temp = temp.next;
            temp.next=node;
        }
        size++;
    }
    public void insetAtFirst(T val)
    {
        Node<T> node = new Node<>(val);
        node.next= this.head;
        this.head=node;
        size++;
    }
    public void insetAtLast(T val)
    {
        Node<T> temp=head;
        if(isEmpty())
        {
            insetAtFirst(val);
            return;
        }
        Node<T> node = new Node<>(val);
        while(temp.next != null)
        {
            temp=temp.next;
        }
        temp.next = node;
        size++;
    }
    public void insertAt(int index,T val)
    {
        Node<T> temp = this.head;
        if(index == 0)
        {
            insetAtFirst(val);
            return;
        }
        if(index == this.size)
        {
            insetAtLast(val);
            return;
        }
        Node<T> node = new Node<>(val);
        while (index>1)
        {
            temp=temp.next;
            index--;
        }
        Node<T> next= temp.next;
        temp.next = node;
        node.next= next;
        size++;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public void deleteAt(int index)
    {
        if(index <0 || index > size-1 )
            throw new IndexOutOfBoundsException("Please enter the valid index");
        if(isEmpty())
            return;
        if(index ==0)
        {
           deleteFirst();
           return;
        }
        if(index == size-1)
        {
            deleteLast();
            return ;
        }
        Node<T> temp = this.head;
        while(index>1)
        {
            temp=temp.next;
            index--;
        }
        Node<T> next = temp.next;
        temp.next= next.next;
        size--;
    }
    public void deleteFirst()
    {
        this.head=head.next;
        size--;
    }
    public void deleteLast(){
        Node<T> temp = this.head;
        int i=1;
        if(size == 0)
        {
            this.head = null;
            return;
        }
        while(i<size-1){
            temp = temp.next;
            i++;
        }
        temp.next = null;
        size--;
    }
    public void reverse(){
        if(isEmpty())
            return;
        Node<T>temp = this.head;
        Node<T> pre = null;
        Node<T> next = temp.next;
        while (temp != null)
        {
            temp.next=pre;
            pre= temp;
            temp=next;
            next= next==null?null:next.next;
        }
        this.head=pre;
    }
    public T getMid(){
        Node<T>f =this.head;
        Node<T>s =this.head;
        while (f != null && f.next != null)
        {
            f=f.next.next;
            s=s.next;
        }
        assert s != null;
        return s.val;
    }
    private Node<T> getMidNode(){
        Node<T>f =this.head;
        Node<T>s =this.head;
        while (f != null && f.next != null)
        {
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
    private Node<T> reverseFromMid(Node<T> mid){
        Node<T> midH = mid;
        Node<T> pre =null;
        Node<T> next = mid.next;
        while(midH !=null)
        {
            midH.next = pre;
            pre=midH;
            midH=next;
            next= next==null?null:next.next;
        }
        Node<T> temp=this.head;
        while (temp.next != mid)
        {
            temp = temp.next;
        }
        temp.next=pre;
        return pre;
    }
    public boolean isPalindrome()
    {
        boolean ans = true;
        if(isEmpty())
            return true;
        if(size==1)
            return  true;
        Node<T> mid =getMidNode();
        Node<T> newMidHead =reverseFromMid(mid);
        Node<T> makeNormal=newMidHead;
        Node<T> f=this.head;
        while(f.next != newMidHead && newMidHead != null)
        {
            if (f.val != newMidHead.val) {
                ans = false;
                break;
            }
            newMidHead= newMidHead.next;
            f=f.next;
        }
        assert makeNormal != null;
        reverseFromMid(makeNormal);
        return ans;
    }
    public T get(int index)
    {
        Node<T> temp = head;
        if(index <0 || index > size-1 )
            throw new IndexOutOfBoundsException("Please enter the valid index");
        int i =0;
        while(i<index)
        {
            temp=temp == null ?null:temp.next;
            i++;
        }
        assert temp != null;
        return temp.val;
    }
    private Node getNode(int index)
    {
        Node<T> temp = head;
        if(index <0 || index > size-1 )
            throw new IndexOutOfBoundsException("Please enter the valid index");
        int i =0;
        while(i<index)
        {
            temp=temp == null ?null:temp.next;
            i++;
        }
        assert temp != null;
        return temp;
    }
    public boolean hasCycle() {
        Node<T> fast = head;
        Node<T> slow = head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow =slow.next;
            if(fast == slow)
                return true;
        }
        return false;
    }
    public int lengthOfCycle(){
        Node<T> fast = this.head;
        Node<T> slow = this.head;
        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow= slow.next;
            if(fast == slow)
            {
                int count=0;
                do{
                    slow=slow.next;
                    count++;
                }while (fast == slow);
                return count;
            }
        }
        return 0;
    }
    public T firstNodeInCycle() {
        int length = lengthOfCycle();
        if(length ==0)
            return null;
        Node<T> f= head;
        Node<T> s= head;
        while(length >0)
        {
            s=s.next;
            length--;
        }
        while(f != s)
        {
            f=f.next;
            s=s.next;
        }
        return f.val;
    }
    public void reverseByChunks(int k){
        Node<T> ps=this.head;
        int len = this.size();
        while(len > k)
        {
            Node<T> c = ps == head ?head:ps.next;
            Node<T> p =null;
            Node<T> n = c.next;
            for(int i=0;i<k;i++)
            {
                c.next=p;
                p=c;
                c=n;
                n = n==null?null:n.next;
            }
            if(ps==head)p=head;
            ps.next=c;
            len -= k;
            if(!(len < k))
            {
                while(k>1 && c != null)
                {
                    c=c.next;
                    k--;
                }
                ps=c;
            }
            }
        }

    public void reverseRec(){
        reverseRec(null,head,head.next);
    }
    private void  reverseRec(Node<T> pre,Node<T> first,Node<T> second)
    {
        if(first==null || first.next==null)
        {
            first.next = pre;
            pre=first;
            first = second;
            second=second==null?null:second.next;
            head=pre;
            return;
        }
        first.next = pre;
        pre=first;
        first = second;
        second=second==null?null:second.next;
        reverseRec(pre,first,second);
    }
    @Override
    public String toString(){
        if(isEmpty())
            return "END";
        Node<T> temp = head;
        while (temp != null)
        {
            if(temp.next == null)
                System.out.print(temp.val+" --> END");
            else
                System.out.print(temp.val +" --> ");
            temp = temp.next;
        }
        return "";
    }

    private static class Node<T>{
        private T val;
        private Node<T> next;
        public Node(){
        }
        public Node(T val)
        {
            this.val = val;
        }
    }
}
