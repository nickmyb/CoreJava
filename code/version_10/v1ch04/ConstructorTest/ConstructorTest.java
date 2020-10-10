import java.util.*;

/**
 * This program demonstrates object construction.
 * @version 1.01 2004-02-19
 * @author Cay Horstmann
 */
public class ConstructorTest
{
   public static void main(String[] args)
   {
      // fill the staff array with three Employee objects
      Employee[] staff = new Employee[3];

      staff[0] = new Employee("Harry", 40000);
      staff[1] = new Employee(60000);
      staff[2] = new Employee();

      // print out information about all Employee objects
      for (Employee e : staff)
         System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
               + e.getSalary());
   }
}

/**
 * 1. All data fields are initialized to their default values (0, false, or null).
 * 2. All field initializers and initialization blocks are executed, in the order in which they occur in the class declaration.
 * 3. If the first line of the constructor calls a second constructor, then the body of the second constructor is executed.
 * 4. The body of the constructor is executed.
 */
class Employee
{
   private static int nextId;

   private int id;
   private String name = ""; // instance field initialization
   private double salary;

   // you always place initialization blocks after the field definitions
   // 虽然可以先在initialization blocks赋值后定义,但因为可能导致编译器异常,不建议这么做(P178)

   // static initialization block
   // java7后,需要到使用到类才会执行static initialization block,光有static initialization block没有main是不会调用static initialization block的,也可以是在别的类的main中真实调用到了此类
   static
   {
      Random generator = new Random();
      // set nextId to a random number between 0 and 9999
      nextId = generator.nextInt(10000);
      System.out.println("static initialization block in Employee");
   }

   // object initialization block
   // The initialization block runs first, and then the body of the constructor is executed
   {
      id = nextId;
      nextId++;
      System.out.println("object initialization block in Employee");
   }

   // three overloaded constructors
   public Employee(String n, double s)
   {
      name = n;
      salary = s;
      System.out.println("public Employee(String n, double s)");
   }

   public Employee(double s)
   {
      // Call to 'this()' must be first statement in constructor body
      // calls the Employee(String, double) constructor
      this("Employee #" + nextId, s);
      System.out.println("public Employee(double s)");
   }

   // the default constructor
   public Employee()
   {
      // name initialized to ""--see above
      // salary not explicitly set--initialized to 0
      // id initialized in initialization block
      System.out.println("public Employee()");
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public int getId()
   {
      return id;
   }

   // finalize
   // System.runFinalizersOnExit(true) / Runtime.addShutdownHook
}
