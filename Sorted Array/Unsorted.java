import java.util.Arrays;
import java.util.Random;

class Unsorted{


public static boolean search_unsorted(int[] array, int key) {
    for (int index = 0; index < array.length ; index++) {
        if (array[index] == key) {
            return true;
        }
    }
    return false;
}


public static void main(String[] args){

int size = 1000000;
int[] test = new int[size];
Random rnd = new Random();

for(int i = 0; i < size; i++){
    test[i] = rnd.nextInt(size);
}
int k = 10000;
int bajs = -500000;
int loops = 1000;


double min = Double.POSITIVE_INFINITY;

for(int i = 0; i < k; i++){
    long t0 = System.nanoTime();
    search_unsorted(test, bajs);
    long t1 = System.nanoTime();
    double t = (t1-t0);
    if(t < min)
        min = t;
}

//System.out.println(Arrays.toString(test));
System.out.println(search_unsorted(test, bajs));
System.out.println(min);
System.out.printf("%.8f", (min/(1000)));

}

}