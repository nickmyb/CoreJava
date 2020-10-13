package arrayList;

import java.util.*;

/**
 * This program demonstrates the ArrayList class.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class ArrayListTest
{
   /**
    * 可变参数可以直接接受一个数组
    */
   public static void varargs(String... varargs) {
      System.out.print("varargs = [");
      for (String s: varargs) {
         System.out.print(s + ", ");
      }
      System.out.println("]");
   }

   public static void main(String[] args)
   {
      // fill the staff array list with three Employee objects
      ArrayList<Employee> staff = new ArrayList<>();

      staff.add(new Employee("Carl Cracker", 75000, 1987, 12, 15));
      staff.add(new Employee("Harry Hacker", 50000, 1989, 10, 1));
      staff.add(new Employee("Tony Tester", 40000, 1990, 3, 15));

      // Do not call list.set(i, x) until the size of the array list is larger than i, invoke add first

      // raise everyone's salary by 5%
      for (Employee e : staff)
         e.raiseSalary(5);

      // print out information about all Employee objects
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",salary=" + e.getSalary() + ",hireDay="
               + e.getHireDay());

      Employee[] employeeList = new Employee[staff.size()];
      staff.toArray(employeeList);
      System.out.println("employeeList.length = " + employeeList.length);
      System.out.println("employeeList = " + Arrays.toString(employeeList));

      varargs("a", "b", "c");
      varargs(new String[]{"d", "e", "f"});
   }
}