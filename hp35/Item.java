package hp35;
public class Item{
    private ItemType type;
    private int value = 0;

    public static Item Add(){
        Item newItem = new Item();
        newItem.type = ItemType.ADD;
        return newItem;
    }

    public static Item Sub(){
        Item NewItem = new Item();
        newItem.type = ItemType.SUB;
        return NewItem;
    }

    public static Item Mul(){
        Item NewItem = new Item();
        NewItem.type = ItemType.MUL;
        return NewItem;
    }

    public static Item Div(){
        Item NewItem = new Item();
        NewItem.type = ItemType.DIV;
        return NewItem;
    }

    public static Item Value(int val){
        Item NewItem = new Item();
        NewItem.type = ItemType.VALUE;
        NewItem.value = val;
        return NewItem;
    }

    public ItemType type(){
        return this.type;
    }

    public int value(){
        return this.value;
    }

    public enum ItemType{
        ADD,
        SUB,
        MUL,
        DIV,
        VALUE
    }

}