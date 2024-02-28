import java.util.Random;


class Bench {

	public static void search_unsorted(int[] array, int[] key) {
		for(int i = 0; i < key.length; i++){
		for (int index = 0; index < array.length ; index++) {
			if (array[index] == key[i]) {
				break;
			}
		}
		
	}
}

	
    private static void linear(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    //Linear.search(array, indx[i]);
		for (int j = 0 ; j < array.length; j++){
			if(array[j] == indx[i]){
				break;
			}
			if(array[j] > indx[i]){
				break;
			}
		}
	}
    }
    

    private static void binary(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    //Binary.search(array, indx[i]);
	
		int first = 0;
        int last = array.length-1;

        while (first<=last) {
            // jump to the middle
            int index = first + ((last - first) / 2);
            //System.out.println(index);
            if (array[index] == indx[i]) {
            // hmm what now?
            //return true;
			break;
            }
            if (array[index] < indx[i] && index < last) {
            // The index position holds something that is less than
            // what we're looking for, what is the first possible page?
            first = index + 1;
            continue;
            }
            if (array[index] > indx[i] && index > first) {
            // The index position holds something that is larger than
            // what we're looking for, what is the last possible page?
            last = index - 1 ;
            continue;
            }
            // Why do we land here? What should we do?
            //return false;
			break;
        }
	}
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

	int[] sizes = {100,200,400,800,1600,3200, 6400};

	System.out.printf("# searching through an array of length n, time in ns\n");
	System.out.printf("#%7s%8s%8s%8s%8s\n", "n", "unsorted", "linear", "binary", "ratio");
	for ( int n : sizes) {

	    int loop = 10000;
	    
		int[] array2 = keys(loop, n);
	    int[] array = sorted(n);
	    int[] indx = keys(loop, n);

	    System.out.printf("%8d", n);

	    int k = 1000;

		double min = Double.POSITIVE_INFINITY;

	    for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		search_unsorted(array2, indx);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min)
		    min = t;
	    }
	    System.out.printf("%8.0f", (min/loop));
	    
	    min = Double.POSITIVE_INFINITY;

	    for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		linear(array, indx);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min)
		    min = t;
	    }
		double s0 = min/loop;
	    System.out.printf("%8.0f", (min/loop));	    

	    min = Double.POSITIVE_INFINITY;
	    
	    for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		binary(array, indx);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min)
		    min = t;
	    }
		double s1 = min/loop;

	    System.out.printf("%8.0f\t" , (min/loop));
		System.out.printf("%.2f\n" , (s0/s1));
	}
    }
}