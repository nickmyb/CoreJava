package exceptional;

import java.util.*;

/**
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 *
 * unchecked exception: Error + RuntimeException
 *
 * 如果finally产生新异常,则会丢失老异常; finally和try都包含return,finally的return会在try的return前执行
 *
 * Try-with-Resources Statement:
 * 正常退出或异常r.close()都会被自动调用
 * try (Resource r1 = . . .; Resource r2 = . . .) {
 *     work with res
 * }
 */
public class ExceptionalTest
{
   public static void main(String[] args)
   {
      int i = 0;
      int ntry = 10000000;
      Stack<String> s = new Stack<>();
      long s1;
      long s2;

      // test a stack for emptiness ntry times
      System.out.println("Testing for empty stack");
      s1 = new Date().getTime();
      for (i = 0; i <= ntry; i++)
         if (!s.empty()) s.pop();
      s2 = new Date().getTime();
      System.out.println((s2 - s1) + " milliseconds");

      // pop an empty stack ntry times and catch the resulting exception
      System.out.println("Catching EmptyStackException");
      s1 = new Date().getTime();
      for (i = 0; i <= ntry; i++)
      {
         try
         {
            s.pop();
         }
         catch (EmptyStackException e)
         {
         }
      }
      s2 = new Date().getTime();
      System.out.println((s2 - s1) + " milliseconds");
   }
}
