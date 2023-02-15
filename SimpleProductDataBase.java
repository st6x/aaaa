import java.util.ArrayList;

public class SimpleProductDataBase{

    public static void main(String[] args) {
        ArrayList<String> drinks = new ArrayList<>();
        drinks.add("Latte: PHP 100");
        drinks.add("Cappucino: PHP 200");
        drinks.add("Mocha: PHP 300");
        drinks.add("Espresso: PHP 400");

        for (int i = 0; i < drinks.size(); i++){
            String[] arrayOfStrings = drinks.get(i).split(":");
            System.out.println(" Drinks " + arrayOfStrings[0] + " Prices: " + arrayOfStrings[1]);
        }
    }
}