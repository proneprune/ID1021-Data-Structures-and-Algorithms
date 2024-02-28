import java.util.Arrays;
import java.util.Random;

public class Binary_search {
    

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;

        while (first<=last) {
            // jump to the middle
            int index = first + ((last - first) / 2);

            //System.out.println(index);

            if (array[index] == key) {
            // hmm what now?
            return true;
            }


            if (array[index] < key && index < last) {
            // The index position holds something that is less than
            // what we're looking for, what is the first possible page?
            first = index + 1;
            continue;
            }


            if (array[index] > key && index > first) {
            // The index position holds something that is larger than
            // what we're looking for, what is the last possible page?
            last = index - 1 ;
            continue;
            }


            // Why do we land here? What should we do?

            return false;
        }
    return false;        
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();	
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);
    
        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }	
        return array;
        }


    public static void main(String[] args){

        int test[] = sorted(1000000);
        //int test[] = new int[1000000];
        
        /*for(int i = 0; i < test.length; i++){
            test[i] = i;
        }*/

        int loops = 10000;
        int k = 1000;
        int bajs = 42;
    
        double min = Double.POSITIVE_INFINITY;
    
        for(int i = 0; i < k; i++){
            long t0 = System.nanoTime();
            binary_search(test, bajs);
            long t1 = System.nanoTime();
            double t = (t1-t0);
            if(t < min)
                min = t;
        }
    
        //System.out.println(Arrays.toString(test));
        System.out.println(binary_search(test, bajs));
        System.out.println(min);
        System.out.printf("%.8f", (min/(loops)));
    
        }

}
