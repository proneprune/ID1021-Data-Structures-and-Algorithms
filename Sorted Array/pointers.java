import java.util.Random;

public class pointers {
    public static int pointer(int[] array, int[] key){
		int doublets = 0;

		int i = 0;
		int j = 0;

		while (true){
			if (i == array.length || j == key.length){
				break;
			}
			if (array[i] == key[j]){
				doublets++;
				i++;
				j++;
				continue;
			}
			if (array[i] < key[j]){
				i++;
			}
			else {
				j++;
			}

		}
		return doublets;
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


    private static int[] keys(int loop, int n) {
	Random rnd = new Random();	
	int[] indx = new int[loop];
	for (int i = 0; i < loop ; i++) {
	    indx[i] = rnd.nextInt(n*5);
	}	
	return indx;
    }
    public static void main(String[] arg) {

        int[] sizes = {100,200,400,800,1600,3200,6400,12800,25600};
    
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s\n", "n", "linear", "binary", "pointer");
        for ( int n : sizes) {
    
            int loop = 10000;
            
            int[] array = sorted(n);
            int[] indx = keys(loop, n);
            int[] key = sorted(n);
    
            System.out.printf("%8d", n);
    
            int k = 1000;
        
            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
            long t0 = System.nanoTime();
            pointer(array, key);
            long t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
                min = t;
            }
            double s2 = min/loop;
    
            System.out.printf("%8.0f\n", (min/loop));
            }
        }
    
}
