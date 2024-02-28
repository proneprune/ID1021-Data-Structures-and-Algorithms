import java.util.Arrays;

public class Queue {
    Node head;
    Node last;

    private class Node {
        BinaryTree.Node item;
        Node next;


        private Node(BinaryTree.Node item, Node list) {

            this.item = item;
            this.next = list;
        }
    }



    public Queue() {
        head = null;
        last = null;
    }

    public void add(BinaryTree.Node item) {
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

    public BinaryTree.Node remove() {
        if (head == null)
            throw new IllegalArgumentException("queue is empty");
        BinaryTree.Node node;
        node = head.item;
        head = head.next;
        return node;
    }

    
    public Integer[] value(){
        //return head.item;
        if(head == null)
            return null;
        Node node = new Node(null,null);
        node = head;
        Integer[] list = new Integer[15];
        int i = 0;
        while (node.next != null){
            list[i] = node.item.value;
            i++;
            node = node.next;
        }
        list[i] = node.item.value;

        return list;
    }


    public static void main(String[] args) {
        Queue queue = new Queue();
        BinaryTree tree = new BinaryTree();
        tree.add(1, 3);

        queue.add(tree.root);
        //queue.add(6);
        //queue.add(7);
        System.out.println(Arrays.toString(queue.value()));
        System.out.println();
        System.out.println(queue.remove().value);

        System.out.println();
        System.out.println(Arrays.toString(queue.value()));
        System.out.println();
        queue.remove();
        System.out.println(Arrays.toString(queue.value()));
        queue.remove();

    }
}