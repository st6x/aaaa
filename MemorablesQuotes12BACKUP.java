import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List;
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
public class MemorablesQuotes12BACKUP{

    static ArrayList<String> quotes = new ArrayList<String>();

    static void createQuotes() throws Exception{
        int num = 1;
        String newPart = ""; // Add a value to newPart
        String[] part = new String[3]; // Correct the format of the part array
        String fileName = "quotes.txt";
        List<String> lines = new ArrayList<>();
        int lineNum = 0;
        String partName = "";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] splitQuote = line.split("@");
                if (lineNum == num -1) {
                    if (part[0] != null) {
                        splitQuote[0] = newPart;
                        partName = "Body";
                    } else if (part[1] != null) {
                        splitQuote[1] = newPart;
                        partName = "Author";
                    } else if (part[2] != null) {
                        splitQuote[2] = newPart;
                        partName = "Genre";
                    }
                    line = splitQuote[0] + "@" + splitQuote[1] + "@" + splitQuote[2] + "@" + splitQuote[3];
                }
                lines.add(line);
                lineNum++;
            }
    
            try (FileWriter fw = new FileWriter(fileName)) {
                for (String l : lines) {
                    fw.write(l + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading/writing to file: " + e.getMessage());
        }
    
        System.out.print("Modified quote at index: " + num + " part: " + partName + " to " + newPart + "\n");
    }

  
          
          

        // quotes.add("The purpose of our lives is to be happy. @Happiness@Dalai Lama");
        // quotes.add("Life is what happens when you're busy making other plans. @Life@John Lennon");
        // quotes.add("Get busy living or get busy dying. @Work@Stephen King");
        // quotes.add("In order to write about life first you must live it. @Life@Ernest Hemingway");
        // quotes.add("You only live once, but if you do it right, once is enough. @Choices@Mae West" );
    
    
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