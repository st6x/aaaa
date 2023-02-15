import java.util.ArrayList;
import java.util.Scanner;

public class MemorablesQuotes4{

    static ArrayList<String> quotes = new ArrayList<String>();

    static void createQuotes(){
    
        quotes.add("The purpose of our lives is to be happy. @Happiness@Dalai Lama");
        quotes.add("Life is what happens when you're busy making other plans. @Life@John Lennon");
        quotes.add("Get busy living or get busy dying. @Work@Stephen King");
        quotes.add("In order to write about life first you must live it. @Life@Ernest Hemingway");
        quotes.add("You only live once, but if you do it right, once is enough. @Choices@Mae West" );
    
    }

    public static void getAllQuotes(){
        for(int i = 0; i < quotes.size(); i++) 
                {
                    printQuote(quotes.get(i));
                }
    }

    public static void getRandomQuotes() {

                int array = (int)(Math.random() * quotes.size());
                printQuote(quotes.get(array));

    }
        static void printQuote(String quote){
            String[] parts = quote.split("@");
            System.out.println(parts[0]);
            System.out.println("--" + parts[2]);
        }
    public static void main(String[] args) {
        createQuotes();
        if (args.length == 0) {
            System.out.println("Error: No argument supplied. Please provide either 'Random' or 'All' as arguments.");
        } else if (args[0].equals("Random")) {
            getRandomQuotes();
        } else if (args[0].equals("All")) {
            getAllQuotes();
        } else {
            System.out.println("Error: Invalid argument. Please provide either 'Random' or 'All' as arguments.");
        }
    }
}