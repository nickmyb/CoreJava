package interfaces;

/**
 * 1. Interfaces never have instance fields or static methods(>=Java8 is OK, companion classes is not needed), constants is available
 * 2. All methods in an interface are automatically public, constants(public static final). However, when implementing the interface, you must declare the method as public
 * 3. abstract method of superclass win, conflicts appear in interfaces must be overrided
 */
public class Employee implements Comparable<Employee>
{
   private String name;
   private double salary;

   public Employee(String name, double salary)
   {
      this.name = name;
      this.salary = salary;
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   /**
    * Compares employees by salary
    * @param other another Employee object
    * @return a negative value if this employee has a lower salary than
    * otherObject, 0 if the salaries are the same, a positive value otherwise
    *
    * 1. 使用Double/Integer.compare防止overflow或浮点数计算偏差
    * 2. compare建议与equals一致
    * 3. default
    */
   public int compareTo(Employee other)
   {
      return Double.compare(salary, other.salary);
   }
}