import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Item {
    private int itemCode;
    private String itemName;
    private int quantity;
    private double discount;
    private double price;
    private double taxable;


    public Item(int itemCode, String itemName, int quantity, double discount, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.quantity = quantity;
        this.discount = discount;
        this.price = price;
        if (database.grocery.contains(itemName) || database.drugs.contains(itemName) ){
                this.taxable= 8.50;
        }
        else if(database.candies.contains(itemName) ||database.sodas.contains(itemName) || database.pfood.contains(itemName)  || database.citems.contains(itemName) ){
                this.taxable= 1;
        }
        else{
             this.taxable= 0;
        }

    }
        public int getItemCode () {
            return itemCode;
        }

        public String getItemName () {
            return itemName;
        }

        public int getQuantity () {
            return quantity;
        }

        public double getDiscount () {
            return discount;
        }

        public double getPrice () {
            return price;
        }

        public void setItemCode ( int itemCode){
            this.itemCode = itemCode;
        }

        public void setItemName (String itemName){
            this.itemName = itemName;
        }

        public void setQuantity ( int quantity){
            this.quantity = quantity;
        }

        public void setDiscount ( double discount){
            this.discount = discount;
        }

        public void setPrice ( double price){
            this.price = price;
        }
}
