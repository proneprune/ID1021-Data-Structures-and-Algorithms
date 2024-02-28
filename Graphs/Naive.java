public class Naive {

    public static Integer ShortestPath(City from, City to, int max){
        if (max < 0)
            return null;
        
        if (from == to)
            return 0;

        Integer shortest = null;

        for (int i = 0; i < from.Connections().length; i++){
            if(from.Connections()[i] != null){
                City.Connection connection = from.Connections()[i];

                Integer addShort = connection.Length();
                Integer distance = ShortestPath(connection.EndCity(), to, max-connection.Length());

                if(distance != null)
                    addShort += distance;
                else
                    continue;

                if(shortest == null)
                    shortest = addShort;


                if(addShort < shortest)
                    shortest = addShort;
            }
        }
        return shortest;
    }
    

    public static void main(String[] args) {
        Map map = new Map("trains.csv");
        String from = "Göteborg";
        String to = "Umeå";

        Paths paths = new Paths();

        City fromCity = map.lookup(from);
        City toCity = map.lookup(to);
        Integer max = 800;

        long t0 = System.nanoTime();
        Integer dist = ShortestPath(fromCity, toCity, max);
        long time = (System.nanoTime() - t0)/1000000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
}
