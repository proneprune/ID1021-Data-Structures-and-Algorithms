import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
public class Zip {
    Node[] data;
    int max;

    public class Node {
    String code;
    String name;
    Integer pop;

    public Node(String code, String name, Integer pop){
        this.code = code;
        this.name = name;
        this.pop = pop;
    }
    }

    public Zip(String file) {
        data = new Node[10000];

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
        }

        max = i-1;
    } catch (Exception e) {
    System.out.println(" file " + file + " not found");
    }
    }   
    //:

    public static void main(String[] args) {
        String s = "postnummer.csv";
        Zip zip = new Zip(s);
        System.out.println(Arrays.toString(zip.data));
        //System.out.println(Arrays.toString(data));
    }
}
