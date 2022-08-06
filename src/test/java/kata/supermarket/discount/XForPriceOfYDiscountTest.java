package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.ProductByUnit;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XForPriceOfYDiscountTest {

    @Test
    public void threeForTwoDiscountReturnsThreeItemsForPriceOfTwoWithSupportedItem(){
        // given XForPriceOfYDiscount with X items required, Y items to be billed for
        // and supported item names
        // given items
        List<Item> items = List.of(aPackOfDigestives(), aPackOfDigestives(), aPackOfDigestives());
        List<String> supportedItemNames = List.of("Digestives");
        XForPriceOfYDiscount threeForTwoDiscount = new XForPriceOfYDiscount(3, 2, supportedItemNames){};

        // when we apply discounts
        BigDecimal actualDiscount = threeForTwoDiscount.applyDiscount(items);

        // then we only pay for two
        assertEquals(new BigDecimal("1.50"), actualDiscount);
    }

    @Test
    public void threeForTwoDiscountReturnsZeroForUnsupportedItem(){
        List<Item> items = List.of(aPackOfDigestives(), aPackOfDigestives(), aPackOfDigestives());
        List<String> supportedItemNames = List.of("Banana");
        XForPriceOfYDiscount threeForTwoDiscount = new XForPriceOfYDiscount(3, 2, supportedItemNames){};

        BigDecimal actualDiscount = threeForTwoDiscount.applyDiscount(items);

        assertEquals(new BigDecimal("0"), actualDiscount);
    }

    @Test
    public void fiveForThreeDiscountReturnsFiveItemsForPriceOfThreeWithSupportedItem(){
        List<Item> items = List.of(aPackOfDigestives(),aPackOfDigestives(), aPackOfDigestives(), aPackOfDigestives(), aPackOfDigestives());
        List<String> supportedItemNames = List.of("Digestives");
        XForPriceOfYDiscount threeForTwoDiscount = new XForPriceOfYDiscount(5, 3, supportedItemNames){};

        BigDecimal actualDiscount = threeForTwoDiscount.applyDiscount(items);

        assertEquals(new BigDecimal("3.00"), actualDiscount);
    }

    private static Item aPackOfDigestives() {
        return new ProductByUnit("Digestives", new BigDecimal("1.50")).oneOf();
    }
}