class Bench {
    public static void main(String[] args) {
        QueueList q1 = new QueueList();

        int n = 100;
        int[] sizes = new int[]{1000, 2000, 4000, 8000, 16000};

            for (int k : sizes){

            for (int i = 0; i < n; i++)
                q1.add(i);

            double t0 = System.nanoTime();
            for (int i = 0; i<k; i++){
                int q = q1.remove();
                q1.add(q);
            }
            double t1 = System.nanoTime();

            System.out.println(" time for " + k + " de- and enqueue operations:" + (t1-t0)/1000 + " us");
        }
    }
}
