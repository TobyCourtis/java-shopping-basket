package kata.supermarket;

import java.math.BigDecimal;

public class ItemByUnit extends Item {

    private final ProductByUnit productByUnit;

    ItemByUnit(final String name, final ProductByUnit productByUnit) {
        super(name);
        this.productByUnit = productByUnit;
    }

    @Override
    public BigDecimal price() {
        return productByUnit.pricePerUnit();
    }
}
