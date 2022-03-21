package example;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Menu_FilteringSlicing {

    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 800, Dish.Type.MEAT),
                new Dish("chicken", false, 800, Dish.Type.MEAT),
                new Dish("rice", false, 800, Dish.Type.MEAT),
                new Dish("season", false, 800, Dish.Type.MEAT),
                new Dish("pizza", false, 800, Dish.Type.MEAT),
                new Dish("prawns", false, 800, Dish.Type.MEAT),
                new Dish("salmon", false, 800, Dish.Type.MEAT)
        );

        // 프레디케이트로 필터링
        List<Dish> vegetarianMenu = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());

        System.out.println(vegetarianMenu);


        // 고유 요소 필터링.
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4);
        numbers.stream()
                .filter(i -> i%2==0)
                .distinct()
                .forEach(System.out::println);

        // 스트림 축소
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
        System.out.println(dishes);


        List<Dish> dishes2 = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println(dishes2);

        // 처음 등장하는 두 고기 요로를 피터링 하시오.
        List<Dish> dishes3 = menu.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());
        System.out.println(dishes3);



        // 매핑
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);



        // 함수 길이 반환.
        List<String> words = Arrays.asList("Java8", "Lamdas", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());

        System.out.println(wordLengths);


        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(dishNameLengths);


    }



}
