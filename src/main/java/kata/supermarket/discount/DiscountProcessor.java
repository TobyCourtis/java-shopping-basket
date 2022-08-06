package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class DiscountProcessor {

    private final List<Discount> discounts;

    public DiscountProcessor(Discount... discounts){ // Spring DI would automatically add all 'Discount' Beans
        this.discounts = Arrays.asList(discounts);
    }

    public BigDecimal applyAllDiscounts(List<Item> items) {
        BigDecimal totalDiscount = new BigDecimal(0);
        for(Discount discount : discounts){
            totalDiscount = totalDiscount.add(discount.applyDiscount(items));
        }
        return totalDiscount;
    }
}
