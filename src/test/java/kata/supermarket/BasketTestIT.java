package kata.supermarket;

import kata.supermarket.discount.DiscountProcessor;
import kata.supermarket.discount.ThreeForPriceOfTwoDiscount;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasketTestIT {

    @Test
    public void basketReturnsTotalWithDiscounts(){
        // given discount
        // given discountProcessor
        // given basket
        // given items
        ThreeForPriceOfTwoDiscount threeForPriceOfTwoDiscount = new ThreeForPriceOfTwoDiscount();
        DiscountProcessor discountProcessor = new DiscountProcessor(threeForPriceOfTwoDiscount);
        final Basket basket = new Basket(discountProcessor);
        List<Item> items = List.of(chocolateBar(), chocolateBar(), chocolateBar());
        items.forEach(basket::add);

        // when we get total
        BigDecimal actualTotal = basket.total();

        // then subtotal subtract discount applied
        // (3.00 * 3) - 3.00 (3 for 2)
        assertEquals(new BigDecimal("6.00"), actualTotal);
    }

    @Test
    public void basketReturnsTotalWithDiscountZeroIfConditionsNotMet(){
        ThreeForPriceOfTwoDiscount threeForPriceOfTwoDiscount = new ThreeForPriceOfTwoDiscount();
        DiscountProcessor discountProcessor = new DiscountProcessor(threeForPriceOfTwoDiscount);
        final Basket basket = new Basket(discountProcessor);
        List<Item> items = List.of(chocolateBar(), chocolateBar());
        items.forEach(basket::add);

        BigDecimal actualTotal = basket.total();

        assertEquals(new BigDecimal("6.00"), actualTotal);
    }

    private Item chocolateBar() {
        return new ProductByUnit("Chocolate", new BigDecimal("3.00")).oneOf();
    }
}
