package AdvancedJavaPractice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
@Builder
public class Dish
{
    private String name;
    private DishType type;
    private CusineType cusineType;
    private List<String> ingredient;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.price, price) == 0 && Objects.equals(name, dish.name) && type == dish.type && cusineType == dish.cusineType && Objects.equals(ingredient, dish.ingredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, cusineType, ingredient, price);
    }
}
