import java.util.Random;

class LinkedList {
    Cell first;

    private class Cell {
        int head;
        Cell tail;
        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }

    public void add(int item){
        Cell cell = new Cell(item, first);
        first = cell;
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
        prv.tail = nxt.tail;

        
    }


    public void append(LinkedList b) {
        Cell nxt = this.first;
        while (nxt.tail != null) {
        nxt = nxt.tail;
        }
        nxt.tail = b.first;
        }


    public void Linkedlist(int n) {
            Cell last = null;
            for (int i = 0; i < n; i++) {
            last = new Cell(i, last);
            }
            first = last;
            }

    public void push(int item){
        Cell nxt = first;
        Cell pushed = new Cell(item, null);

        if(nxt == null){
            first = pushed;
            return;
        }
        while(nxt.tail != null){
            nxt = nxt.tail;
        }
        nxt.tail = pushed;

    }

    public int pop(){
        Cell prv = null;
        Cell nxt = first;

        if(nxt == null){
            throw new IllegalArgumentException("stack is empty");
        }

        if(nxt.tail == null){
            first = null;
            return nxt.head;
        }

        while(nxt.tail != null){
            prv = nxt;
            nxt = nxt.tail;
        }
        prv.tail = null;
        return nxt.head;
    }

    public static void main(String[] args) {
     /*    int tries = 100;
        int loop = 100;
        Random rnd = new Random();

        System.out.printf("# Appending two linkedlists of n length and 500 elements\n");
		System.out.printf("#%7s%8s%8s\n", "n", "timeL", "timeA");

        for(int n = 100; n <= 2000; n += 100){

            System.out.printf("%8d", n);

            double minL = Double.POSITIVE_INFINITY;
			for(int i = 0; i < tries; i++){
				double start = System.nanoTime();

                for(int j = 0; j < loop; j++){
                LinkedList listB = new LinkedList();
                listB.Linkedlist(100);
                LinkedList listA = new LinkedList();
                listA.Linkedlist(n);

                listA.append(listB);
                }
				double t = System.nanoTime() - start;
                
				if (t < minL)
					minL = t;
			}
			System.out.printf("%8.0f", minL/(loop));


            double minA = Double.POSITIVE_INFINITY;
			for(int i = 0; i < tries; i++){
				double start = System.nanoTime();

                for(int j = 0; j < loop; j++){

                LinkedList listB = new LinkedList();
                listB.Linkedlist(100);
                LinkedList listA = new LinkedList();
                listA.Linkedlist(n);

                listB.append(listA);
                
                //int[] arrA = new int[100];
                //for(int k = 0; k < 100; k++){
                    //arrA[k] = rnd.nextInt(n*10);
                    //}
                //int[] arrB = new int[n];
                    //for(int k = 0; k < arrB.length; k++){
                    //arrB[k] = rnd.nextInt(n*10);
                //}
                //int[] arrC = new int[n+100];
                //for(int k = 0; k < 100; k++){
                    //arrC[k] = arrA[k];
                //}
                //for(int k = 100; k < arrC.length; k++){
                  //  arrC[k] = arrB[k-100];

                //}
                
                
                }


				double t = System.nanoTime() - start;
				if (t < minA)
					minA = t;
			}
			System.out.printf("%8.0f\n", minA/(loop));


        }*/
        LinkedList list = new LinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        int a = list.pop();
        list.value();
        System.out.println();
        System.out.println(a);
    }
}