// To place classes inside a package, you must put the name of the package at the top of your source file, before the code that defines the classes in the package
// If you don’t put a package statement in the source file, then the classes in that source file belong to the default package
// java文件放置在和包名相同的文件结构下
// javac x/y/className.java
// java x.y.className
package com.horstmann.corejava;

// the classes in this file are part of this package
// you can only use the * notation to import a single package
// 类名冲突的时候添加一句import语句(import x.y.ClassName;),或者使用完整类名
import java.time.*;

// import static methods and fields
// import static x.y.className.*;

// import statements come after the package statement

// From the point of view of the compiler, there is absolutely no relationship between nested packages(java.util & java.util.jar)

// javac会默认寻找.,java需要手动添加.到classpath
// /home/user/classdir:.:/home/user/archives/archive.jar
// /home/user/classdir:.:/home/user/archives/'*'

// java -classpath(-cp) /home/user/classdir:.:/home/user/archives/archive.jar MyProg

/**
 * @version 1.11 2015-05-08
 * @author Cay Horstmann
 *
 * class design hint:
 * 1. Always keep data private.
 * 2. Always initialize data.
 * 3. Don’t use too many basic types in a class.
 * 4. Not all fields need individual field accessors and mutators.
 * 5. Break up classes that have too many responsibilities.
 * 6. Make the names of your classes and methods reflect their responsibilities.
 * 7. Prefer immutable classes
 */
public class Employee
{
   private String name;
   private double salary;
   private LocalDate hireDay;

   public Employee(String name, double salary, int year, int month, int day)
   {
      this.name = name;
      this.salary = salary;
      hireDay = LocalDate.of(year, month, day);
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public LocalDate getHireDay()
   {
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
}
