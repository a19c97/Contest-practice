// 2015 Junior 1

import java.util.Scanner;

public class Main{

   public static void main(String[] args){
   
      int feb = 2;
      int eighteen = 18;
      String answer;
      String before = "Before";
      String after = "After";
      String special = "Special";
   
      Scanner scanner = new Scanner(System.in);
      int month = scanner.nextInt();
      int day = scanner.nextInt();
      
      if (month < feb)
         answer = before;
      else if (month > feb)
         answer = after;
      else 
      {
         if (day == eighteen)
            answer = special;
         else if (day > eighteen)
            answer = after;
         else    
            answer = before;
      }
   
      System.out.print(answer);
   }
   
}
