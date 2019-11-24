
public class TaxIncluded extends Item{
    private double tax= .0825;

    public TaxIncluded(int itemCode, String itemName, int quantity, double discountedAmount, double price, double tax) {
        super(itemCode, itemName, quantity, discountedAmount, price);
        this.tax = tax;
    }
}
