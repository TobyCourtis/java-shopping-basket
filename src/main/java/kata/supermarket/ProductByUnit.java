package kata.supermarket;

import java.math.BigDecimal;

public class ProductByUnit {

    private final String name;
    private final BigDecimal pricePerUnit;

    public ProductByUnit(final String name, final BigDecimal pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(name,this);
    }
}
