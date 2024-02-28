import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
public class ZipKey {
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

    public ZipKey(String file) {
        data = new Node[100000];

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
            data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
        }

        max = i-1;
    } catch (Exception e) {
    System.out.println(" file " + file + " not found");
    }
    }   

        public int linear(Integer zip){
        if(data[zip] == null)
            return -1;
        if(data[zip].code == zip)
            return zip;
        else
            return -1;
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

    public static void main(String[] args) {
        String s = "postnummer.csv";
        ZipKey zipkey = new ZipKey(s);
        System.out.println(zipkey.data[12831].code);
        //System.out.println(Arrays.toString(data));
        //System.out.println(ziplinearhash.binary(ziplinearhash.data, "121 35"));

        int n = 100;
        int[] sizes = new int[]{100, 200, 400, 800, 1600, 3200};


        for (int k : sizes){
            double t0 = System.nanoTime();
            for (int i = 0; i < k; i++)
                zipkey.linear(11115);
                zipkey.linear(98499);
            double t1 = System.nanoTime();
            System.out.println(" time for " + k + " linear lookups " + (t1-t0)/1000 + " us");
            //System.out.println(" time for " + k + " enqueue and dequeue operations " + (t1-t0)/1000 + " us");
        } 
        System.out.println();

        for (int k : sizes){
            double t0 = System.nanoTime();
            for (int i = 0; i < k; i++)
                zipkey.binary(zipkey.data, 11115);
                zipkey.binary(zipkey.data, 98499);
            double t1 = System.nanoTime();
            System.out.println(" time for " + k + " binary lookups " + (t1-t0)/1000 + " us");
            //Sys


    }
}
}
