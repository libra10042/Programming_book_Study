package example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

        // 프레디케이트가 모든 요소와 일치하는지 검사
        boolean isHealthy = menu3.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);


        // noneMatch
        boolean isHealthy2 = menu3.stream()
                .noneMatch(d -> d.getCalories() >= 1000);

        System.out.println(isHealthy2);


        // findAny : 요소 검색.
        Optional<Dish> dish =
                menu3.stream()
                        .filter(Dish::isVegetarian)
                        .findAny();

        menu3.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));


        // 첫번째 요소 찾기. : 숫자 리스트에서 3으로 나누어떨어지는 첫 번째 제곱값을 반환하는 예제.
        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                        .map(x -> x * x)
                        .filter(x -> x % 3 == 0)
                        .findFirst(); // 9

    }


}
