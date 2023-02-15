public class StaticArray{
    
    public static void main (String[]args){
        String[] strings;
        strings = new String[]{
            "First String",
            "Second String",
            "Thrid String",
            "Fourth String"
        };
        strings[0] = "Replaced Frist String";
        for (int n=0; n<strings.length;n++){
            System.out.println(strings[n]);
        }
    }
}