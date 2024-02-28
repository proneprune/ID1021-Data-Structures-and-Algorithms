public class City{

    public class Connection{
        private City startCity;
        private City endCity;
        private int length;

        public Connection(City start, City destination, int distance){
            startCity = start;
            endCity = destination;
            length = distance;
        }

        public City EndCity(){
            return endCity;
        }

        public int Length(){
            return length;
        }

        
    }

    private String name;
    private Connection[] connections;

    public City(String name){
        this.name = name;
        connections = new Connection[10];
    }

    public String Name(){
        return name;
    }

    public Connection[] Connections(){
        return connections;
    }

    public void AddConnection(City destination, int distance){
        int i = 0;

        while(connections[i] != null){
            i++;
        }

        connections[i] = new Connection(this, destination, distance);
    }


}