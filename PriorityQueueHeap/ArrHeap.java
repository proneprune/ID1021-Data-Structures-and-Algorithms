import java.util.Arrays;
import java.util.Random;

public class ArrHeap {
    int [] heap;
    int size;
    int free;

    public ArrHeap(){
        size = 12800;
        free = 0;
        heap = new int[size];
    }

    public void enqueue(int pr){
        //if (free == size)
            //System.out.println("panic :-0");
        heap[free] = pr;
        bubble(free);
        free += 1;
    }

    public int dequeue(){
        //if (free == 0)
            //System.out.println("oh no");
        int ret = heap[0];
        free -=1;
        heap[0] = heap[free];
        heap[free] = 0;
        sink(0);
        return ret;
    }

    private void swap(int i, int j){
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void bubble(int q){
        if (q == 0)
            return;
        int parent = (q-1)/2;
        if (heap[q] < heap[parent])
            swap(q, parent);
        bubble(parent);
    }
    private void sink(int q){
        int left = q*2 + 1;
        int right = q*2 + 2;

        //System.out.println(" sink: " + q + " left: " + left + " right: " + right);
        if (right < free){
            if(heap[left] < heap[right]){
                if (heap[left] < heap[q]){
                    swap(left, q);
                    sink(left);
                }
            }
            else {
                if (heap[right] < heap[q]){
                    swap(right, q);
                    sink(right);
                }
            }
        }
        else if (left < free){
            if (heap[left] < heap[q]){
                swap(left, q);
            }
        }
    }


    public void print(){
        System.out.println("free: " + free + " heap: "+ Arrays.toString(this.heap));
    }

    public static void main(String[] args) {
        ArrHeap arrheap = new ArrHeap();
        Random rand = new Random();

        int n = 100;
        int[] sizes = new int[]{100, 200, 400, 800, 1600, 3200, 6400, 12800};

        for (int k : sizes){
            double t0 = System.nanoTime();
            for (int i = 0; i < k; i++)
                arrheap.enqueue(rand.nextInt(10000));;
            //arrheap.print();
            for (int i = 0; i<k; i++){

                arrheap.dequeue();
            }
            double t1 = System.nanoTime();

            System.out.println(" time for " + k + " enqueue and dequeue operations " + (t1-t0)/1000 + " us");
        }
        

    }
}
