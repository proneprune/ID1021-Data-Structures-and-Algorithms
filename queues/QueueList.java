import java.util.Arrays;

public class QueueList {
    Node head;
    Node last;

    private class Node {
        Integer item;
        Node next;


        private Node(Integer item, Node list) {

            this.item = item;
            this.next = list;
        }
    }



    public QueueList() {
        head = null;
        last = null;
    }

    public void add(Integer item) {
        Node node = new Node(item, null);
        if (head == null){
            head = node;
            last = head;
            return;
        }
        else
            //while(last.next != null){
              //  last = last.next;
            //}
            last.next = node;
            last = node;

    }

    public Integer remove() {
        if (head == null)
            throw new IllegalArgumentException("queue is empty");
        Integer node;
        node = head.item;
        head = head.next;
        return node;
    }

    
    public Integer[] value(){
        //return head.item;
        Node node = new Node(null,null);
        node = head;
        Integer[] list = new Integer[3];
        int i = 0;
        while (node.next != null){
            list[i] = node.item;
            i++;
            node = node.next;
        }
        list[i] = node.item;
        return list;
    }

    public static void main(String[] args) {
        QueueList queue = new QueueList();
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println(Arrays.toString(queue.value()));
        System.out.println();
        System.out.println(queue.remove());

        System.out.println();
        System.out.println(Arrays.toString(queue.value()));
        System.out.println();
        queue.remove();
        System.out.println(Arrays.toString(queue.value()));
        queue.remove();

    }
}