package hp35;

import java.util.Arrays;

public class Dynamic extends Stack{
    
    public Dynamic(){
        stack = new int[4];
    }
    @Override
    public void push(int val){

        if(pointer == stack.length){                    //om pointer når slutet av stacken
            int[] tempstack = new int[stack.length*2];  //skapar den en ny stack som är dubbelt så stor
            for(int i = 0; i<stack.length; i++){        //kopierar över alla element i den nya stacken mha
                tempstack[i] = stack[i];                //en temporär array som den sedan nullar
            }
            stack = new int[tempstack.length];

            for(int i = 0; i<tempstack.length; i++){
                stack[i] = tempstack[i];
            }
            tempstack = null;
        }
        stack[pointer] = val;
        pointer++;
    }
    @Override
    public int pop(){
        if(pointer == stack.length/4){                  //om stacken når 1/4 av ursprungs storleken 
            int[] tempstack = new int[stack.length/4];  //kommer en ny stack mha en temporär array skapas
                                                        //som är 1/4 av ursprungs storleken.
            for(int i = 0; i<tempstack.length; i++){
                tempstack[i] = stack[i];
            }
            stack = new int[tempstack.length];

            for(int i = 0; i<tempstack.length; i++){
                stack[i] = tempstack[i];
            }
            tempstack = null;
        }
        pointer--;
        return stack[pointer];
    }
}
