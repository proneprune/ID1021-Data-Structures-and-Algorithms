import java.util.Random;

public class Heap {

    Random rnd = new Random();

    public class Node{
        public Integer priority;
        public int size;
        public Node left, right;
        //public int depth;

        public Node(Integer priority){
            this.priority = priority;
            this.left = this.right = null;
            this.size = 1;
            //this.depth = 0;
        }

        private void add(Integer priority){
            if (this.priority == priority){
                return;
            }
            size += 1;
            if (priority < this.priority){
                Integer temp = this.priority;
                this.priority = priority;
                priority = temp;
            }
            if (left == null){
                left = new Node(priority);
                return;
            }
            if (right == null){
                right = new Node(priority);
                return;
            }
            if (right.size > left.size){
                left.add(priority);
            }
            if (left.size > right.size){
                right.add(priority);
            }
            else{
                left.add(priority);
            }
        }

        private Node remove(){
            size -= 1;
            if (right == null){
                //System.out.println(left);
                if (left != null){
                    priority = left.priority;
                    if (left.left == null && left.right == null){
                        left = null;
                        return this;
                    }
                left.remove();
                }
                return left;
            }
            else{
                if (left == null)
                    return right;
                else{
                    if (left.priority < right.priority){
                        priority = left.priority;
                        if(left.left == null && left.right == null)
                            left = null;
                        else
                            left.remove();
                    }
                    else{
                        priority = right.priority;
                        if(right.left == null && right.right == null)
                            right = null;
                        else
                            right.remove();
                    }
                    
                    return this;
                }
            }
        }

        public void print(){
            if (left != null)
                left.print();
            System.out.println(" priority:" + priority + "\tsize: " + size);
            if (right != null)
                right.print();
        }
    }
//heap grejer

    Node root;

    public Heap(){
        root = null;
    }

    public void add(Integer priority){
        if (root == null){
            root = new Node(priority);
        }
        else
        root.add(priority);
    }

    public Integer remove(){
        if (root == null)
            return null;
        else{
        Integer p = root.priority;
        root = root.remove();
        return p;
        }
    }

    public Integer pushrecur(Node cur, Integer depth) {
            Integer temp = cur.priority;
            depth++;
            
            if(cur.left != null && cur.right != null) {
                if(cur.left.priority < cur.right.priority && cur.left.priority < cur.priority) {
                    cur.priority = cur.left.priority;
                    cur.left.priority = temp;
                    depth = pushrecur(cur.left, depth);
                }
                else if(cur.right.priority < cur.priority) {
                    cur.priority = cur.right.priority;
                    cur.right.priority = temp;
                    depth = pushrecur(cur.right, depth);
                }
            }
            else if(cur.left == null && cur.right != null) {
                if(cur.right.priority < cur.priority) {
                    cur.priority = cur.right.priority;
                    cur.right.priority = temp;
                    depth = pushrecur(cur.right, depth);
                }
            }
            else if(cur.right == null && cur.left != null) {
                if(cur.left.priority < cur.priority) {
                    cur.priority = cur.left.priority;
                    cur.left.priority = temp;
                    depth = pushrecur(cur.left, depth);
                }
            }
            return depth;
        }
        
        public Integer incr(Integer something) {
            something++;
            return something;
        }

    public Integer push(){
        //System.out.print("push made " + root.priority);
		root.priority = 10 + rnd.nextInt(90);
		//System.out.println(" into " + root.priority);
		Integer doodad = incr(root.priority);
		Integer depth = 0;
		depth = pushrecur(root, depth);
		return depth;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        Random rand = new Random();
        

        int n = 100;
        int[] sizes = new int[]{100, 200, 400, 800, 1600, 3200, 6400, 12800};


        

        for (int k : sizes){
            double t0 = System.nanoTime();
            for (int i = 0; i < k; i++)
                heap.add(rand.nextInt(10000));;

            for (int i = 0; i<k; i++){

                heap.remove();
            }
            double t1 = System.nanoTime();
            System.out.println(" time for " + k + " push " + (t1-t0)/1000 + " us");
            //System.out.println(" time for " + k + " enqueue and dequeue operations " + (t1-t0)/1000 + " us");
        } 

        for (int k : sizes){
            double t0 = System.nanoTime();
            for (int i = 0; i < k; i++)
                heap.add(rand.nextInt(10000));;

            for (int i = 0; i<k; i++){

                heap.add(heap.remove()*(10+rand.nextInt(90)));
            }
            double t1 = System.nanoTime();
            System.out.println(" time for " + k + " push " + (t1-t0)/1000 + " us");
            //System.out.println(" time for " + k + " enqueue and dequeue operations " + (t1-t0)/1000 + " us");
        } 
        /*for(int i = 0; i < 1023; i++){
            heap.add(rand.nextInt(10000));
        }
        for(int i = 0; i< 1000; i++){
            k = k + heap.push();
        }
        System.out.println(k/1000);*/

        
        //heap.root.print();
        





        /*heap.add(10);
        heap.root.print();
        System.out.println();
        heap.add(5);
        heap.root.print();
        System.out.println();
        heap.add(1);
        heap.root.print();
        System.out.println();
        heap.add(2);
        heap.root.print();
        System.out.println();
        heap.add(16);
        heap.root.print();
        System.out.println();
        heap.add(4);
        heap.root.print();
        System.out.println();
        heap.add(26);
        heap.root.print();
        System.out.println();
        heap.add(12);
        heap.root.print();
        /*System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(heap.remove());
        System.out.println();
        heap.root.print();
        System.out.println();

        System.out.println(heap.push());
        System.out.println();
        heap.root.print();
        System.out.println();*/

    }
}
