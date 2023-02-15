import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;

//Type - javac MemorablesQuotes12.java
//Type - java MemorablesQuote12 ENTER
//ENTER: Random, All, Search, CSearch, Display, Display delay=num max=num
public class MemorablesQuotes12{

    static ArrayList<String> quotes = new ArrayList<String>();

    static void createQuotes() throws Exception{

          File file = new File("quotes.txt");
          try {
            Scanner input = new Scanner(file);
            while ( input.hasNextLine()) {
              String line = input.nextLine();
            
              quotes.add(line);
            }
            input.close();
          } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
          }

  
          }
          
    public static void updateQuote() {
      try{
      FileWriter file = new FileWriter("quotes.txt");
      BufferedWriter buffer = new BufferedWriter(file);
      for (String str :quotes){
        buffer.write(str);
        buffer.newLine();
      }
      buffer.close();
      } catch (IOException e){
        System.out.println("Error to update Quotes"+ e.getMessage());
      }
  
}
    //GET ALL
    public static void getAllQuotes(){
        for(int i = 0; i < quotes.size(); i++) 
                {
                    String showAll= printQuote(quotes.get(i));
                    System.out.println(showAll);
                }
    }
    //GET RANDOM
    public static void getRandomQuotes() {
            int array = (int)(Math.random() * quotes.size());
                   String showAll = printQuote(quotes.get(array));
                   System.out.println(showAll);

    }

    //SEARCH SPECIFICS
    public static void searchQuotes(String search){
        boolean found = false;

    for (int i = 0; i < quotes.size(); i++) {
        if (quotes.get(i).contains(search)) {
            String showAll = printQuote(quotes.get(i));
            System.out.println(showAll);
            found = true;
        }
    }
    if (!found) {
        System.out.println("No words were found in the term  ' " + search + "'.");
    }
}
    public static void searchContent(String content){
        boolean found = false;

        for (int i =0; i < quotes.size();i++) {
            if (quotes.get(i).contains(content)){
               String showAll = printQuote(quotes.get(i));
               System.out.println(showAll);
                found = true;
            }
        }
        if (!found){
            System.out.println("No contents were found in the term "+ content + ".");
        }
    }

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
          System.out.println("Error: Invalid value for 'max'.");
        }
      } else {
        System.out.println("Error: Invalid parameter '" + args[i] + "'.");
      }
    }

    Map<String, Integer> quoteCount = new HashMap<>();
    int count = 1;
    while (count <= maxQuotes) {
      int array = (int) (Math.random() * quotes.size());
      String quote = quotes.get(array);
      if (quoteCount.containsKey(quote)) {
        quoteCount.put(quote, quoteCount.get(quote) + 1);
      } else {
        quoteCount.put(quote, 1);
      }
      String newQuote = printQuote(quote);
      System.out.println("["+ count  + "/"+ maxQuotes+ "] " + newQuote);
      count++;
      try {
        Thread.sleep(delay);
      } catch (InterruptedException i) {
        System.out.println("Error: " + i);
      }
    }
}

    //CATEGORY
    public static void searchCategory(String category){
        boolean found = false;

        for (int i =0; i < quotes.size();i++) {
            if (quotes.get(i).contains(category)){
                String showAll = printQuote(quotes.get(i));
                System.out.println(showAll);
                found = true;
            }
        }
        if (!found){
            System.out.println("No contents were found in the term "+ category + ".");
        }
    }

        //PRINTING
        static String printQuote(String quote){
            String[] parts = quote.split("@");
            int count = Integer.parseInt(parts[3]);
            int index = quotes.indexOf(quote);
            count += 1;
            quotes.set(index, parts[0] +"@" + parts[1] +"@"+ parts[2] +"@"+ count);
            updateQuote();
            return(parts[0]+"\n\t--" + parts[2] + "/" + count);
        
        }


        //CREATE QUOTES
    public static void main(String[] args) throws Exception {
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
        }else if (args[0].equals("Category")) {
            searchCategory(args[1]);
        }
         else {
            System.out.println("Error: Invalid argument. Please provide either 'Random', 'All', 'Search', 'CSearch', 'Display' and Category as arguments.");
        }
    }
}   