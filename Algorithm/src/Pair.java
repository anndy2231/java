import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Pair {
   public static void main(String args[]) throws Exception {

      System.setIn(new FileInputStream("src/input_0517.txt"));

      Scanner sc = new Scanner(System.in);

      int T = sc.nextInt();
      sc.nextLine();
      
      for(int test_case = 0; test_case < T; test_case++) {
         
         int leftIdx = sc.nextInt();
         int pairNum = 1;
         int rightIdx = 0;
         String[] E = sc.nextLine().split("");
                  
         
         if(E[leftIdx].equals("(")) {
            for(int i = leftIdx + 1; i < E.length ; i++) {
               if(E[i].equals("(")) {
                  pairNum ++;
                  
               } else if(E[i].equals(")")) {
                  pairNum--;
                  if(pairNum == 0) {
                     rightIdx = i;
                     break;
                  }
               }
            }
         }
         else {
            rightIdx = 0;
         }
         
         System.out.println(rightIdx);
      }
      
      
   }
}