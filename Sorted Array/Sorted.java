import java.util.Random;
import java.util.Arrays;

public class Sorted {
    
    
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


    public static boolean search_sorted(int[] array, int key){
        for(int i = 0; i < array.length; i++){
            if(array[i] == key){
                return true;
            }
            if(array[i] > key){
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args){
int[] sizes = {100000, 250000, 500000, 750000, 1000000};
for(int n : sizes){
    int test[] = sorted(n);
    int loops = 10000;
    int bajs = 50000110;

    double min = Double.POSITIVE_INFINITY;

    for(int i = 0; i < loops; i++){
        long t0 = System.nanoTime();
        search_sorted(test, bajs);
        long t1 = System.nanoTime();
        double t = (t1-t0);
        if(t < min)
            min = t;
    }

    //System.out.println(Arrays.toString(test));
    System.out.println(search_sorted(test, bajs));
    System.out.println(min);
    System.out.printf("%.8f\n", (min/(1000)));

    }
    }
}
