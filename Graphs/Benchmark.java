public class Benchmark {
    public static void main(String[] args) {
        Map map = new Map("trains.csv");

        String from = "Umeå";
        String to = "Göteborg";
        Integer max = null;

        Paths paths = new Paths();

        City fromCity = map.lookup(from);
        City toCity = map.lookup(to);

        long minTime = Long.MAX_VALUE;
        Integer distance = null;

        for(int j = 0; j < 1; j++){
            long t0 = System.nanoTime();
            distance = paths.ShortestPath(fromCity, toCity, max);
            long t1 = System.nanoTime();

            long time = (t1-t0)/1000000;

            if(time < minTime)
                minTime = time;
        }
        if(distance != null)
            System.out.println("Shortest: " + distance + " time " + minTime + " ms");
        else
            System.out.println("No path found with max " + max + " distance " + minTime + " ms");
    }
}
