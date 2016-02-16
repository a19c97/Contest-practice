/*
ID:Qian Chen
LANG:JAVA
TASK:ride
*/

// Program works fine without file input/output, but gets java.util.NoSuchElementException on UNASCO grader.
// Don't know why

import java.util.*;
import java.io.*;

class ride {
   
   public static void main(String[] args)throws IOException{
      
      BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                 
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
      
      Scanner scanner = new Scanner(f.readLine());
      
      String comet_name = scanner.next();
      String group_name = scanner.next();
      
      comet_name = comet_name.toLowerCase();
      group_name = group_name.toLowerCase();
      
      if (get_number(comet_name)%47 == get_number(group_name)%47)
         out.print("GO");
      else
         out.print("STAY");
         
      out.close();
      System.exit(0);
   
   }
   
   private static int get_number(String name) {
      
      char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
         'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
   
      int number = 1;
      for (int i=0; i<name.length(); i++){
         int index = 0;
         for (int j=0; j<26; j++){
            if (alpha[j] == name.charAt(i))
               index = j + 1;
         }
         number *= index;
      }
      return number;
   }

}