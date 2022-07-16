package AdvancedJavaPractice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class ArrayListDemo
{
    public static void main(String[] args)
    {
        // asList --> immutable list(cannot mutate the list)
           List<String> names = Arrays.asList("Priyanka","Chris","Amy","Kobe");
        // Consumer<String> consumer = t -> System.out.println(t);
        // names.forEach(consumer);
        // names.forEach(n-> System.out.println(n));
        // method reference
           names.forEach(System.out::println);
           System.out.println(names);
           names.sort( String::compareTo); // method reference -- sort strings in ASC order
           System.out.println(names);

           names.sort((s1,s2)->s1.length()-s2.length());// strings in arraylist sorted by length
           System.out.println(names);
        // Function(Functional interface) --> takes one type of argument converts it and returns another type
           Function<String , Integer> mapper = String::length; // replace t-> t.length() with method reference
           System.out.println(mapper.apply("Priyanka"));
        // Supplier interface --> takes no arguments but return a value
    }
}
