package inheritance;

public class Manager extends Employee
{
   // P227
   // the subclass methods can peek inside the protected field of self objects only, not of superclass or other subclass objects.
   // 少使用protected,因为subclass可以直接读取field,如果实现有改变那所以subclass可能都要变
   private double bonus;

   /**
    * @param name the employee's name
    * @param salary the salary
    * @param year the hire year
    * @param month the hire month
    * @param day the hire day
    */
   public Manager(String name, double salary, int year, int month, int day)
   {
      // The call using super must be the first statement in the constructor for the subclass

      // If the subclass constructor does not call a superclass constructor explicitly,
      // the no-argument constructor of the superclass is invoked.
      // If the superclass does not have a no-argument constructor
      // and the subclass constructor does not call another superclass constructor explicitly,
      // the Java compiler reports an error
      super(name, salary, year, month, day);
      bonus = 0;
   }

   /**
    * Override要注意方法的返回类型与父类兼容,并且access权限要不小于父类
    */
   @Override
   public double getSalary()
   {
      // access private field, invoke super method
      double baseSalary = super.getSalary();
      return baseSalary + bonus;
   }

   public void setBonus(double b)
   {
      bonus = b;
   }
}