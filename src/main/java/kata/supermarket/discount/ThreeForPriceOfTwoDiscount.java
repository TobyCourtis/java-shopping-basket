package kata.supermarket.discount;

import java.util.List;

public class ThreeForPriceOfTwoDiscount extends XForPriceOfYDiscount {

    private static final List<String> SUPPORTED_ITEMS = List.of("Chocolate");

    public ThreeForPriceOfTwoDiscount() {
        super(3, 2, SUPPORTED_ITEMS);
    }
}
