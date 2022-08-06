package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.ProductByUnit;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XItemsForFixedCostYDiscountTest {

    @Test
    public void twoItemsForOnePoundReturnsExpectedDiscountForTwoItems() {
        // given XItemsForFixedCostYDiscount where X is two, Y is £1 and item name (identifier) provided
        // given items
        XItemsForFixedCostYDiscount twoForOnePound = new XItemsForFixedCostYDiscount("Coke", 2, new BigDecimal(1.00)) {
        };
        List<Item> items = List.of(aCanOfCoke(), aCanOfCoke());

        // when we call applyDiscount()
        BigDecimal actualDiscount = twoForOnePound.applyDiscount(items);

        // then discount is applied
        assertEquals(new BigDecimal("0.6"), actualDiscount);
    }

    @Test
    public void twoItemsForOnePoundReturnsZeroDiscountForNotEnoughItems() {
        XItemsForFixedCostYDiscount twoForOnePound = new XItemsForFixedCostYDiscount("Coke", 2, new BigDecimal(1.00)) {
        };
        List<Item> items = List.of(aCanOfCoke());

        BigDecimal actualDiscount = twoForOnePound.applyDiscount(items);

        assertEquals(new BigDecimal("0.0"), actualDiscount);
    }

    @Test
    public void twoItemsForOnePoundReturnsExpectedDiscountForFourItems() {
        XItemsForFixedCostYDiscount twoForOnePound = new XItemsForFixedCostYDiscount("Coke", 2, new BigDecimal(1.00)) {
        };
        List<Item> items = List.of(aCanOfCoke(),aCanOfCoke(),aCanOfCoke(),aCanOfCoke());

        BigDecimal actualDiscount = twoForOnePound.applyDiscount(items);

        assertEquals(new BigDecimal("1.2"), actualDiscount);
    }

    private Item aCanOfCoke() {
        return new ProductByUnit("Coke", new BigDecimal("0.8")).oneOf();
    }
}