import java.util.*;
       
       public class pat{
       
       public static void main(String[] args) {
           Scanner scn = new Scanner(System.in);
            int n =scn.nextInt();
            int nst=1;
            for(int row=1;row<=n;row++)
            {
                for(int cst=1;cst<=nst;cst++)
                {
                    System.out.print("*");
                }
                System.out.println("");
            }
            nst++;
            // write ur code here
       
        }
       }