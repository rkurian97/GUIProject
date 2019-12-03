import java.util.*;

public class database {

    public static String [] grocery= {"banana", "apple", "orange", "bread" }; // all the items currently in store
    public static String [] drugs= {"advil", "tylenol", "motrin", "zantac" };
    public static String [] candies= {"skittles", "nerds", "kitkat", "twix" };
    public static String [] sodas= {"fanta", "coke", "sprite", "ginger ale"};
    public static String [] pfood= {"chicken", "turkey", "beef", "salad"};
    public static String [] citems= {"bike", "tv", "computer", "toilet paper" };
    public static HashMap<String, Double> Customer= new HashMap<>(); // creates hash map to store Customer phone numbers paired with their points
    static{
                Customer.put("6308131234", 30.0);       //Customer accounts that can be used for testing
                Customer.put("3316572323", 90.0);
                Customer.put("2134561111", 70.0);
    }
}
