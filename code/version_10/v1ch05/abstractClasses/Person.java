package abstractClasses;

/**
 * a class with one or more abstract methods must itself be declared abstract
 */
public abstract class Person
{
   public abstract String getDescription();
   private String name;

   public Person(String name)
   {
      this.name = name;
   }

   public String getName()
   {
      return name;
   }
}
