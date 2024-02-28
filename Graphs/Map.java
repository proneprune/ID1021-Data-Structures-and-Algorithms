import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Map {
    
    private class Buckets{
        private City city;
        private Buckets next;

        public Buckets(String name){
            city = new City(name);
            next = null;
        }

        public City getCity(){
            return city;
        }

        public Buckets getNext(){
            return next;
        }

        public void setNext(Buckets next){
            this.next = next;
        }
    }

    private Buckets[] cities;
    private int mod;

    public Map(String filepath){
        mod = 541;
        cities =  new Buckets[mod];

        try (BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(filepath), "UTF-8"))){
            String line;
            while ((line = br.readLine()) != null){
                String[] row = line.split(",");
                City city1 = lookup(row[0]);
                City city2 = lookup(row[1]);
                int length = Integer.parseInt(row[2].replaceAll("\\s+",""));
                city1.AddConnection(city2, length);
                city2.AddConnection(city1, length);
            }
        } catch (Exception e){
            System.out.println(" file " + filepath + " not found or corrupt");
        }
    }
    public City lookup(String name){
        int index = hash(name);

        if(cities[index] == null){
            cities[index] = new Buckets(name);
            return cities[index].getCity();
        }

        if(!cities[index].getCity().Name().equals(name)){
            Buckets pointer = cities[index];
            while(!pointer.getCity().Name().equals(name) && pointer.getNext() != null)
                pointer = pointer.getNext();
            
            if (!pointer.getCity().Name().equals(name)){
                pointer.setNext(new Buckets(name));
                return pointer.getNext().getCity();
            } else{
                return pointer.getCity();
            }
        }
        
        return cities[index].getCity();
    }

    private int hash(String name){
        int hash = 7;
        for (int i = 0; i < name.length(); i++){
            hash = (hash* 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    public static void main(String[] args) {
        Map map = new Map("trains.csv");
        for(int i = 0; i < 541; i++){
            System.out.println(map.cities[i]);
        }
    }


}
