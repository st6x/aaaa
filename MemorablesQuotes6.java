import java.util.ArrayList;
import java.util.Scanner;
//Type - javac MemorablesQuote6.java
//Type - java MemorablesQuote6 ENTER: Random, All, Search, CSearch
public class MemorablesQuotes6{

    static ArrayList<String> quotes = new ArrayList<String>();

    static void createQuotes(){
        
        quotes.add("The purpose of our lives is to be happy. @Happiness@Dalai Lama");
        quotes.add("Life is what happens when you're busy making other plans. @Life@John Lennon");
        quotes.add("Get busy living or get busy dying. @Work@Stephen King");
        quotes.add("In order to write about life first you must live it. @Life@Ernest Hemingway");
        quotes.add("You only live once, but if you do it right, once is enough. @Choices@Mae West" );
    
    }
    //GET ALL
    public static void getAllQuotes(){
        for(int i = 0; i < quotes.size(); i++) 
                {
                    printQuote(quotes.get(i));
                }
    }
    //GET RANDOM
    public static void getRandomQuotes() {
            int array = (int)(Math.random() * quotes.size());
                    printQuote(quotes.get(array));

    }

    //SEARCH SPECIFICS
    public static void searchQuotes(String search){
        boolean found = false;

    for (int i = 0; i < quotes.size(); i++) {
        if (quotes.get(i).contains(search)) {
            printQuote(quotes.get(i));
            found = true;
        }
    }
    if (!found) {
        System.out.println("No words were found in the term '" + search + "'.");
    }
}
    public static void searchContent(String content){
        boolean found = false;

        for (int i =0; i < quotes.size();i++) {
            if (quotes.get(i).contains(content)){
                printQuote(quotes.get(i));
                found = true;
            }
        }
        if (!found){
            System.out.println("No contents were found in the term"+ content + ".");
        }
    }




        //PRINTING
        static void printQuote(String quote){
            String[] parts = quote.split("@");
            System.out.println(parts[0]);
            System.out.println("--" + parts[2]);
        }
    public static void main(String[] args) {
        createQuotes();
        if (args.length == 0) {
            System.out.println("Error: No argument supplied. Please provide either 'Random', 'All', 'Search' and 'CSearch' as arguments.");
        } else if (args[0].equals("Random")) {
            getRandomQuotes();
        } else if (args[0].equals("All")) {
            getAllQuotes();
        } else if(args[0].equals("Search")){
            searchQuotes(args[1]);
        } else if(args[0].equals("CSearch")){
            searchContent(args[1]);
        } 
         else {
            System.out.println("Error: Invalid argument. Please provide either 'Random', 'All' and 'Search' as arguments.");
        }
    }
}   