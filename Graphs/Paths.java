public class Paths {
    private City[] path = new City[52];
    private int sp = 0;

    public Paths(){
        path = new City[52];
        sp = 0;
    }

    public Integer ShortestPath(City from, City to, Integer max){
        if(max != null && max < 0)
            return null;
        if(from == to)
            return 0;

        for(int i = 0; i < sp; i++){
            if(path[i] == from)
                return null;
        }

        path[sp++] = from;

        Integer shortest = null;

        for(int i = 0; i < from.Connections().length; i++){
            if(from.Connections()[i] != null){
                City.Connection connection = from.Connections()[i];

                Integer addShort = connection.Length();

                if (max == null){
                    Integer distance = ShortestPath(connection.EndCity(), to, max);


                    if(distance != null)
                        addShort += distance;
                    else
                        continue;

                    if(shortest == null){
                        shortest = addShort;
                        max = addShort;
                    }

                    if(addShort < shortest){
                        shortest = addShort;
                        max = addShort;
                    }
                }
                if (max != null){
                    Integer distance = ShortestPath(connection.EndCity(), to, max-connection.Length());


                    if(distance != null)
                        addShort += distance;
                    else
                        continue;

                    if(shortest == null){
                        shortest = addShort;
                        max = addShort;
                    }

                    if(addShort < shortest){
                        shortest = addShort;
                        max = addShort;
                    }
                }
            }
        }
        path[sp--] = null;
        return shortest;
    }

    public static void main(String[] args) {
        
    }
}
