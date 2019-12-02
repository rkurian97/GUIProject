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
        for (int i=0; i<4; i++) {
            if (this.itemName.equals(database.drugs[i]) || this.itemName.equals(database.grocery[i])){
                this.taxable= 1;
                break;
            }
            else if(this.itemName.equals(database.candies[i]) || this.itemName.equals(database.sodas[i]) || this.itemName.equals(database.pfood[i])  || this.itemName.equals(database.citems[i])){
                this.taxable=.0825;
                break;
            }
            else{
                this.taxable=0;     // so that i can make a condition if taxable is 0 then item is not in store
            }
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
        public double getTaxable(){
        return taxable;
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
        public double calcDiscount(){
            if (discount!=0){
                return price*quantity*discount/100;
            }
            else{
                return 0.0;
            }
        }
        public double calcTax(){
            if (taxable==.0825)
                return ((price*quantity-calcDiscount())*taxable);
            else
                return 0.0;
        }

}
