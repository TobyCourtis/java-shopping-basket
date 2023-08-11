package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public abstract class XForPriceOfYDiscount implements Discount {

    private final int numberOfItemsRequired;
    private final int numberOfItemsToPayFor;
    private final List<String> supportedItemNames;

    public XForPriceOfYDiscount(int numberOfItemsRequired, int numberOfItemsToPayFor, List<String> supportedItemNames){
        this.numberOfItemsRequired = numberOfItemsRequired;
        this.numberOfItemsToPayFor = numberOfItemsToPayFor;
        this.supportedItemNames = supportedItemNames;
    }

    @Override
    public BigDecimal applyDiscount(List<Item> items) {
        BigDecimal totalDiscount = new BigDecimal(0);

        for(String supportedItemName : supportedItemNames){
            List<Item> specificItems = items.stream()
                    .filter(i -> i.getName().equals(supportedItemName))
                    .collect(Collectors.toList());

            if(specificItems.size() > 0){
                totalDiscount = calculateDiscount(totalDiscount, specificItems);
            }
        }
        return totalDiscount;
    }

    private BigDecimal calculateDiscount(BigDecimal totalDiscount, List<Item> specificItems) {
        BigDecimal itemCost = specificItems.get(0).price();

        long timesToApplyDiscount = (specificItems.size() / numberOfItemsRequired);

        BigDecimal discount = new BigDecimal(timesToApplyDiscount)
                .multiply(new BigDecimal(numberOfItemsRequired - numberOfItemsToPayFor).multiply(itemCost));
        return totalDiscount.add(discount);
    }
}
