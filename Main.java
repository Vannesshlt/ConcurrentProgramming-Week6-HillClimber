/**
 * Created by VannessTan on 26/04/2016.
 */
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){

        long time = System.currentTimeMillis();
        double[][] array = new double[200][100];

        ExecutorService taskExecutor = Executors.newFixedThreadPool(8); //factory, all are static
        myTask[] myTaskRunnable = new myTask[200];

        for(int i = 0; i < 200; i++){
            for(int j = 0; j < 100; j++){
                array[i][j] = Math.random() * 10.24 + - 5.12;
            }
            myTaskRunnable[i] = new myTask(array[i]);
            taskExecutor.execute(myTaskRunnable[i]);
        }
        taskExecutor.shutdown();

        try {
            taskExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {

        }

        for(int i = 0; i < 200; i++){
            if((i + 1) % 20 == 0){
                System.out.printf("Current min for %dth iteration is: %.2f\n", i + 1, myTaskRunnable[i].getMin());
            }
        }
        System.out.println();

        System.out.printf("Minimum value of summation of rows: %.2f\n", getMin(myTaskRunnable));
        System.out.println("Execution Time: " + (System.currentTimeMillis() - time));

    }

    public static double getMin(myTask[] myTaskRunnable){

        double min = 999999999.99;

        for(int i = 0; i < 200; i++){
            min = min > myTaskRunnable[i].getMin() ? myTaskRunnable[i].getMin() : min;
        }

        return min;
    }
}
