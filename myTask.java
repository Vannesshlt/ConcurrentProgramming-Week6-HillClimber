/**
 * Created by VannessTan on 26/04/2016.
 */

public class myTask implements Runnable{

    private double[] array, clonedArray;
    private double min ;

    public myTask(double[] array){

        this.array = new double[100];
        this.clonedArray = new double[100];

        for(int i = 0; i < 100; i++){

            this.array[i] = array[i];
            this.clonedArray[i] = array[i];
        }
    }

    public void run(){

        int counter = 0;
        min = 999999999.99;

        do{
            double temp = summationOfRow(0, 0.0);

            for(int i = 0; i < 100; i++){

            }
            if(min > temp){
                min = temp;
            }
            else{
                cloningArray();
            }

            modifyNumber();
            counter++;

        } while(counter <= 300000);
    }

    public double summationOfRow(int pointer, double value){

        if(pointer >= array.length){
            return value;
        }
        return summationOfRow(pointer+1, value + (pointer * (array[pointer] * array[pointer])));
    }

    public void modifyNumber(){

        double randomNumber;

        for(int i = 0; i < array.length; i++){

            clonedArray[i] = array[i];


            do{
                randomNumber = Math.random() * (0.5 - (-0.5)) + (-0.5);

            } while (array[i] + randomNumber >= 5.12 && array[i] + randomNumber <= -5.12);

            array[i]+= randomNumber;
        }
    }


    public double getMin(){

        return min;
    }

    public void cloningArray(){
        for(int i = 0; i < 100; i++){
            array[i] = clonedArray[i];
        }
    }
}
