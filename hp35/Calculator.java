package hp35;
public class Calculator{
    Item[] expr;
    int ip;
    Stack stack;

    public Calculator(Item[] expr) {
        this.expr = expr;
        this.ip = 0;
        this.stack = new Static(expr.length); //skapar static stack eller dynamic beroende på om man kallar Static() eller dynamic()
    }

    public int run() {
        while ( ip < expr.length ) {
            step();
        }
        return stack.pop();
        }
    
    public void step() {
        Item nxt = expr[ip++];
        switch(nxt.type()) {
            case ADD : { //delar upp i alla olika fall
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                break;
            }
            case SUB : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
                break;
            }
            case MUL : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x * y);
                break;
            }
            case DIV : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
                break;
            }
            case VALUE : {
                stack.push(nxt.value());// måste få värdet int av nxt och inte som Item
                break;
            }

        }
    }


    /*public static void main(String[] args) {
        // 10 + 2 * 5
        // 10 2 5 * + in reversed Polish notation
        Item[] expr = {
            Item.Value(10),
            Item.Value(2),
            Item.Value(5),
            Item.Value(2),
            Item.Value(1)
        };

        Calculator calc = new Calculator(expr);

        int res = calc.run();

        System.out.println(" Calculator: res = " + res);
        }*/
        
}