import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty name;
    private SimpleIntegerProperty age;
    public Person(String n, int a){ //Constructor
        name=new SimpleStringProperty(n);
        age=new SimpleIntegerProperty(a);
    }
    public String getName(){
        return name.get();
    }//getter
    public int getAge(){
        return age.get();
    }

    public void setName(String n){  //setter
        name.set(n);
    }
    public void setAge(int i){
        age.set(i);
    }


}