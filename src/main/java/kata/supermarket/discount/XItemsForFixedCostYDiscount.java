package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public abstract class XItemsForFixedCostYDiscount implements Discount {

    private final String name;
    private final int numberOfItemsToApplyDiscount;
    private final BigDecimal discountedAmount;

    public XItemsForFixedCostYDiscount(String name, int numberOfItemsToApplyDiscount, BigDecimal discountedAmount) {
        this.name = name;
        this.numberOfItemsToApplyDiscount = numberOfItemsToApplyDiscount;
        this.discountedAmount = discountedAmount;
    }

    @Override
    public BigDecimal applyDiscount(List<Item> items){

        List<Item> filteredItems = items.stream().filter(i -> i.getName().equals(name)).collect(Collectors.toList());

        if(filteredItems.size() == 0){
            return new BigDecimal(0);
        } else {
            return calculateDiscount(items);
        }
    }

    private BigDecimal calculateDiscount(List<Item> items) {
        int numberOfSpecifiedItem = items.size();
        BigDecimal costPerItem = items.get(0).price();

        int timesToApplyDiscount = numberOfSpecifiedItem / numberOfItemsToApplyDiscount;
        return new BigDecimal(timesToApplyDiscount)
                .multiply((costPerItem.multiply(new BigDecimal(numberOfItemsToApplyDiscount))).subtract(discountedAmount));
    }
}
