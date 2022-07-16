package AdvancedJavaPractice;

import java.util.Date;

public class TestGreeting
{
    public static void main(String[] args)
    {
        Greeting obj = new SpanishGreeing();
        System.out.println("Greetings in Spanish : " +obj.greeting("Priyanka"));

        Greeting obj1 = name -> "Hello " + name;
        System.out.println("Greetings in English : " +obj1.greeting("Priya!"));

        Greeting obj2 = name -> "Namaste" + name;
        System.out.println("Greetings in Telugu : " +obj2.greeting("Preethy!"));

        // Method reference only if method is static -- class name::method name
        Greeting greet = TestGreeting::greetings;

        // Method reference if method is not static -- object name::method name
        TestGreeting testGreeting = new TestGreeting();
        Greeting greet1 = testGreeting::greetings1;
        Quote quote1 = (langEnum, date) ->
        {
            if(langEnum == LangEnum.Telugu)
            {
                return new Date() + " Fly like a butterfly and sting like bee";
            }
            return new Date() + "When there is will there is a way";
        };
    }
    public static String greetings(String name)
    {
        return "Bonjour" + name;
    }
    public String greetings1(String name)
    {
        return "Bonjour" + name;
    }
}
