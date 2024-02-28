package hp35;

public class Static extends Stack{
    
    public Static(int sizeofexpr){
        stack = new int[sizeofexpr];
    }
    @Override
    public void push(int val){
        if(pointer >= stack.length){//ger en exception om man får stack overflow
            throw new IndexOutOfBoundsException("stack overflow");
        }
        stack[pointer] = val;
        pointer++;
    }
    @Override
    public int pop(){
        if(pointer == 0){
            throw new IndexOutOfBoundsException("No more elements in stack");//exception om man försöker poppa när stacken är tom
        }
        pointer--;
        return stack[pointer];
    }
}