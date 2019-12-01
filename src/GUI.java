import javafx.application.Application;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.*;

import java.util.concurrent.atomic.AtomicBoolean;
public class GUI extends Application {
    private BorderPane bp = new BorderPane();
    private  GridPane g1 = new GridPane();
    private GridPane g2 = new GridPane();
    private FlowPane fp = new FlowPane();
    private VBox vb1 = new VBox();
    private VBox vb2 = new VBox();
    private VBox vb3 = new VBox();

    // ObservableList is a list that enables listeners to track changes when they occur
    private ObservableList<Item> data;

    public void start(Stage s) {
        TableView<Item> tbl; //table view to store person objects
        tbl = new TableView<>();
        Alert alerts = new Alert(Alert.AlertType.INFORMATION); //success message
        Alert alerte = new Alert(Alert.AlertType.ERROR); //Error message
        Scene sc1, sc2, sc3, sc4; // scenes
        sc1 = new Scene(new Group()); // main scene
        s.sizeToScene();  //setting stage to size acording the scene sizes

        //top pane in the main scene
        Button b2 = new Button("New");
        Button b3 = new Button("Update");
        Button b4 = new Button("Remove");
        Button b5= new Button("Print");
        fp.getChildren().addAll(b2, b3, b4, b5); // menubar


        //Right Pane with a title and tableview

       /* FXCollections is A utility class that consists of static methods
        that are one-to-one copies of java.util.Collections methods */

        data = FXCollections.observableArrayList();
        s.setWidth(300);
        s.setHeight(500);
        final Label l1 = new Label("Grocery List");
        l1.setFont(new Font("Arial", 20));
        //Column1
        TableColumn itemcol = new TableColumn("Item Code");
        itemcol.setMinWidth(10);
       /* A TableColumn must have a cell value factory set on it.
       The cell value factory extracts the value to be displayed in each cell
       (on each row) in the column.
        The PropertyValueFactory factory can extract a property value (field value) from a Java object.
        The name of the property is passed as a parameter to the PropertyValueFactory constructor
        */
        itemcol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("ItemCode"));

        /*The property name "name" will match the getter method getName() of the Person
        objects which returns the name values and are displayed on each row.
         */
        //Column2
        TableColumn namecol = new TableColumn("Item Name");
        namecol.setMinWidth(10);
        namecol.setCellValueFactory(new PropertyValueFactory<Item, String>("ItemName"));

        TableColumn qtycol = new TableColumn("Quantity");
        qtycol.setMinWidth(10);
        qtycol.setCellValueFactory(new PropertyValueFactory<Item, Integer>("Quantity"));

        TableColumn dscol= new TableColumn("Discount");
        dscol.setMinWidth(10);
        dscol.setCellValueFactory(new PropertyValueFactory<Item, Double>("Discount"));

        TableColumn pccol= new TableColumn("Price");
        pccol.setMinWidth(10);
        pccol.setCellValueFactory(new PropertyValueFactory<Item, Double>("Price"));


        tbl.setEditable(true);
        tbl.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY );
        tbl.setItems(data);// table items are getting populated from observable list
        tbl.getColumns().addAll(itemcol, namecol, qtycol, dscol, pccol); // adding columns to table
        vb1.getChildren().addAll(l1, tbl);

        //Left pane with a gridpane and a add button

        Label ln = new Label();
        ln.setText("Item code");
        Label l2 = new Label();
        l2.setText("Item Name");
        Label l3 = new Label();
        l3.setText("Quantity");
        Label l4 = new Label();
        l4.setText("Discount");
        Label l5 = new Label();
        l5.setText("Price");

        TextField tn = new TextField();
        TextField ta = new TextField();
        TextField tb = new TextField();
        TextField tc = new TextField();
        TextField td = new TextField();

        Button b1 = new Button("Add");

        g1.add(ln, 0, 0);
        g1.add(tn, 1, 0);
        g1.add(l2, 0, 1);
        g1.add(ta, 1, 1);
        g1.add(l3, 0, 2);
        g1.add(tb, 1, 2);
        g1.add(l4, 0, 3);
        g1.add(tc, 1, 3);
        g1.add(l5, 0, 4);
        g1.add(td, 1, 4);

        g1.setPadding(new Insets(10, 10, 10, 10));
        g1.setHgap(10);
        g1.setVgap(10);
        vb2.setSpacing(5);
        vb2.setPadding(new Insets(5, 5, 5,5));
        vb2.getChildren().addAll(g1, b1);
        vb2.setVisible(false);
        bp.setPadding(new Insets(10, 10, 10, 10));
        bp.setLeft(vb2);
        bp.setRight(vb1);
        bp.setTop(fp);

        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                vb2.setVisible(true); // clicking the new button makes left-side pane visible
            }
        };
        b2.setOnAction(event1);
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { //clicking add button causes the data enetred in the grid pane
                boolean fa= false;
                Item c= new Item(Integer.parseInt(tn.getText()), ta.getText(), Integer.parseInt(tb.getText()), Double.parseDouble(tc.getText()), Double.parseDouble(td.getText()));
                if (c.getTaxable()!=0) {
                    data.add(c);  //to be populated in the Table view
                    fa=true;
                }                 // add() method appends to list.
                                    // it is method a declared in the java.util.List interface that was inherited by ObservableList interface

                if (fa) {
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Item in Store!");
                    alerts.showAndWait();
                }

                else {
                    alerte.setTitle("Error");
                    alerte.setHeaderText(null);
                    alerte.setContentText("Item not in Store");
                    alerte.showAndWait();
                }
                tn.clear();
                ta.clear();
                tb.clear();
                tc.clear();
                td.clear();
            }
        };
        b1.setOnAction(event2);

        ((Group) sc1.getRoot()).getChildren().add(bp);  //Borderpane is added to the scene
        //sc1= new Scene(bp);
        s.setScene(sc1);
        s.show();
        //*************************************************************************
        //Scene2
        //modify  scene to modify the age given a name
        Label ul2 = new Label("Enter Item Name");
        ul2.setFont(new Font("Courier", 14));
        Label ln2 = new Label("Item Name");
        Label l22 = new Label("Quantity");
        Label l32= new Label ("Price");
        TextField tn2 = new TextField();
        TextField ta2 = new TextField();
        TextField tb2= new TextField();
        Button b12 = new Button("Update");
        g2.add(ln2, 0, 0);
        g2.add(tn2, 1, 0);
        g2.add(l22, 0, 1);
        g2.add(ta2, 1, 1);
        g2.add(l32, 0, 2);
        g2.add(tb2, 1, 2);
        Label lu= new Label();
        g2.setPadding(new Insets(10, 10, 10, 10));
        g2.setHgap(10);
        g2.setVgap(10);
        vb3.getChildren().addAll(ul2, g2, b12, lu);
        vb3.setSpacing(10);
        vb3.setPadding(new Insets(10, 10, 10, 10));
        EventHandler<ActionEvent> event22 = new EventHandler<ActionEvent>() {
            @Override
               /* When the button was clicked, the record with the name that matches with the name  entered in the
               textfield (tn2) will be updated */
            public void handle(ActionEvent event) {
                String sid = tn2.getText();
                boolean f=false;
                for (int i = 0; i < tbl.getItems().size(); i++) {
                    if (((String)tbl.getItems().get(i).getItemName()).equals(sid)) {
                        Item p = new Item(tbl.getItems().get(i).getItemCode(), tbl.getItems().get(i).getItemName(), Integer.parseInt(ta2.getText()), tbl.getItems().get(i).getDiscount(), Double.parseDouble(tb2.getText()) );
                        tbl.getItems().set(i, p); //inserts the Person object at index i
                        f=true;
                    }
                }
                if (f) {
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Update Successful!");
                    alerts.showAndWait();
                }

                else {
                    alerte.setTitle("Error");
                    alerte.setHeaderText(null);
                    alerte.setContentText("Entered Item Name not found..");
                    alerte.showAndWait();
                }
                tn2.clear();
                ta2.clear();
                tb2.clear();
                s.setScene(sc1); //after modification going back to scene1
            }
        };
        b12.setOnAction(event22); // update button

        sc2 = new Scene(vb3, 400, 200);
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                s.setScene(sc2); //Clicking the update button causes scene 2
            }
        };
        b3.setOnAction(event3);  // Modify  button
        //*********************************************************************************
        //Scene 3
        // delete a row in the table view
        VBox vb4= new VBox();
        Label rl= new Label("Enter the Item name to remove");
        TextField tr= new TextField();
        Button dl= new Button("Delete");
        vb4.getChildren().addAll(rl, tr, dl);
        vb4.setPadding(new Insets(10, 10, 10, 10));
        vb4.setSpacing(10);
        sc3= new Scene(vb4, 300, 200);

        EventHandler<ActionEvent> event23 = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String sid = tr.getText();
                boolean df =false;
                for (int i = 0; i < tbl.getItems().size(); i++) {
                    if (((String)tbl.getItems().get(i).getItemName()).equals(sid)) {
                        tbl.getItems().remove(i); //removes the record at index i
                        df=true;
                    }
                }
                if (df){
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Deletion Successful!");
                    alerts.showAndWait();
                }

                else {
                    alerte.setTitle("Error");
                    alerte.setHeaderText(null);
                    alerte.setContentText("Entered Item Name not found..");
                    alerte.showAndWait();
                }
                tr.clear();
                s.setScene(sc1); //after deletion going back to scene1

            }
        };
        dl.setOnAction(event23); //

        EventHandler<ActionEvent> event4 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                s.setScene(sc3);
            }
        };
        b4.setOnAction(event4); // Remove button

        //*********************************************************************************
        //Scene 4 Print and Add Phone number
        VBox vb5= new VBox();
        Label lq= new Label("Enter Phone Number");
        TextField tq= new TextField();
        Button dq= new Button("Print Bill");
        vb5.getChildren().addAll(lq, tq, dq);
        vb5.setPadding(new Insets(10, 10, 10, 10));
        vb5.setSpacing(10);
        sc4= new Scene(vb5, 300, 200);

        EventHandler<ActionEvent> event24 = new EventHandler<ActionEvent>() {  // when clicking Check and Print
            @Override
            public void handle(ActionEvent event) {
                double subtotal=0;
                double savings=0;
                double tax_amt=0;
                double total=0;
                boolean dz =false;
                if (tbl.getItems().size()>=1){
                     dz=true;
                }
                for (int i = 0; i < tbl.getItems().size(); i++) {
                        subtotal= tbl.getItems().get(i).getPrice()*tbl.getItems().get(i).getQuantity()+subtotal;
                        savings= tbl.getItems().get(i).calcDiscount()+savings;
                        tax_amt= tbl.getItems().get(i).calcTax()+tax_amt;
                    }
                total=subtotal-savings+tax_amt;
                System.out.printf("Subtotal: %.2f\n", subtotal);
                System.out.printf("Savings: %.2f\n", savings);
                System.out.printf("Tax Amount: %.2f\n", tax_amt);
                System.out.printf("Total: %.2f\n", total);
                if(dz){
                    alerts.setTitle("Success");
                    alerts.setHeaderText(null);
                    alerts.setContentText("Printed Results to Console");
                    alerts.showAndWait();
                }

                else {
                    alerte.setTitle("Error");
                    alerte.setHeaderText(null);
                    alerte.setContentText("No items entered");
                    alerte.showAndWait();
                }
                tq.clear();
                s.setScene(sc1); //after printing going back to scene1

            }
        };
        dq.setOnAction(event24);
        EventHandler<ActionEvent> event5 = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                s.setScene(sc4);
            }
        };
        b5.setOnAction(event5); // Remove button
    } //end of start

    public static void main (String[]args){
        launch(args);
    }

}
