package kata.supermarket;

import java.math.BigDecimal;

public class ProductByUnit {

    private final String name;
    private final BigDecimal pricePerUnit;

    private final String category;

    public ProductByUnit(final String name, final BigDecimal pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.category = null;
    }

    public ProductByUnit(final String name, final BigDecimal pricePerUnit, final String category) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.category = category;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(name,this, category);
    }
}
