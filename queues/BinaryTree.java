import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class BinaryTree implements Iterable<Integer>{
    
    public class Node{
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }


        private void add(Integer key, Integer value){
            if (this.key == key){
                this.value = value;
                return;
            }
            if (this.key > key)
                if (this.left != null)
                    this.left.add(key, value);
                else
                    this.left = new Node(key, value);
            else
                if(this.right != null)
                    this.right.add(key, value);
                else
                    this.right = new Node(key, value);
        }


        public void print(){
            if (left != null)
                left.print();
            System.out.println(" key:" + key + "\tvalue: " + value);
            if (right != null)
                right.print();
        }
    }

        Node root;

        public BinaryTree() {
            root = null;
        }

        public void add(Integer key, Integer value){
            if (root == null)
            root = new Node(key, value);
            else
            root.add(key, value);
        }


        public Integer lookup(Integer key){
            Node cur = this.root;
            while (cur != null){
                if (cur.key == key)
                    return cur.value;
                if (cur.key < key)
                    cur = cur.right;
                else
                    cur = cur.left;
            }
            return null;
        }

        public void Saturate(Integer k, Integer n){
            int insert = (n + k)/2;
            if(insert == k || insert == n)
                return;
            add(insert, insert);
            Saturate(k, insert);
            Saturate(insert, n);
        }



        public Iterator<Integer> iterator(){
            return new TreeIterator();
        }

        public class TreeIterator implements Iterator<Integer>{
            private Node next;
            Queue queue = new Queue();
            BinaryTree.Node temp = root;
            

            public TreeIterator(){
                //partialorder
                queue.add(root);
            }

            /*void partialInOrder(BinaryTree.Node node){
                while(node!=null){
                    queue.add(node);
                    node=node.left;
                }
            }*/

            @Override
            public boolean hasNext(){
                if(queue.head == null){
                    return false;
                }
                else
                return true;
            }

            @Override
            public Integer next(){
                
                temp = queue.remove();
                //System.out.println(Arrays.toString(queue.value()));
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
                //System.out.println(Arrays.toString(queue.value()));

                    return temp.value;
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException("no remove method");
            }

        
        }


        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();

            //tree.Saturate(0, 100);
            //tree.root.print();

        /*int tries = 100;
        int loop = 100;
        Random rnd = new Random();

        System.out.printf("# lookup time in a binary tree with n amount of elements\n");
		System.out.printf("#%7s%8s\n", "n", "time");

        for(int n = 100; n <= 2000; n += 100){
            BinaryTree tree = new BinaryTree();

            System.out.printf("%8d", n);
            

            double minL = Double.POSITIVE_INFINITY;
			for(int i = 0; i < tries; i++){
				double start = System.nanoTime();

                //for(int j = 0; j < loop; j++){

                    tree.Saturate(0, n);
                    tree.lookup(n);
                //}
				double t = System.nanoTime() - start;
                
				if (t < minL)
					minL = t;
			}
			System.out.printf("%8.0f\n", minL/(loop));
        }*/









        
            /*tree.add(7, 1);
            tree.add(4, 2);
            tree.add(5, 3);
            tree.add(12, 4);
            tree.add(9, 5);
            tree.add(15, 6);
            tree.add(1, 7);
            
            System.out.println(tree.lookup(5));
            System.out.println();

            tree.root.print();*/
            int k = 0;

            tree.add(6, 106);
            tree.add(4, 104);
            tree.add(8, 108);
            tree.add(3, 103);
            tree.add(5, 105);
            tree.add(7, 107);
            tree.add(9, 109);
            tree.add(2, 102);
            tree.add(1, 101);
            tree.add(10, 110);


            for (int i : tree){
                //System.out.println("next value " + i);
                //if(k == 3){
                    //break;
                //}
                System.out.println("next value " + i);
                //k++;
            }
            System.out.println();

            /*tree.add(4, 104);
            tree.add(9, 109);
            tree.add(10, 110);
            for (int i : tree)
                System.out.println("next value " + i); */


            


        }


}