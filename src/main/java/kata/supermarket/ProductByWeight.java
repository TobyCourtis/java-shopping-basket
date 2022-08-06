package kata.supermarket;

import java.math.BigDecimal;

public class ProductByWeight {

    private final String name;
    private final BigDecimal pricePerKilo;

    public ProductByWeight(final String name, final BigDecimal pricePerKilo) {
        this.name = name;
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }

    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(name, this, kilos);
    }
}
