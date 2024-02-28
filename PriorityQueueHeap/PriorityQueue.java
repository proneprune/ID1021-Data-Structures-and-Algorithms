import java.util.Arrays;
import java.util.Random;

public class PriorityQueue{
    //priority queue med O(1) remove
    Node head;
    Node runner;

    private class Node{
        Integer item;
        Node next;

        private Node(Integer item, Node list){
            this.item = item;
            this.next = list;
        }
    }

    public PriorityQueue(){
        head = null;
        runner = null;
    }

    public void addSlow(Integer item){//O(n)
        Node cur = head;
        Node prev = null;
        if (head == null){
            Node node = new Node(item, null);
            head = node;
            //System.out.println(head.item);
            return;
        }
        if (head.next == null){
            if (item < head.item){
                Node temp = head;
                Node node = new Node(item, temp);
                head = node;
                //System.out.println(head.item);
                return;
            }
            else{
                Node node = new Node(item, null);
                head.next = node;
                //System.out.println(node.item);
                return;
            }
        }

        while (item >= cur.item && cur.next != null){
            //System.out.println("bla "+ cur.item);
            prev = cur;
            cur = cur.next;
            //System.out.println("arg " + cur.item);
        }

        if(cur.next == null && item > cur.item){
            Node node = new Node(item, null);
            cur.next = node;
            return;
        }
        if(cur.next == null && item < cur.item){
            Node node = new Node(item, cur);
            prev.next = node;
            return;
        }

        //System.out.println("tjo, prev: " + prev.item + "cur " + cur.item);
        Node node = new Node(item, cur);
        prev.next = node;
        return;
    }

    public Integer removeFast(){//O(1)
        if (head == null){
            System.out.println("empty");
        }
        
        Integer ret = head.item;
        head = head.next;
        return ret;
    }

    public void addFast(Integer item){//O(1)
        if (head == null){
            Node node = new Node(item, null);
            head = node;
            return;
        }
        if (head.next == null){
            Node node = new Node(item, head);
            head = node;
            return;
        }
        Node node = new Node(item, head);
        head = node;
        return;
    }
    
    public Integer removeSlow(){//O(n)
        Node prv = null;
        Node cur = head;
        Node test = head;
        Integer min;

        if (head == null){
            System.out.println("fak off empty");
            return null;
        }
        min = head.item;

        if (head.next == null){
            Integer rtn = head.item;
            head = null;
            return rtn;
        }

        while (test.next != null){
            test = test.next;
            if (test.item < min){
                min = test.item;
            }
        }
        if (cur.item == min){
            head = cur.next;
            if(cur.next == null){
                head = null;
            }
            return min;
        }

        while (cur.item != min ){
            prv = cur;
            cur = cur.next;
        }
        prv.next = cur.next;

        return min;
    }

    public Integer[] value(){
        //return head.item;
        Node node = new Node(null,null);
        node = head;
        Integer[] list = new Integer[6];
        int i = 0;
        if (head == null){
            System.out.println("empty");
            return null;
        }
        while (node.next != null){
            list[i] = node.item;
            i++;
            node = node.next;
        }
        list[i] = node.item;
        return list;
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        PriorityQueue queue2 = new PriorityQueue();
        Random rand = new Random();

        int n = 100;
        int[] sizes = new int[]{100, 200, 400, 800, 1600};

        for (int k : sizes){
            double t0 = System.nanoTime();
            for (int i = 0; i < k; i++)
                queue.addFast(rand.nextInt(10000));

            for (int i = 0; i<k; i++){

                queue.removeSlow();
            }
            double t1 = System.nanoTime();

            System.out.println(" time for " + k + " fastadd slowremove operations " + (t1-t0)/1000 + " us");
        }

        for (int k : sizes){
            double t0 = System.nanoTime();
            for (int i = 0; i < k; i++)
                queue2.addSlow(i);
            PriorityQueue queue3 = new PriorityQueue();
            
            for (int i = 0; i<k; i++){
                //System.out.println("test");
                queue2.removeFast();
            }
            double t1 = System.nanoTime();

            System.out.println(" time for " + k + " slowadd fastremove operations " + (t1-t0)/1000 + " us");
        }
        
        




        /*
        queue.addSlow(2);
        queue.addSlow(5);
        queue.addSlow(11);
        queue.addSlow(21);
        queue.addSlow(10);
        queue.addSlow(20);

        System.out.println(queue.removeFast());
        System.out.println(queue.removeFast());
        System.out.println(queue.removeFast());

        
        queue.removeSlow();
        queue.addFast(10);
        //System.out.println(queue.removeSlow());
        queue.addFast(2);
        queue.addFast(1);
        queue.addFast(16);
        queue.addFast(6);
        queue.addFast(7);
        System.out.println(queue.removeSlow());
        System.out.println(queue.removeSlow());
        System.out.println(queue.removeSlow());
        System.out.println(queue.removeSlow());
        System.out.println(queue.removeSlow());
        System.out.println(queue.removeSlow());
        

        
        
        queue.addSlow(10);
        queue.addSlow(4);
        queue.addSlow(6);
        queue.addSlow(15);
        queue.addSlow(1);
        queue.addSlow(2);
        queue.addSlow(20);

        System.out.println(Arrays.toString(queue.value()));
        */
        
        
    }
}