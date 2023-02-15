import java.util.ArrayList;
import java.util.Scanner;

public class MemorablesQuotes3{

    static ArrayList<String> quotes = new ArrayList<String>();
    
    static void createQuotes(){

        quotes.add("The purpose of our lives is to be happy. by Dalai Lama #1");
        quotes.add("Life is what happens when you're busy making other plans. by John Lennon #2");
        quotes.add("Get busy living or get busy dying. by Stephen King #3");
        quotes.add("In order to write about life first you must live it. by Ernest Hemingway #4");
        quotes.add("You only live once, but if you do it right, once is enough. by Mae West #5" );

    }

    public static void getRandomQuotes() {

        Scanner showAnswer = new Scanner(System.in);
        System.out.println("Choose one from the following: \n Random or All");
        String answer = showAnswer.nextLine();

        switch(answer){
            case "Random":
                int array = (int)(Math.random() * quotes.size());
                System.out.println("Random Quote is: \n" + quotes.get(array));
                break;
            case "All":
                for(int i = 0; i < quotes.size(); i++) 
                {
                    System.out.println("Quote " + (i + 1) + ": " + quotes.get(i));
                }
                break;
            default:
                System.out.println("Error: Invalid Input. Please try again.");
                break;
        }
    }
    
    public static void main(String[] args) {
        createQuotes();
        getRandomQuotes();
    }
    
}
