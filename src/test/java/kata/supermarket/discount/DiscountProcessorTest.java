package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.ProductByUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DiscountProcessorTest {

    @Mock
    Discount discount1;

    @Mock
    Discount discount2;

    @Test
    public void discountProcessorWithDiscountsAppliesAllDiscounts() {
        // given discount processor
        // given discounts
        // given items
        List<Item> items = List.of(aCanOfCoke());
        DiscountProcessor victim = new DiscountProcessor(discount1, discount2);
        Mockito.when(discount1.applyDiscount(items)).thenReturn(new BigDecimal(3.00));
        Mockito.when(discount2.applyDiscount(items)).thenReturn(new BigDecimal(4.00));

        // when we call apply discount with items
        BigDecimal actualTotalDiscounts = victim.applyAllDiscounts(items);

        // then we get a total discount
        assertEquals(new BigDecimal(7), actualTotalDiscounts);
    }

    @Test
    public void discountProcessorWithNoDiscountsReturnsZero() {
        List<Item> items = List.of(aCanOfCoke());
        DiscountProcessor victim = new DiscountProcessor();

        BigDecimal actualTotalDiscounts = victim.applyAllDiscounts(items);

        assertEquals(new BigDecimal(0), actualTotalDiscounts);
    }

    private Item aCanOfCoke() {
        return new ProductByUnit("Coke", new BigDecimal("2.00")).oneOf();
    }
}