import java.util.Scanner;

public class Main{

   public static void main(String[] args){
   
      int happy = 0, sad = 0;
   
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      
      for (int i = 0; i < input.length()- 2; i++){
         if (input.charAt(i) == ':'&& 
            input.charAt(i+1) == '-' &&
            input.charAt(i+2) == ')'
            )
            happy++;
         if (input.charAt(i) == ':'&& 
            input.charAt(i+1) == '-' &&
            input.charAt(i+2) == '(')
         
            sad++;
      }
      
      if (happy == 0 && sad == 0)   
         System.out.print("none");
      else if (happy > sad)
         System.out.print("happy");
      else if (happy < sad)
         System.out.print("sad");
      else
         System.out.print("unsure");
   
   }
   
}
   
