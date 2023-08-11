package kata.supermarket;

import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_UP;

public class ItemByWeight extends Item {

    private final ProductByWeight product;
    private final BigDecimal weightInKilos;

    ItemByWeight(final String name, final ProductByWeight product, final BigDecimal weightInKilos) {
        super(name, null);
        this.product = product;
        this.weightInKilos = weightInKilos;
    }

    @Override
    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, HALF_UP);
    }
}
