// 不在 java.lang 中的类都需要 import
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;

/**
 * This program demonstrates console input.
 * @version 1.10 2004-02-10
 * @author Cay Horstmann
 */
public class InputTest
{
   public static void main(String[] args)
   {
      /*
      Scanner in = new Scanner(System.in);

      // get first input
      System.out.print("What is your name? ");
      String name = in.nextLine();

      // get second input
      System.out.print("How old are you? ");
      int age = in.nextInt();

      // display output on console
      System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
      */

      Scanner in = new Scanner(System.in);
      System.out.println("in.nextLine(): input contain spaces");
      String nextLine = in.nextLine();
      System.out.println("nextLine = \"" + nextLine + "\"");
      System.out.println("in.next(): a single word (delimited by whitespace)");
      String nextWord = in.next();
      System.out.println("nextWord = \"" + nextWord + "\"");
      System.out.println();

      String workingDirectory = System.getProperty("user.dir");
      System.out.println("working directory = " + workingDirectory);
      try {
         PrintWriter out = new PrintWriter("InputTest.txt", "UTF-8");
         out.println("Input");
         out.println("Test");
         out.close();
         in = new Scanner(Paths.get("InputTest.txt"), "UTF-8");
         System.out.println("InputTest.txt Line1: " + in.nextLine());
         System.out.println("InputTest.txt Line2: " + in.nextLine());
      } catch (Exception e) {
         System.out.println("Exception[InputTest.txt]: " + e);
      }

      // 需要用Path对象,如果是字符串则直接将字符串作为数据读入
      in = new Scanner("helloworld");
      System.out.println("\"helloworld\" next: " + in.next());
   }
}
