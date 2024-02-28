import java.util.Random;

public class doublet {





    private static int linear(int[] array, int[] indx) {
        int doublets = 0;
        for (int i = 0; i < indx.length ; i++) {
			for (int j = 0 ; j < array.length; j++){
				if(array[j] == indx[i]){
					doublets++;
					
				}
			}
		}
		return doublets;
    }
    

    private static int binary(int[] array, int[] indx) {
	    int doublets = 0;
        for (int i = 0; i < indx.length ; i++) {
	    //Binary.search(array, indx[i]);
		    int first = 0;
            int last = array.length-1;

            while (first<=last) {
                int index = first + ((last - first) / 2);
                if (array[index] == indx[i]) {
                    doublets++;
			        first = last + 1;
                }
                if (array[index] < indx[i] && index < last) {
                    first = index + 1;
                    continue;
                }
                if (array[index] > indx[i] && index > first) {
                    last = index - 1 ;
                    continue;
                }
			    first = last + 1;
            }
	    }
        return doublets;
    }


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
		int[] indxx = keys(loop, n);
		int[] key = sorted(n);

	    System.out.printf("%8d", n);

	    int k = 1000;
	    
	    double min = Double.POSITIVE_INFINITY;

	    for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		linear(indxx, indx);
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

	    System.out.printf("%8.0f" , (min/loop));
		//System.out.printf("%.2f\n" , (s0/s1));


		min = Double.POSITIVE_INFINITY;
	    
	    for (int i = 0; i < k; i++) {
		long t0 = System.nanoTime();
		pointer(array, key);
		long t1 = System.nanoTime();
		double t = (t1 - t0);
		if (t < min)
		    min = t;
	    }
		double s2 = min/loop;

		System.out.printf("%8.0f\n", (min/10));
		}
    }
}

