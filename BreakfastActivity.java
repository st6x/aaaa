import java.util.*;
public class BreakfastActivity {

  static Scanner titles = new Scanner(System.in);

  public static void main(String[] args) {
    
    String display;
    ArrayList<String> test1 = new ArrayList<String>();
    test1.add("Book 1");
    test1.add("Book 2");
    test1.add("Book 3");
    test1.add("Book 4");
    test1.add("Book 5");
    test1.add("Book 6");
    test1.add("Book 7");
    test1.add("Book 8");
    test1.add("Book 9");
    test1.add("Book 10");
  
    boolean display1 = true;
    while (display1){
      
      System.out.println("\n What option are you trying to use? \n");
      System.out.print(" ||| display ||| ascending ||| descending ||| count ||| search \n");
      System.out.print("Enter text below: \n");
      String arrayList= titles.nextLine();  

    switch(arrayList){
        case "display":
          System.out.println(" Display ");
          for(String i: test1){
          System.out.println(i);
          }
          break;

        case "ascending":
          System.out.println(" Sort Ascending ");
          Collections.sort(test1);
          for(String i: test1){
          System.out.println(i);
          }
          break;
          
        case "descending":
          System.out.println(" Sort Descending ");
          Collections.sort(test1,Collections.reverseOrder());
          for(String i: test1){
          System.out.println(i);
          }
          break;

        case "count":
          System.out.println(" Count ");
          System.out.println(test1.size());
          break;

        case "search":
          int show = 0;
          System.out.println(" Search ");
          for (String i:test1)
          {
            System.out.println(i);
            show++;
          }
          System.out.println(show);
          break;
          
          default:

      }
      System.out.println("Do you want to Continue? PLEASE USE UPPERCASE(YES/NO)");
      String choice = titles.nextLine();
      System.out.println(choice);
      if(choice.equals("NO")){
        display1 = false;

    } else{
      
      display1 = true;
    }
    
  }
}
}