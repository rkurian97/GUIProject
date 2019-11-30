import java.util.*;

public class database {
    public static List<String> grocery= new ArrayList<String>();
    public static List<String> drugs= new ArrayList<String>();
    public static List<String> candies= new ArrayList<String>();
    public static List<String> sodas= new ArrayList<String>();
    public static List<String> pfood= new ArrayList<String>();
    public static List<String> citems= new ArrayList<String>();

        public database(){
            grocery.add(0,"bananas");
            grocery.add(1,"apples");
            grocery.add(2,"oranges");
            grocery.add(3,"bread");

            drugs.add(0,"advil");
            drugs.add(1,"tylenol");
            drugs.add(2,"motrin");
            drugs.add(3,"zantac");

            candies.add(0,"skittles");
            candies.add(1,"nerds");
            candies.add(2,"kitkat");
            candies.add(3,"twix");

            sodas.add(0,"fanta");
            sodas.add(1,"coke");
            sodas.add(2,"sprite");
            sodas.add(3,"ginger ale");

            pfood.add(0,"chicken");
            pfood.add(1,"turkey");
            pfood.add(2,"beef");
            pfood.add(3,"salad");

            citems.add(0,"bike");
            citems.add(1,"tv");
            citems.add(2,"computer");
            citems.add(3,"toilet paper");
        }
}
