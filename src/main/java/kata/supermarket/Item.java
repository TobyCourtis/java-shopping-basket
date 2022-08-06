package kata.supermarket;

import java.math.BigDecimal;

public abstract class Item {

    private final String name;

    public Item(final String name){
        this.name = name;
    }

    public abstract BigDecimal price();

    public String getName(){
        return this.name;
    }
}
