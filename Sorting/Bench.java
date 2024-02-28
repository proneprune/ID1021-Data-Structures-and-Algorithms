import java.util.Random;

public class Bench {
	public static void mergeSort(int[] array) {
		int length = array.length;
		if (length <= 1) return; //base case
		int middle = length / 2;
		int[] leftArray = new int[middle];
		int[] rightArray = new int[length - middle];
		int i = 0; //left array
		int j = 0; //right array	
		for(; i < length; i++) {
			if(i < middle) {
				leftArray[i] = array[i];
			}
			else {
				rightArray[j] = array[i];
				j++;
			}
		}
		mergeSort(leftArray);
		mergeSort(rightArray);
		merge(leftArray, rightArray, array);
	}

	

	private static void merge(int[] leftArray, int[] rightArray, int[] array) {

		int leftSize = array.length / 2;
		int rightSize = array.length - leftSize;
		int i = 0, l = 0, r = 0; //indices
		//check the conditions for merging

		while(l < leftSize && r < rightSize) {
			if(leftArray[l] < rightArray[r]) {
				array[i] = leftArray[l];
				i++;
				l++;
			}
			else {
				array[i] = rightArray[r];
				i++;
				r++;
			}
		}
		while(l < leftSize) {
			array[i] = leftArray[l];
			i++;
			l++;
		}
		while(r < rightSize) {
			array[i] = rightArray[r];
			i++;
			r++;
		}
	}    

	public static void insertionSort(int[] array) {

		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			while(j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
	}


	public static void selectionSort(int[] array) {

		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}
	
        public static void main(String args[]){   

			int tries = 100;
			int loop = 100;
			Random rnd = new Random();

			
		System.out.printf("# sorting an array of length n, time in ns\n");
		System.out.printf("#%7s%12s%12s%8s\n", "n", "selection", "insertion", "merge");

		for(int n = 1000; n <= 16000; n += 1000){

			int [] array = new int[n];
			for(int i = 0; i < n; i++){
				array[i] = rnd.nextInt(n*10);
			}

			System.out.printf("%8d", n);
			
			double minS = Double.POSITIVE_INFINITY;
			for(int i = 0; i < tries; i++){
				double start = System.nanoTime();
				for(int j = 0; j < loop; j++){
					int[] clone = array.clone();
					selectionSort(clone);
				}
				double t = System.nanoTime() - start;
				if (t < minS)
					minS = t;
			}
			System.out.printf("%8.0f", minS/(loop*1000));


			double minI = Double.POSITIVE_INFINITY;
			for(int i = 0; i < tries; i++){
				double start = System.nanoTime();
				for(int j = 0; j < loop; j++){
					int[] clone = array.clone();
					insertionSort(clone);
				}
				double t = System.nanoTime() - start;
				if (t < minI)
					minI = t;
			}
			System.out.printf("%12.0f", minI/(loop*1000));


			double minM = Double.POSITIVE_INFINITY;
			for(int i = 0; i < tries; i++){
				double start = System.nanoTime();
				for(int j = 0; j < loop; j++){
					int[] clone = array.clone();
					mergeSort(clone);
				}
				double t = System.nanoTime() - start;
				if (t < minM)
					minM = t;
			}
			System.out.printf("%11.0f\n", minM/(loop*1000));
		}







		}
}
