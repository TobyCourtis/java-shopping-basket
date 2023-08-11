package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.ProductByUnit;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MealDealTest {


    @Test
    public void aMealInItemsListAppliesDiscountCorrectly(){
        // given victim MealDeal
        // given items with categories sandwich, snack, drink
        List<Item> items = List.of(aSandwich(), aSnack(), aDrink());
        MealDeal victim = new MealDeal();


        // when we apply
        BigDecimal actualDiscount = victim.applyDiscount(items);

        // then discount = Sum - mealDealPrice
        assertEquals(new BigDecimal("4"), actualDiscount);
    }

    @Test
    public void mealDealDisocuntIsAppliedMultipleTimesWithMultipleMeals(){
        List<Item> items = List.of(aSandwich(), aSnack(), aDrink(), aSandwich(), aSnack(), aDrink(), aDrink(), aDrink());
        MealDeal victim = new MealDeal();

        BigDecimal actualDiscount = victim.applyDiscount(items);

        assertEquals(new BigDecimal("8"), actualDiscount);
    }

    @Test
    public void mealDealDiscountAppliedWithVariedPriceSandwich(){
        List<Item> items = List.of(aSandwich(), aSnack(), aDrink(), aWaitroseSandwich(), aSnack(), aDrink(), aDrink(), aDrink());
        MealDeal victim = new MealDeal();

        BigDecimal actualDiscount = victim.applyDiscount(items);

        assertEquals(new BigDecimal("305"), actualDiscount);
    }

    private Item aSandwich() {
        return new ProductByUnit("BLT", new BigDecimal("3"), "SANDWICH").oneOf();
    }

    private Item aWaitroseSandwich() {
        return new ProductByUnit("Waitrose BLT", new BigDecimal("300"), "SANDWICH").oneOf();
    }

    private Item aSnack() {
        return new ProductByUnit("Quavers", new BigDecimal("4"), "SNACK").oneOf();
    }

    private Item aDrink() {
        return new ProductByUnit("Coke", new BigDecimal("2"), "DRINK").oneOf();
    }
}