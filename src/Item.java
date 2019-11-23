import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Item {
    private SimpleIntegerProperty itemCode;
    private SimpleStringProperty itemName;
    private SimpleIntegerProperty quantity;
    private double discountedAmount;
    private double price;

    public Item(SimpleIntegerProperty itemCode, SimpleStringProperty itemName, SimpleIntegerProperty quantity, double discountedAmount, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.quantity = quantity;
        this.discountedAmount = discountedAmount;
        this.price = price;
    }

    public int getItemCode() {
        return itemCode.get();
    }

    public int itemCodeProperty() {
        return itemCode.get();
    }

    public String getItemName() {
        return itemName.get();
    }

    public String itemNameProperty() {
        return itemName.get();
    }

    public int getQuantity() {
        return quantity.get();
    }

    public int quantityProperty() {
        return quantity.get();
    }

    public double getDiscountedAmount() {
        return discountedAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setItemCode(int itemCode) {
        this.itemCode.set(itemCode);
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public void setDiscountedAmount(double discountedAmount) {
        this.discountedAmount = discountedAmount;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
