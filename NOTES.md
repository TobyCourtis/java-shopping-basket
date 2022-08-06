# Notes

In the given time I have demonstrated my design of the DiscountProcessor, applying multiple Discounts within the shopping Basket.

My design is scalable using the Discount interface. Common discounts can take advantage of my abstract classes (for example a 5 for 3 discount would require two lines of code to implement).

Using dependency injection frameworks, any discount would be found automatically and added to the DiscountProcessor.

## Future Plans and Considerations

- Introduce group of product Discounts (e.g Vegetables):
  - Implement Discount with a class containing a list of items that make up a category
  - Filter by the items contained in that list
  - Apply discount as required
  - This could be built into a current class such as XForPriceOfYDiscount by matching against a list of items (all vegetables) rather than a single item
- Introduce weight discount which verifies the item is an instance of ItemByWeight and gets the weightInKilos to deduce said discount
- Avoid discounts being applied multiple times by refactoring to return a sub list of items from each Discount
- Increase test coverage and quality given there were no time constraints