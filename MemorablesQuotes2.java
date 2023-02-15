import java.util.ArrayList;
import java.util.Random;

public class MemorablesQuotes2{
    static ArrayList<String> quotes = new ArrayList<String>();

    static void createQuotes(){
    
    quotes.add("The purpose of our lives is to be happy. by Dalai Lama #1");
    quotes.add("Life is what happens when you're busy making other plans. by John Lennon #2");
    quotes.add("Get busy living or get busy dying. by Stephen King #3");
    quotes.add( "In order to write about life first you must live it. by Ernest Hemingway #4");
    quotes.add("You only live once, but if you do it right, once is enough. by Mae West #5" );

}
    public static String getRandomQuotes() {
        Random quote = new Random();
        int index = quote.nextInt(quotes.size());
        return quotes.get(index);
    }
    public static void main(String[] args) {
        createQuotes();
        String getQuote = getRandomQuotes();
        System.out.println(getQuote);
    }
    
}