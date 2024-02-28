public class DoubleLinkedList {
    Cell first;

    private class Cell {
        int head;
        Cell tail;
        Cell previous;
        Cell(int val, Cell tl, Cell t2) {
            head = val;
            tail = tl;
            previous = t2;
        }
    }
    public void value(){
        Cell nxt = first;
        if( first == null){
            System.out.println("empty");
            return;
        }
        if(nxt.tail == null){
            System.out.println(nxt.head);
            return;
        }
        while(nxt.tail != null){
            System.out.println(nxt.head);
            nxt = nxt.tail;
        }
        System.out.println(nxt.head);
    }

    public void add(int item){
        Cell cell = new Cell(item, first, null);
        first = cell;
    }

    public int length(){
        Cell nxt = first;
        int len = 0;
        if (first == null){
            return 0;
        }
        if(first.tail == null){
            return 1;
        }
        while(nxt.tail != null){
            len += 1;
            nxt = nxt.tail;
        }
        len +=1;
        return len;
    }

    public boolean find(int item){
        Cell nxt = first;
        if(first == null){
            return false;
        }
        while(nxt.tail != null){
            if( nxt.head == item){
                return true;
            }
            else{
                nxt = nxt.tail;
            }
        }
        if(nxt.tail == null && nxt.head == item){
            return true;
        }
        if(nxt.tail == null && nxt.head != item){
            return false;
        }
        return false;
    }

    
    public void remove(int item){
        Cell nxt = first;
        Cell prv = null;
        if(nxt.head == item){
            first = first.tail;
            return;
        }
        while(nxt.head != item){
            if(nxt.tail == null){
                return;
            }
            prv = nxt;
            nxt = nxt.tail;
        }
        nxt.tail.previous = prv;
        prv.tail = nxt.tail;
        
    }

    public void unlink(Cell cell){
        
            
    }

    public static void main(String[] args) {
    DoubleLinkedList list = new DoubleLinkedList();



    }
}
