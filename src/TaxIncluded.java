import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TaxIncluded extends Item{
    private double tax= .0825;

    public TaxIncluded(SimpleIntegerProperty itemCode, SimpleStringProperty itemName, SimpleIntegerProperty quantity, double discountedAmount, double price, double tax) {
        super(itemCode, itemName, quantity, discountedAmount, price);
        this.tax = tax;
    }
}
