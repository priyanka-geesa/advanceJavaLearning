package AdvancedJavaPractice;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Run
{
    public static void main(String[] args)
    {
        List<Dish> dishes = new ArrayList<>();
        addDishes(dishes);
    //  System.out.println(dishes);
    //  creating empty collection
    //  Collections.emptyList();
    //  Stream to get unique veg dishes names
        List<String> vegUber =  dishes.stream()
                                    .filter(d -> d.getType() == DishType.VEG)
                                    .filter(d->d.getCusineType() == CusineType.INDIAN)
                                    .map(Dish::getName)
                                    .distinct()
                                    .collect(Collectors.toList());
     //   System.out.println(vegUber);
    // allMatch --> terminal method match all elements and returns a boolean
        boolean allMatch = dishes.stream().allMatch(d -> d.getType() == DishType.NON_VEG);
      //  System.out.println(allMatch);
    //  anyMatch --> terminal method match any elements and returns a boolean
        boolean anyMatch = dishes.stream().anyMatch(d -> d.getType() == DishType.NON_VEG);
     //   System.out.println(anyMatch);

    //  Optional --> wrapper on the value in optional
        Optional<Dish> first = dishes.stream()
                .filter(d -> d.getType() == DishType.VEG)
                .filter(d -> d.getCusineType() == CusineType.INDIAN).distinct().findFirst();
        if (first.isPresent()) // Avoiding any NULL Pointers
        {
      //      System.out.println(first.get());
        }

    //  count() --> returns count elements in stream
        long total = dishes.stream().count();
    //    System.out.println(total);


        List<Dish> list = dishes.stream().dropWhile(d -> d.getType() == DishType.NON_VEG).collect(Collectors.toList());
    //  System.out.println(list);

    //  map()--> collects each element & apply transformation each element one by one
        List<List<String>> shoppingList1 = dishes.stream().map(Dish::getIngredient).collect(Collectors.toList());
        System.out.println(shoppingList1);

    //  flatMap method --> terminating the existing stream & collects all elements together & apply transformation on all elements & start  a brand new stream
        List<String> shoppingList2 = dishes.stream().flatMap(dish -> dish.getIngredient().stream()).distinct().collect(Collectors.toCollection(LinkedList::new));// collect into Linked List
        System.out.println(shoppingList2);

        Map<String, Dish> collect = dishes.stream().distinct().collect(Collectors.toMap(d->d.getName(),d->d));
      //  System.out.println(collect);

        String s = dishes.stream().flatMap(dish->dish.getIngredient().stream()).distinct().collect(Collectors.joining(" | "));
      //  System.out.println(s);
       DoubleSummaryStatistics summaryStatistics =  dishes.stream().collect(Collectors.summarizingDouble(dish-> dish.getPrice()));
     //   System.out.println(summaryStatistics);

        IntSummaryStatistics statistics = Stream.of(1,2,3,4,5).collect(Collectors.summarizingInt(Integer::intValue));
      //  System.out.println(statistics);

        Map<DishType, List<Dish>> map = dishes.stream().collect(Collectors.groupingBy(Dish::getType,Collectors.toList()));
      //  System.out.println(map);

        Integer reduce = Stream.of(1,5,7,9,23).reduce(1,(a,b) -> a * b);
      //  System.out.println(reduce);


    }


    private static void addDishes(List<Dish> dishes) {
        dishes.add(
                Dish.builder()
                        .name("Butter Chicken")
                        .cusineType(CusineType.INDIAN)
                        .ingredient(Arrays.asList("Chicken","Butter","Salt","Onion","Spices"))
                        .type(DishType.NON_VEG)
                        .price(18.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("Veg Biryani")
                        .cusineType(CusineType.INDIAN)
                        .ingredient(Arrays.asList("Vegetable","Rice","Salt","Onion","Spices"))
                        .type(DishType.VEG)
                        .price(14.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("Veg Biryani")
                        .cusineType(CusineType.INDIAN)
                        .ingredient(Arrays.asList("Vegetable","Rice","Salt","Onion","Spices"))
                        .type(DishType.VEG)
                        .price(14.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("Egg Fried Rice")
                        .cusineType(CusineType.INDIAN)
                        .ingredient(Arrays.asList("Rice","Eggs","Spring Onions","Spices"))
                        .type(DishType.NON_VEG)
                        .price(12.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("Hakka Noodle")
                        .cusineType(CusineType.CHINESE)
                        .ingredient(Arrays.asList("Noodles","Soy Sauce","Salt","Spring Onions","Spices"))
                        .type(DishType.VEG)
                        .price(12.99)
                        .build()
        );
        dishes.add(
                Dish.builder()
                        .name("Chilli Chicken")
                        .cusineType(CusineType.CHINESE)
                        .ingredient(Arrays.asList("Chicken","Soy Sauce", "Salt","Onion","Spices"))
                        .type(DishType.NON_VEG)
                        .price(15.99)
                        .build()
        );
    }
}

