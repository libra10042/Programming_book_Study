package example;

import java.util.Arrays;
import java.util.List;

public class Menu_findMatching {

    public static void main(String[] args) {
        List<Dish> menu3 = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 800, Dish.Type.MEAT),
                new Dish("chicken", false, 800, Dish.Type.MEAT),
                new Dish("rice", false, 800, Dish.Type.MEAT),
                new Dish("season", false, 800, Dish.Type.MEAT),
                new Dish("pizza", false, 800, Dish.Type.MEAT),
                new Dish("prawns", false, 800, Dish.Type.MEAT),
                new Dish("salmon", false, 800, Dish.Type.MEAT)
        );



        // 프레디케이트가 적어도 한 요소와 일치하는지 확인.
        if(menu3.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The Menu is (somewhat) vegetarian friendly!!");
        }


    }
}
