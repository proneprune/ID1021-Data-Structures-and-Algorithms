package hp35;


public class Benchmark{
    public static void bench(int loop, int ops, Stack stack){
        for(int i = 0; i < loop; i++){
            for(int k = 0; k < ops; k++){
                stack.push(k);
            }
            for(int k = 0; k < ops; k++){
                stack.pop();
            }
        }
    }

    public static double time(int loop, int tries, int ops, Stack stack){
        double min = Double.POSITIVE_INFINITY;
        double sum = 0;

        for(int i = 0; i < tries; i++){
            System.gc();
            double t0 = System.nanoTime();
            bench(loop, ops, stack);
            double t1 = System.nanoTime();
            double t = (t1- t0);

            if(t < min){
                min = t;
            }
            sum += t;

        }
        return min;
    }

    static void bench(int ops){
        int tries = 10;
        int loop = 10000;

        Static stat = new Static(ops);
        Dynamic Dyn = new Dynamic();

        time(loop*10, tries, ops, stat);
        time(loop*10, tries, ops, Dyn);

        double stat_t = time(loop, tries, ops, stat);
        double Dyn_t = time(loop, tries, ops, Dyn);

        System.out.printf("%d \t %.2f \t %.2f \t%.2f\n", ops, (stat_t/(loop*1000)),(Dyn_t/(loop*1000)), (Dyn_t/stat_t));

    }

    public static void main(String[] args){
        System.out.printf("#%s\t%s\t%s\t%s\n", "n", "stat", "Dyn", "Ratio+l");
        bench(50);
        bench(100);
        bench(200);
        bench(400);
        bench(800);
        bench(1024);
    }
}