import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
public class Hash {
    Node[] data;
    int[] keys;
    int max;

    private class Node {
    Integer code;
    String name;
    Integer pop;

    public Node(Integer code, String name, Integer pop){
        this.code = code;
        this.name = name;
        this.pop = pop;
    }
    }

    public class Buckets{
        private Node code;
        private Buckets next;
        private int head;

        public Buckets(Integer code, String name, Integer pop){
            this.code = new Node(code, name, pop);
            next = null;
            head = 0;
        }
    }
    public class Bucket{
        private Node node;
        
        public Bucket(Integer code, String name, Integer pop){
            this.node = new Node(code, name, pop);
        }
    }

    public int sizeHash(int cur){
        int a = 0;
        for (int i = 0; i < cur; i++){
            a++;
        }
        return a;
    }

    /*public Bucket[][] hasharray(int mod){
        Bucket[][] bucket = new Bucket[mod][1];


        for (int i = 0; i < max; i++){
            int curarraysize = 0;
            int cur = 0;
            Integer index = keys[i] % mod;
            if (bucket[index][0] == null){
                bucket[index][0] = new Bucket(data[i].code, data[i].name, data[i].pop);
            }
            
            else if (bucket[index][cur] != null){
                curarraysize++;
                while (cur < curarraysize)
                    cur++;
            }
            if (bucket[index][cur] < sizeHash(cur)){
                Bucket[] copy = new Bucket[cur+1];
                for (int j = 0; j < copy.length-1; j++){
                    copy[j] = bucket[index][j];
                    bucket[index] = copy;
                }
            }
        }
        return bucket;
    }*/

    public Buckets[] hashfunction(int mod){
        Buckets[] buckets = new Buckets[mod];

        for(int i = 0; i < max; i++){
            Integer index = keys[i] % mod;

            if (buckets[index] != null){
                Buckets pointer = buckets[index];
            
            while(pointer.next != null)
				pointer = pointer.next;
			
            pointer.next = new Buckets(data[i].code, data[i].name, data[i].pop);
            }
            else
			    buckets[index] = new Buckets(data[i].code, data[i].name, data[i].pop);
        }
        return buckets;
    }

    public int lookup(Buckets[] Buckets, Integer zip, int mod){
        Integer index = zip % mod;
        int depth = 0;
        if (Buckets[index] == null)
            return -1;
        System.out.println(Buckets[index].code.code);
        if (Buckets[index] != null && zip != Buckets[index].code.code){
            while(Buckets[index].next != null && Buckets[index].code.code != zip){
                Buckets[index] = Buckets[index].next;
                if(Buckets[index].next == null)
                    System.out.println("tjoho");
                depth++;
            }
        }
        if(Buckets[index] != null && zip == Buckets[index].code.code)
            return depth;

        System.out.println(Buckets[index].code.code);
        return -1;
    }


    public void collissions(int mod){
        int[] data = new int[mod];
        int[] cols = new int [10000];

        for (int i = 0; i < max; i++){
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        int maxCollisions = 0;
        int totalCollisions = 0;
        while(cols[maxCollisions] > 0)
            totalCollisions += cols[maxCollisions] *maxCollisions++;

        float averageCollisions = totalCollisions/(float)max;
        float score = (float)(1-averageCollisions/mod)*100000;

        System.out.println("mod: " + mod + " Average collisions: " + averageCollisions + " Score: " + score);

        for(int i = 0; i< 10; i++){
            System.out.println(cols[i] + "\t");
        }
        System.out.println();
    }

    public int better(int mod){
        Node[] node = new Node[40000];
        int a = 0;
        int total = 0;
        for(int i = 0; i < max; i++){
            Integer index = keys[i] % mod;

            if (node[index] == null)
                node[index] = new Node(data[i].code, data[i].name, data[i].pop);
            if (node[index] != null){
                while (node[index] != null){
                    index++;
                    a++;   
                }
                node[index] = new Node(data[i].code, data[i].name, data[i].pop);
            }

            node[index] = new Node(data[i].code, data[i].name, data[i].pop);
        }
        total = a/keys.length;
        return total;
    }

    public Hash(String file) {
        data = new Node[10000];
        keys = new int[9675];
        
        

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i] = new Node(code, row[1], Integer.valueOf(row[2]));
                keys[i] = code;
                i++;
            }

            max = i-1;
        }
        catch (Exception e) {
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
        Hash hash = new Hash(s);
        int Hash = 12345;
        System.out.println(hash.data[0].code);
        //System.out.println(hash.keys[9674]);
        //hash.hashfunction(12345);
        //hash.collissions(Hash);
        //System.out.println(hash.hasharray(Hash));
        int t = hash.better(Hash);
        System.out.println(t);
        System.out.println();
        Buckets[] b = hash.hashfunction(Hash);
        int i = hash.lookup(b, 98499, Hash);
        System.out.println(i);
        

        //System.out.println(hash.max);
        //System.out.println(hash.data[0].name);
        //System.out.println(Arrays.toString(data));
        //System.out.println(ziplinearhash.binary(ziplinearhash.data, "121 35"));

    }
}
