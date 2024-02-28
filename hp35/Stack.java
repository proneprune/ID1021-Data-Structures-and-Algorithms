package hp35;


public abstract class Stack {

    int[] stack;
    int pointer = 0;

    public abstract void push(int val);
    public abstract int pop();
}
