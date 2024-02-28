import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
public class ZipLinearHash {
    Node[] data;
    int max;

    public class Node {
    Integer code;
    String name;
    Integer pop;

    public Node(Integer code, String name, Integer pop){
        this.code = code;
        this.name = name;
        this.pop = pop;
    }
    }

    public ZipLinearHash(String file) {
        data = new Node[10000];

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
            data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
        }

        max = i-1;
    } catch (Exception e) {
    System.out.println(" file " + file + " not found");
    }
    }   

        public int linear(Integer zip){
        for(int i = 0; i < data.length; i++){
            if(data[i] == null)
                return 0;
            if(data[i].code == zip)
                return i+1;
        }
    return 0;
    }

    public int linearstring(String zip){
        for(int i = 0; i < data.length; i++){
            if(data[i] == null)
                return 0;
            if(data[i].code.equals(zip))
                return i+1;
        }
    return 0;
    }

        public int binary(Node arr[], Integer zip){
        int l =0;
        int r = arr.length-1;
        while(l <=r){
            int m = l + ((r-l)/2);

            if(arr[m] == null)
                return -1;
            
            
            if (arr[m].code == zip)
                return m+1;

            if (arr[m].code > zip)
                l = m + 1;
            else
                r = m - 1;

        }
        return -1;
    }


    public int binarystring(Node arr[], String zip){
        int l =0;
        int r = arr.length-1;
        while(l <=r){
            int m = l + ((r-l)/2);

            if(arr[m] == null)
                return -1;

            /*int res = zip.compareTo(arr[m].code);
            
            
            if (res == 0)
                return m+1;

            if (res > 0)
                l = m + 1;
            else
                r = m - 1;*/

        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "postnummer.csv";
        ZipLinearHash ziplinearhash = new ZipLinearHash(s);
        //System.out.println(ziplinearhash.data[0].pop);
        //System.out.println(Arrays.toString(data));
        //System.out.println(ziplinearhash.binary(ziplinearhash.data, "121 35"));

        int n = 100;
        int[] sizes = new int[]{100, 200, 400, 800, 1600, 3200};


        for (int k : sizes){
            double t0 = System.nanoTime();
            for (int i = 0; i < k; i++)
                ziplinearhash.linear(11115);
                ziplinearhash.linear(98499);
            double t1 = System.nanoTime();
            System.out.println(" time for " + k + " linear lookups " + (t1-t0)/1000 + " us");
            //System.out.println(" time for " + k + " enqueue and dequeue operations " + (t1-t0)/1000 + " us");
        } 
        System.out.println();

        for (int k : sizes){
            double t0 = System.nanoTime();
            for (int i = 0; i < k; i++)
                ziplinearhash.binary(ziplinearhash.data, 11115);
                ziplinearhash.binary(ziplinearhash.data, 98499);
            double t1 = System.nanoTime();
            System.out.println(" time for " + k + " binary lookups " + (t1-t0)/1000 + " us");
            //Sys


    }
}
}
