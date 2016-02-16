import java.util.Scanner;

public class Main{

   public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
   public static int[] vowels = {0,4,8,14,20};

   public static boolean isVowel (char x){
      if (x == 'a' || x == 'e' || x == 'i' ||
         x == 'o' || x == 'u')
         return true;
      else
         return false;
   }

   public static void main(String[] args){
            
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
     
      String output = "";
      
      for (int i=0; i<input.length(); i++){
         char x = input.charAt(i);
         output += x;
         if (!isVowel(x)){
            output += second(x);
            output += third(x);
         }      
      }
      
      System.out.print(output);
   }
   
   public static char second (char x){
      int index = 0;
      for (int i=0; i<alphabet.length; i++){
         if (x == alphabet[i])
            index = i;
      }
      int big = 0;
      int small = 0;
      for (int i=0; i<vowels.length; i++){
         if (index < vowels[i]){
            big = vowels[i];
            small = vowels[i-1];
            break;
         }
      }
      if (index > 20)
         return 'u';
      else if ((big-index)>(index-small))
         return alphabet[small];
      else if ((big-index)<(index-small))
         return alphabet[big];
      else
         return alphabet[small];
   }

   public static char third (char x){
      int index = 0;
      for (int i=0; i<alphabet.length; i++){
         if (x == alphabet[i])
            index = i;
      }
      if (x == 'z')
         return x;
      else if (!isVowel(alphabet[index+1]))
         return alphabet[index+1];
      else
         return alphabet[index+2];
   
   }

   

}