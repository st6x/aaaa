import java.util.ArrayList;
import java.util.LinkedList;

public class MemorablesQuotes1{

    public static void main(String[] args) {
        ArrayList<String> quotes = new ArrayList<String>();
        quotes.add("The purpose of our lives is to be happy. by Dalai Lama #1");
        quotes.add("Life is what happens when you're busy making other plans. by John Lennon #2");
        quotes.add("Get busy living or get busy dying. by Stephen King #3");
        quotes.add( "In order to write about life first you must live it. by Ernest Hemingway #4");
        quotes.add("You only live once, but if you do it right, once is enough. by Mae West #5" );

        for(int i = 4; i < quotes.size(); i++) 
        {
            int array = (int)(Math.random() * quotes.size());
  
            System.out.println("Your Random Quotes is: \n" + quotes.get(array));
        }
    }

}