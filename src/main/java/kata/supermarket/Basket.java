package kata.supermarket;

import kata.supermarket.discount.DiscountProcessor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {
    private final List<Item> items;
    private final DiscountProcessor discountProcessor;

    public Basket(DiscountProcessor discountProcessor) {
        this.items = new ArrayList<>();
        this.discountProcessor = discountProcessor;
    }

    public void add(final Item item) {
        this.items.add(item);
    }

    List<Item> items() {
        return Collections.unmodifiableList(items);
    }

    public BigDecimal total() {
        return new TotalCalculator(discountProcessor).calculate();
    }

    private class TotalCalculator {
        private final List<Item> items;
        private final DiscountProcessor discountProcessor;

        TotalCalculator(DiscountProcessor discountProcessor) {
            this.items = items();
            this.discountProcessor = discountProcessor;
        }

        private BigDecimal subtotal() {
            return items.stream().map(Item::price)
                    .reduce(BigDecimal::add)
                    .orElse(BigDecimal.ZERO)
                    .setScale(2, RoundingMode.HALF_UP);
        }

        private BigDecimal discounts() {
            return discountProcessor.applyAllDiscounts(items);
        }

        private BigDecimal calculate() {
            return subtotal().subtract(discounts());
        }
    }
}
