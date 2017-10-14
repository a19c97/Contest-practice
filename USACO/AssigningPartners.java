// 2014 Junior 5
// Success! All tests correct.

import java.util.Scanner;
import java.util.Arrays;

public class AssigningPartners{

   public static void main(String[] args){
      
      Scanner s = new Scanner(System.in);
      
      int N = s.nextInt();
      String[] lineOne = new String[N];
      String[] lineTwo = new String[N];
   
      for (int i=0; i<N; i++)
         lineOne[i] = s.next();
      for (int i=0; i<N; i++)
         lineTwo[i] = s.next();
        
      /* 
      //print out the two arrays 
      System.out.println(Arrays.toString(lineOne));
      System.out.println(Arrays.toString(lineTwo));
        
      System.out.println("paired with self? " + pairedWithSelf(lineOne, lineTwo, N));
      System.out.println("partner correct? " + allCorrect(lineOne, lineTwo, N));
   */
      if (!pairedWithSelf(lineOne, lineTwo, N) 
         && allCorrect(lineOne, lineTwo, N))
         System.out.print("good");
      else 
         System.out.print("bad");   
   }
   
   private static boolean pairedWithSelf (String[] lineOne, String[] lineTwo, int N){
      for (int i=0; i<N;i++){
         if (lineOne[i].equals(lineTwo[i]))
            return true;
      }
      return false;
   }
   
   private static boolean allCorrect (String[] lineOne, String[] lineTwo, int N){
      for (int i=0; i<N;i++){
         for (int j=0; j<N; j++){
            if (lineOne[i].equals(lineTwo[j])){
               if (!lineOne[j].equals(lineTwo[i]))
                  return false;
            }
         }
      }
      return true;
   }

}