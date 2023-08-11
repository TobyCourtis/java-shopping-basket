package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MealDeal implements Discount {

    private static final BigDecimal MEAL_DEAL_COST = new BigDecimal(5);

    @Override
    public BigDecimal applyDiscount(List<Item> items) {
        List<Item> allSandwiches = items.stream().filter(i -> i.getCategory().equals("SANDWICH")).collect(Collectors.toList());
        List<Item> allSnacks = items.stream().filter(i -> i.getCategory().equals("SNACK")).collect(Collectors.toList());
        List<Item> allDrinks = items.stream().filter(i -> i.getCategory().equals("DRINK")).collect(Collectors.toList());

        int totalMealDeals = IntStream.of(allSandwiches.size(), allSnacks.size(), allDrinks.size()).min().orElse(0);
        BigDecimal totalDiscount = new BigDecimal(0);
        for(int i = 0; i < totalMealDeals; i++){
            BigDecimal specificMealSum = allSandwiches.get(i).price().add(allSnacks.get(i).price()).add(allDrinks.get(i).price());
            totalDiscount = totalDiscount
                    .add(specificMealSum.subtract(MEAL_DEAL_COST));
        }
        return totalDiscount;
    }
}
