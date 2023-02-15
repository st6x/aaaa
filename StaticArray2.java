import java.util.*;
public class StaticArray2{
    
    public static void main (String[]args){
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Choose: \n Reverse \n Normal \n");
    String output= input.nextLine(); 
        
    String[] strings;
    strings = new String[]{
            "First String",
            "Second String",
            "Third String",
            "Foruth String"
            };
        
    switch(output){
        case "Normal":
        for(int i=0;i<strings.length;i++)
         System.out.print(strings[i] + "  ");

        break;

        case "Reverse":
        for(int i=strings.length-1;i>=0;i--)
         System.out.print(strings[i] + "  ");

        break;

        default: 
        System.out.println("Error");
        break;
        }
    }
}

