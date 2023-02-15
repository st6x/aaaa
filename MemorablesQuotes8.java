import java.util.ArrayList;
import java.util.Scanner;
//Type - javac MemorablesQuotes8.java
//Type - java MemorablesQuote8   ENTER: Random, All, Search, CSearch
public class MemorablesQuotes8{

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

    // //DISPLAY
    // static void showDisplay(String displayString){
    //     while(true){
    //         int array = (int)(Math.random() * quotes.size());
    //         printQuote(quotes.get(array));
    //         try{
    //             Thread.sleep( 3000 );
    //         } catch (InterruptedException i) {
    //             System.out.println("Error: " + i);
    //         }
    //     }
    // }

        //DISPLAY
    private static void showDisplay(String[] args) {
        int delay = 3000;
    int maxQuotes = Integer.MAX_VALUE;
    
    for (int i = 1; i < args.length; i++) {
      if (args[i].startsWith("delay=")) {
        try {
          delay = Integer.parseInt(args[i].substring(6)) * 1000;
        } catch (NumberFormatException e) {
          System.out.println("Error: Invalid value for 'delay'. Using default delay of 3 seconds.");
        }
      } else if (args[i].startsWith("max=")) {
        try {
          maxQuotes = Integer.parseInt(args[i].substring(4));
        } catch (NumberFormatException e) {
          System.out.println("Error: Invalid value for 'max'. Using default value of unlimited.");
        }
      } else {
        System.out.println("Error: Invalid parameter '" + args[i] + "'. Ignoring.");
      }
    }

    int count = 0;
    while (count < maxQuotes) {
      int array = (int) (Math.random() * quotes.size());
      printQuote(quotes.get(array));
      count++;
      try {
        Thread.sleep(delay);
      } catch (InterruptedException i) {
        System.out.println("Error: " + i);
      }
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
            System.out.println("Error: No argument supplied. Please provide either 'Random', 'All', 'Search', 'CSearch' and 'Display' as arguments.");
        } else if (args[0].equals("Random")) {
            getRandomQuotes();
        } else if (args[0].equals("All")) {
            getAllQuotes();
        } else if(args[0].equals("Search")){
            searchQuotes(args[1]);
        } else if(args[0].equals("CSearch")){
            searchContent(args[1]);
        } else if (args[0].equals("Display")) {
            showDisplay(args);
        }
         else {
            System.out.println("Error: Invalid argument. Please provide either 'Random', 'All', 'Search', 'CSearch' and 'Display' as arguments.");
        }
    }
}   