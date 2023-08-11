package kata.supermarket;

import java.math.BigDecimal;

public abstract class Item {

    private final String name;

    private final String category;

    public Item(final String name, final String category){
        this.name = name;
        this.category = category;
    }

    public abstract BigDecimal price();

    public String getName(){
        return this.name;
    }

    public String getCategory(){
        return category;
    }
}
